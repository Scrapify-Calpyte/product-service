package com.scrapify.scrapify.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Category extends IdentifiableBase{
    private String name;
    private boolean isActive;
}
