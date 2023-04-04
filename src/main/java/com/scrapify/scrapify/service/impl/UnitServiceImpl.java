package com.scrapify.scrapify.service.impl;

import com.scrapify.scrapify.entity.Unit;
import com.scrapify.scrapify.repository.UnitRepository;
import com.scrapify.scrapify.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Unit save(Unit unit) {
//        m(kg) = m(t) × 1000
        return unitRepository.save(unit);
    }

    @Override
    public List<Unit> getAll() {
        return unitRepository.findAll();
    }
}
