package com.estudos.cdz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.estudos.cdz.dtos.ArmorDto;


public interface ArmorService {
    
    ArmorDto createArmorDto(ArmorDto dto);

    Page<ArmorDto> getAllArmorsDto(Pageable pageable);

    ArmorDto getArmorDtoById(Long idArmor);

    ArmorDto updateArmorDto(Long idArmor, ArmorDto armorDto);

    void deleteArmorDto(Long idArmor);
}
