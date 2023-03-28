package com.scrapify.scrapify.service.impl;

import com.scrapify.scrapify.entity.SubCategory;
import com.scrapify.scrapify.repository.SubCategoryRepository;
import com.scrapify.scrapify.service.SubCategoryService;
import com.scrapify.scrapify.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory save(SubCategory subCategory) {
        Mapper.setAuditable(subCategory);
        subCategoryRepository.save(subCategory);
        return subCategory;
    }

    @Override
    public SubCategory findById(String id) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(id);
        return subCategory.orElse(null);
    }

    @Override
    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }
}
