package com.estudos.cdz.controller;

import java.net.URI;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.estudos.cdz.dtos.ArmorDto;
import com.estudos.cdz.service.ArmorService;

@RestController
@RequestMapping("api/")
public class ArmorController {
    @Autowired
    private ArmorService service;

    @PostMapping("armor/create")
    public ResponseEntity<ArmorDto> createArmor(@RequestBody ArmorDto armorDto, UriComponentsBuilder uriComponentsBuilder){
        var armor = service.createArmorDto(armorDto);
        URI uri = uriComponentsBuilder.path("{idArmor}").buildAndExpand(armor).toUri();
        return ResponseEntity.created(uri).body(armor);
    }

    @GetMapping("armor/list")
    public ResponseEntity<Page<ArmorDto>> listByArmor(@PageableDefault(size = 10, sort = "name") Pageable pageable){
        return new ResponseEntity<Page<ArmorDto>>(service.getAllArmorsDto(pageable), HttpStatus.OK);
    }

    @GetMapping("armor/{idArmor}")
    public ResponseEntity<ArmorDto> getArmorDtoId(@PathVariable("idArmor") Long idArmor){
        return new ResponseEntity<ArmorDto>(service.getArmorDtoById(idArmor), HttpStatus.OK);
    }

    @PutMapping("armor/update/{idArmor}")
    public ResponseEntity<ArmorDto> updateArmor (@PathVariable Long idArmor, @RequestBody ArmorDto armorDto){
        return new ResponseEntity<ArmorDto>(service.updateArmorDto(idArmor, armorDto), HttpStatus.OK);
    }

    @DeleteMapping("armor/delete/{idArmor}")
    public ResponseEntity<?> deleteArmor (@PathVariable("idArmor") Long idArmor){
        service.deleteArmorDto(idArmor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
