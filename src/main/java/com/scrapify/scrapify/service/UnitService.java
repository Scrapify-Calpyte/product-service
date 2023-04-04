package com.scrapify.scrapify.service;

import com.scrapify.scrapify.entity.Unit;

import java.util.List;

public interface UnitService {
    Unit save(Unit unit);

    List<Unit> getAll();
}
