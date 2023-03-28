package com.scrapify.scrapify.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends AuditableBase{
    private String name;
    private String code;
}
