package com.scrapify.scrapify.service.impl;

import com.scrapify.scrapify.entity.Region;
import com.scrapify.scrapify.repository.RegionRepository;
import com.scrapify.scrapify.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }
}
