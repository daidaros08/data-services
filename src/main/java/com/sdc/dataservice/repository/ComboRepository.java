package com.sdc.dataservice.repository;

import org.springframework.stereotype.Repository;
import com.sdc.dataservice.model.Combo;

@Repository
public interface ComboRepository extends AbstractRepository<Combo, String> {
}
