package com.example.beer2.bll;

import com.example.beer2.bo.Biere;
import com.example.beer2.bo.Brasserie;

import java.util.List;

public interface BrasserieService {

    public void addBrasserie(Brasserie brasserie) throws BrasserieServiceException;
    public void addBiere(Biere biere) throws BrasserieServiceException;
    public List<Brasserie> getAllBrasserie();
    public List<Biere> getAllBiere();
}
