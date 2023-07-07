package com.estudos.cdz.models;

import com.estudos.cdz.dtos.ArmorDto;
import com.estudos.cdz.enums.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ARMORS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArmor;
    @NotBlank
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotNull
    private Integer resistence;

    public Armor(ArmorDto dto) {
        this.name = dto.name();
        this.category = dto.category();
        this.resistence = dto.resistence();
    }

    

    
}
