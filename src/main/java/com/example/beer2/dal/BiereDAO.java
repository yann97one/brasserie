package com.example.beer2.dal;
import com.example.beer2.bo.Biere;

import java.util.List;

public interface BiereDAO {
    public void ajouterBiere(Biere biere);
    public List<Biere> listerBiere();
    public List<Biere> listerBiereBrasserie(Integer idBrasserie);

}
