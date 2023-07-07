package com.estudos.cdz.models;

import com.estudos.cdz.dtos.KnightDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "knights")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Knight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idknight;
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Size(max = 50)
    private String nacionality;
    @NotNull
    @Positive
    private Integer power;

    
    public Knight(KnightDto dto) {
        this.name = dto.name();
        this.nacionality = dto.nacionality();
        this.power = dto.power();
    }

    
}
