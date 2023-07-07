package com.estudos.cdz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudos.cdz.dtos.KnightDto;
import com.estudos.cdz.exceptions.KnightException;
import com.estudos.cdz.models.Knight;
import com.estudos.cdz.repository.KnightRepository;

@Service
public class KnightServiceImpl implements KnightService{

    @Autowired
    private KnightRepository repository;

    @Override
    public KnightDto createKnightDto(KnightDto dto) {
        Knight knight = new Knight(dto);
        repository.save(knight);
        KnightDto kDto = new KnightDto(knight);
        return kDto;
    }

    @Override
    public Page<KnightDto> getAllKnightDtos(Pageable pageable) {
        return repository.findAll(pageable).map(p -> new KnightDto(p));
    }

    @Override
    public KnightDto getKnightDtoById(Long idKnight) {
        Knight knight = repository.findById(idKnight).orElseThrow(() -> new KnightException("Knight could't be found"));
        KnightDto kDto = new KnightDto(knight);
        return kDto;
    }

    @Override
    public KnightDto updateKnightDto(Long idKnight, KnightDto knightDto) {
        Knight knight = repository.findById(idKnight).orElseThrow(() -> new KnightException("Knight id not be found"));
        knight.setName(knightDto.name());
        knight.setNacionality(knightDto.nacionality());
        knight.setPower(knightDto.power());

        KnightDto kDto = new KnightDto(knight);
        return kDto;
    }

    @Override
    public void deleteKnightDto(Long idKnight) {
        var getId = repository.findById(idKnight).orElseThrow(() -> new KnightException("Id Not find."));
        repository.delete(getId);
    }

    
    
}
