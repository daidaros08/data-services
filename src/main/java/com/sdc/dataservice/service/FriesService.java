package com.sdc.dataservice.service;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.sdc.data.service.BaseService;
import com.sdc.data.service.pagination.PaginatedResult;
import com.sdc.dataservice.model.Fries;
import com.sdc.dataservice.repository.FriesRepository;

public class FriesService extends BaseService<Fries, FriesRepository> {

    public FriesService(FriesRepository repository) {
        super(Fries.class, repository);
    }

    public PaginatedResult<Fries> getAllFries(Integer offset, Integer limit, String sortField, String sortDirection) {
        PageRequest pageRequest = getPage(offset, limit, sortField, sortDirection);
        Page page = getAll(pageRequest);
        return new PaginatedResult<>(page);
    }

    public Fries createFries(Fries fries) {
        if (Objects.isNull(fries.getId())) {
            fries.setId(generateID());
        }
        return create(fries);
    }
}
