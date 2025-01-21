package com.sdc.dataservice.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import com.sdc.data.exception.mapper.BadRequesExceptionMapper;
import com.sdc.data.exception.mapper.BaseExceptionMapper;
import com.sdc.data.exception.mapper.ConstraintViolationExceptionMapper;
import com.sdc.data.exception.mapper.EntityAlreadyExistExceptionMapper;
import com.sdc.data.exception.mapper.EntityNotFoundExceptionMapper;
import com.sdc.dataservice.repository.ComboRepository;
import com.sdc.dataservice.repository.DrinksRepository;
import com.sdc.dataservice.repository.EmpanadaRepository;
import com.sdc.dataservice.repository.FriesRepository;
import com.sdc.dataservice.repository.GrillRepository;
import com.sdc.dataservice.resource.implementation.ComboResource;
import com.sdc.dataservice.resource.implementation.DrinkResource;
import com.sdc.dataservice.resource.implementation.EmpanadaResource;
import com.sdc.dataservice.resource.implementation.FriesResource;
import com.sdc.dataservice.resource.implementation.GrillResource;
import com.sdc.dataservice.service.ComboService;
import com.sdc.dataservice.service.DrinksService;
import com.sdc.dataservice.service.EmpanadaService;
import com.sdc.dataservice.service.FriesService;
import com.sdc.dataservice.service.GrillService;

@Configuration
@ApplicationPath("${spring.jersey.application-path}")
@EnableMongoAuditing
public class DataConfiguration extends ResourceConfig {

    public DataConfiguration() {
        register(BadRequesExceptionMapper.class);
        register(BaseExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
        register(EntityAlreadyExistExceptionMapper.class);
        register(EntityNotFoundExceptionMapper.class);


        register(ComboResource.class);
        register(DrinkResource.class);
        register(EmpanadaResource.class);
        register(FriesResource.class);
        register(GrillResource.class);
    }

    @Bean()
    public ComboService comboService(ComboRepository repo) {
        return new ComboService(repo);
    }

    @Bean()
    public DrinksService drinksService(DrinksRepository repo) {
        return new DrinksService(repo);
    }

    @Bean
    public EmpanadaService empanadaService(EmpanadaRepository repo) {
        return new EmpanadaService(repo);
    }

    @Bean
    public FriesService friesService(FriesRepository repo) {
        return new FriesService(repo);
    }

    @Bean
    public GrillService grillService(GrillRepository repo) {
        return new GrillService(repo);
    }
    }
