package com.sdc.dataservice.service;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.sdc.data.service.BaseService;
import com.sdc.data.service.pagination.PaginatedResult;
import com.sdc.dataservice.model.Empanada;
import com.sdc.dataservice.repository.EmpanadaRepository;

public class EmpanadaService extends BaseService<Empanada, EmpanadaRepository> {

    public EmpanadaService(EmpanadaRepository empanadaRepository) {
        super(Empanada.class, empanadaRepository);
    }

    public PaginatedResult<Empanada> getAllEmpanadas(Integer offset, Integer limit, String sortField, String sortDirection) {
        PageRequest pageRequest = getPage(offset, limit, sortField, sortDirection);
        Page page = getAll(pageRequest);
        return new PaginatedResult<>(page);
    }

    public Empanada createEmpanada(Empanada empanada) {
        if (Objects.isNull(empanada.getId())) {
            empanada.setId(generateID());
        }
        return create(empanada);
    }
}
