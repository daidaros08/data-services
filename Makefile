
APP_NAME=data-service
BUILD_DIR=build
DOCKER_IMAGE=$(APP_NAME):latest
JAR_FILE=$(BUILD_DIR)/libs/$(APP_NAME)-*.jar

.PHONY: all
all: build

.PHONY: build
build:
	./gradlew clean build -x test

.PHONY: docker
docker: build
	docker build -t $(DOCKER_IMAGE) .

.PHONY: run
run:
	java -jar $(JAR_FILE)

.PHONY: run-docker
run-docker:
	docker run -p 8080:8080 $(DOCKER_IMAGE)

.PHONY: clean
clean:
	./gradlew clean
	rm -rf $(BUILD_DIR)

.PHONY: build-and-run
build-and-run: docker run-docker

.PHONY: status
status:
	docker ps
