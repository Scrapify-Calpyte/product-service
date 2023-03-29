package com.scrapify.scrapify.service;

import com.scrapify.scrapify.entity.Category;
import com.scrapify.scrapify.utils.PaginationDTO;
import com.scrapify.scrapify.utils.TableResponse;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Category findById(String id);

    List<Category> getAll();

    TableResponse getCategories(PaginationDTO pagination);
}
