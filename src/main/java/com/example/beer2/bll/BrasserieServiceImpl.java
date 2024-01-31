package com.example.beer2.bll;

import com.example.beer2.bo.Biere;
import com.example.beer2.bo.Brasserie;
import com.example.beer2.dal.BiereDAO;
import com.example.beer2.dal.BrasserieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrasserieServiceImpl implements BrasserieService{

    @Autowired
    BrasserieDAO brasserieDAO;
    @Autowired
    BiereDAO biereDAO;

    @Override
    public void addBrasserie(Brasserie brasserie) throws BrasserieServiceException {
        brasserieDAO.ajouterBrasserie(brasserie);
    }

    @Override
    public void addBiere(Biere biere) throws BrasserieServiceException {
        biereDAO.ajouterBiere(biere);
    }

    @Override
    public List<Brasserie> getAllBrasserie() {
        return brasserieDAO.listerBrasserie();
    }

    @Override
    public List<Biere> getAllBiere() {
        return biereDAO.listerBiere();
    }
}
