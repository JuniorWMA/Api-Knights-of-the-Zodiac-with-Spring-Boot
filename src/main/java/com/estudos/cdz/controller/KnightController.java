package com.estudos.cdz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.cdz.dtos.KnightDto;
import com.estudos.cdz.service.KnightService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/")
public class KnightController {
    
    @Autowired
    private KnightService service;

    @PostMapping("knight/create")
    public ResponseEntity<KnightDto> createKnight(@RequestBody KnightDto dto){
        return new ResponseEntity<KnightDto>(service.createKnightDto(dto), HttpStatus.CREATED);
    }

    @GetMapping("/knight/list")
    public ResponseEntity<Page<KnightDto>> listByKnight(@PageableDefault(size = 10, sort = "name") Pageable pageable){
        return new ResponseEntity<>(service.getAllKnightDtos(pageable), HttpStatus.OK);
    }

    @GetMapping("/knight/{idKnight}")
    public ResponseEntity<KnightDto> getKnightById(@PathVariable Long idKnight){
        return new ResponseEntity<KnightDto>(service.getKnightDtoById(idKnight), HttpStatus.OK);
    }

    @PutMapping("/knight/update/{idKnight}")
    public ResponseEntity<KnightDto> getKnowById (@PathVariable Long idKnight, @RequestBody @Valid KnightDto dto){
        
        return new ResponseEntity<KnightDto>(service.updateKnightDto(idKnight, dto), HttpStatus.OK);
    }

    @DeleteMapping("knight/delete/{idKnight}")
    public ResponseEntity<?> deleteKnight(@PathVariable Long idKnight){
        service.deleteKnightDto(idKnight);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
