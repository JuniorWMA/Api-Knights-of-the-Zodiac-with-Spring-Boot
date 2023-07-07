package com.estudos.cdz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.estudos.cdz.dtos.KnightDto;

public interface KnightService {
    
    KnightDto createKnightDto(KnightDto dto);

    Page<KnightDto> getAllKnightDtos(Pageable pageable);

    KnightDto getKnightDtoById(Long idKnight);

    KnightDto updateKnightDto(Long idKnight, KnightDto knightDto);

    void deleteKnightDto(Long idKnight);

}
