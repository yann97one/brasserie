package com.example.beer2.bo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brasserie {
    private Integer id_brasserie;
    @NotEmpty(message = "Il manque le nom")
    private String nom;
    @NotEmpty(message = "Il manque l'adresse")
    private String adresse;
    @NotEmpty(message = "Il manque les coordonnées GPS")
    private String coord_gps;
    @NotNull
    private LocalDate dt_ouverture;

}
