package com.example.beer2.dal;

import com.example.beer2.bo.Brasserie;

import java.util.List;

public interface BrasserieDAO {
    public List<Brasserie> listerBrasserie();

    public List<Brasserie> listerBrasserieIPA();
    public void ajouterBrasserie(Brasserie brasserie);

}
