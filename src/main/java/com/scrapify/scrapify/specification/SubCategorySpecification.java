package com.scrapify.scrapify.specification;


import com.scrapify.scrapify.entity.Category;
import com.scrapify.scrapify.entity.SubCategory;
import com.scrapify.scrapify.utils.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SubCategorySpecification extends BaseSpecification implements Specification<SubCategory> {
    private SearchCriteria criteria;

    public SubCategorySpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<SubCategory> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getKey().contains(".")) {
            String join = criteria.getKey().split("\\.")[0];
            if (join.equalsIgnoreCase("category")) {
                Join<SubCategory, Category> categoryJoin = root.join("category");
                criteria.setKey(criteria.getKey().split("\\.")[1]);
                return getPredicate(criteria, categoryJoin, query, builder);
            }
        }
        return getPredicate(criteria, root, query, builder);
    }
}
