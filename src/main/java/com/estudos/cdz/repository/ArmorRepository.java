package com.estudos.cdz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.cdz.models.Armor;

public interface ArmorRepository extends JpaRepository<Armor, Long> {
    
}
