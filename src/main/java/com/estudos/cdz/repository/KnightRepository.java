package com.estudos.cdz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.cdz.models.Knight;
@Repository
public interface KnightRepository  extends JpaRepository<Knight, Long>{
    
}
