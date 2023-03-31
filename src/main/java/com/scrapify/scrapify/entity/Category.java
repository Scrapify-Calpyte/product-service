package com.scrapify.scrapify.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Category extends AuditableBase{
    private String name;
    private String code;
    private String description;
    private String image;
}
