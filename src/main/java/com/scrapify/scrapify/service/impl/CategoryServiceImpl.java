package com.scrapify.scrapify.service.impl;

import com.scrapify.scrapify.entity.Category;
import com.scrapify.scrapify.repository.CategoryRepository;
import com.scrapify.scrapify.service.CategoryService;
import com.scrapify.scrapify.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        Mapper.setAuditable(category);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category findById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
