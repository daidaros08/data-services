package com.sdc.dataservice.service;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.sdc.data.service.BaseService;
import com.sdc.data.service.pagination.PaginatedResult;
import com.sdc.dataservice.model.Grill;
import com.sdc.dataservice.repository.GrillRepository;

public class GrillService extends BaseService<Grill, GrillRepository> {

    public GrillService(GrillRepository repository) {
        super(Grill.class, repository);
    }

    public PaginatedResult<Grill> getAllGrills(Integer offset, Integer limit, String sortField, String sortDirection) {
        PageRequest pageRequest = getPage(offset, limit, sortField, sortDirection);
        Page page = getAll(pageRequest);
        return new PaginatedResult<>(page);
    }

    public Grill createGrill(Grill grill) {
        if (Objects.isNull(grill.getId())) {
            grill.setId(generateID());
        }
        return create(grill);
    }
}
