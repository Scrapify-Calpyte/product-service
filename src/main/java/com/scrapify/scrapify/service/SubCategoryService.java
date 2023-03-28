package com.scrapify.scrapify.service;

import com.scrapify.scrapify.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {

    SubCategory save(SubCategory subCategory);

    SubCategory findById(String id);

    List<SubCategory> getAll();
}
