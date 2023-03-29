package com.scrapify.scrapify.service.impl;

import com.scrapify.scrapify.entity.Category;
import com.scrapify.scrapify.entity.SubCategory;
import com.scrapify.scrapify.repository.SubCategoryRepository;
import com.scrapify.scrapify.service.SubCategoryService;
import com.scrapify.scrapify.specification.CategorySpecification;
import com.scrapify.scrapify.specification.SubCategorySpecification;
import com.scrapify.scrapify.utils.Mapper;
import com.scrapify.scrapify.utils.PaginationDTO;
import com.scrapify.scrapify.utils.SearchCriteria;
import com.scrapify.scrapify.utils.TableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public TableResponse getSubCategories(PaginationDTO pagination) {
        TableResponse response;
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        Page<SubCategory> subCategoryPage = subCategoryRepository.findAll(getSpecifications(pagination), paging);
        if (subCategoryPage.hasContent()) {
            List<SubCategory> eSubcategoryList = subCategoryPage.getContent();
            response = new TableResponse(pagination.getDraw(), (int) subCategoryPage.getTotalElements(), (int) subCategoryPage.getTotalElements(),
                    eSubcategoryList);
        } else {
            response = new TableResponse(pagination.getDraw(), (int) subCategoryPage.getTotalElements(), (int) subCategoryPage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }

    private Specification<SubCategory> getSpecifications(PaginationDTO pagination) {
        List<SearchCriteria> params = new ArrayList<>(pagination.getFilter());
        if (params.size() == 0) {
            return null;
        }
        List<Specification<SubCategory>> specs = params.stream().map(SubCategorySpecification::new).collect(Collectors.toList());
        Specification<SubCategory> result = specs.get(0);
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate() ? Specification.where(result).or(specs.get(i)) : Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
