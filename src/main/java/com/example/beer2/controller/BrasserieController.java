package com.example.beer2.controller;

import com.example.beer2.bll.BrasserieService;
import com.example.beer2.bll.BrasserieServiceException;
import com.example.beer2.bo.Brasserie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/brasserie")
public class BrasserieController {

    @Autowired
    BrasserieService brasserieService;

    @ModelAttribute("lstBrasserie")
    private List<Brasserie> getListBrasserie(){
        return brasserieService.getAllBrasserie();
    }

    @GetMapping
    public String init(Brasserie brasserie) {
        return "qsdf";
    }

    @PostMapping
    public String valid(@Valid Brasserie brasserie, BindingResult errors, Model model) {
        if(errors.hasErrors()) {
            return "qsdf";
        }

        try {
            brasserieService.addBrasserie(brasserie);
        } catch (BrasserieServiceException e) {
            e.printStackTrace();
        }
        return "redirect:/brasserie";
    }

}
