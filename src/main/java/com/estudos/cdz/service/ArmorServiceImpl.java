package com.estudos.cdz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudos.cdz.dtos.ArmorDto;
import com.estudos.cdz.exceptions.ArmorException;
import com.estudos.cdz.models.Armor;
import com.estudos.cdz.repository.ArmorRepository;

@Service
public class ArmorServiceImpl implements ArmorService {

    @Autowired
    private ArmorRepository repository;

    @Override
    public ArmorDto createArmorDto(ArmorDto dto) {
        Armor armor = new Armor(dto);
        repository.save(armor);
        ArmorDto armorDto = new ArmorDto(armor);
        return armorDto;
    }

    @Override
    public Page<ArmorDto> getAllArmorsDto(Pageable pageable) {
        return repository.findAll(pageable).map(p -> new ArmorDto(p));
        
    }

    @Override
    public ArmorDto getArmorDtoById(Long idArmor) {
        Armor armor = repository.findById(idArmor).orElseThrow(() -> new ArmorException("Armor not found"));
        Armor armor2 = repository.findById(idArmor).get();
        return new ArmorDto(armor2);
    }

    @Override
    public ArmorDto updateArmorDto(Long idArmor, ArmorDto armorDto) {
        Armor armor = repository.findById(idArmor).orElseThrow(() -> new ArmorException("Armor not found"));
        armor.setName(armorDto.name());
        armor.setCategory(armorDto.category());
        armor.setResistence(armorDto.resistence());
        repository.save(armor);
        
        return new ArmorDto(armor);
    }

    @Override
    public void deleteArmorDto(Long idArmor) {
        Armor armor = repository.findById(idArmor).orElseThrow(() -> new ArmorException("Armor not found"));
        Armor armor2 = repository.findById(idArmor).get();
        repository.delete(armor2);
    }
    
}
