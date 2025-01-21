package com.sdc.dataservice.service;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.sdc.data.service.BaseService;
import com.sdc.data.service.pagination.PaginatedResult;
import com.sdc.dataservice.model.Drinks;
import com.sdc.dataservice.repository.DrinksRepository;

public class DrinksService extends BaseService<Drinks, DrinksRepository>{

    public DrinksService(DrinksRepository repository) {
        super(Drinks.class, repository);
    }

    public PaginatedResult<Drinks> getAllDrinks(Integer offset, Integer limit, String sortField, String sortDirection) {
        PageRequest pageRequest = getPage(offset, limit, sortField, sortDirection);
        Page page = getAll(pageRequest);
        return new PaginatedResult(page);
    }

    public Drinks createDrink(Drinks drink) {
        if (Objects.isNull(drink.getId())) {
            drink.setId(generateID());
        }
        return create(drink);
    }
}
