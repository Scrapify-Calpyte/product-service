package com.scrapify.scrapify.service;

import com.scrapify.scrapify.entity.Region;

import java.util.List;

public interface RegionService {
    Region save(Region region);

    List<Region> getAll();
}
