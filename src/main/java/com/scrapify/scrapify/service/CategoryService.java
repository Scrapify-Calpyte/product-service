package com.scrapify.scrapify.service;

import com.scrapify.scrapify.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Category findById(String id);

    List<Category> getAll();
}
