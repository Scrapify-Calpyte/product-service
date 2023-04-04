package com.scrapify.scrapify.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Region extends IdentifiableBase{
    private String name;
}
