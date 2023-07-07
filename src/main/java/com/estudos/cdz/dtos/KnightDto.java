package com.estudos.cdz.dtos;

import com.estudos.cdz.models.Knight;

public record KnightDto(String name, String nacionality, Integer power) {
    public KnightDto(Knight knight){
        this(knight.getName(), knight.getNacionality(), knight.getPower());
    }
}
