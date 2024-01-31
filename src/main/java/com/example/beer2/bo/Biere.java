package com.example.beer2.bo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Biere {
    private Integer id_biere;
    @NotEmpty(message = "Il manque le nom")
    private String nom;

    @NotNull(message = "Il manque le Type de biere")
    private TypeBiere ty_biere;

    @NotEmpty(message = "Il manque la description")
    private String description;

    @Min(value = 0,message = "La valeur doit être positive")
    @Max(value=40,message = "Pas plus de 40 degrés")
    private double dg_alcool;

    @Min(value = 0,message = "La valeur doit être positive")
    private int note;

    @NotNull(message="Une bière doit avoir une brasserie")
    private Brasserie brasserie;
}
