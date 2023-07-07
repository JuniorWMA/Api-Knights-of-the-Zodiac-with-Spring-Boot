package com.estudos.cdz.dtos;

import com.estudos.cdz.enums.Category;
import com.estudos.cdz.models.Armor;

public record ArmorDto(String name, Category category, Integer resistence) {
    public ArmorDto(Armor armor){
        this(armor.getName(), armor.getCategory(), armor.getResistence());
    }
    
}
