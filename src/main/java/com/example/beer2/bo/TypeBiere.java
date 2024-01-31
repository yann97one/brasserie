package com.example.beer2.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor

public enum TypeBiere {
    BRUNE("Brune"),
    BLONDE("Blonde"),
    BLANCHE("Blanche"),
    AMBREE("Ambrée");

    private String typeOfBeer;

    public static List<TypeBiere> lstTypeBiere(){
        return List.of(TypeBiere.values());
    }


}
