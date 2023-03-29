package com.scrapify.scrapify.specification;


import com.scrapify.scrapify.entity.Category;
import com.scrapify.scrapify.utils.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class CategorySpecification extends BaseSpecification implements Specification<Category> {
    private SearchCriteria criteria;

    public CategorySpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return getPredicate(criteria, root, query, builder);
    }
}
