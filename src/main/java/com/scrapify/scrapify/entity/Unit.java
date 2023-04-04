package com.scrapify.scrapify.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "unit")
public class Unit extends IdentifiableBase{
    private String name;
    private Double kgConversion;
}
