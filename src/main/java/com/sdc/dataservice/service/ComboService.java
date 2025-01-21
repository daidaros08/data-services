package com.sdc.dataservice.service;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.sdc.data.service.BaseService;
import com.sdc.data.service.pagination.PaginatedResult;
import com.sdc.dataservice.model.Combo;
import com.sdc.dataservice.repository.ComboRepository;

public class ComboService extends BaseService<Combo, ComboRepository> {

    public ComboService(ComboRepository repository) {
        super(Combo.class, repository);
    }

    public PaginatedResult<Combo> getAllCombos( Integer offset, Integer limit, String sortField, String sortDirection) {
        PageRequest pageRequest = getPage(offset, limit, sortField, sortDirection);
        Page page = getAll(pageRequest);
        return new PaginatedResult(page);
    }

    public Combo createCombo(Combo combo) {
        if (Objects.isNull(combo.getId())) {
            combo.setId(generateID());
        }
        return create(combo);
    }
}
