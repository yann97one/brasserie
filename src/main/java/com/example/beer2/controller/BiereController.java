package com.example.beer2.controller;

import ch.qos.logback.core.model.Model;
import com.example.beer2.bll.BrasserieService;
import com.example.beer2.bll.BrasserieServiceException;
import com.example.beer2.bo.Biere;
import com.example.beer2.bo.TypeBiere;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/biere")
@SessionAttributes("lstTypeBiere")
public class BiereController {

    @Autowired
    BrasserieService brasserieService;

    @ModelAttribute("lstBiere")
    private List<Biere> getListBiere() {
        return brasserieService.getAllBiere();
    }

    @ModelAttribute("lstTypeBiere")
    private List<TypeBiere> getListTypeBiere() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        System.out.println(TypeBiere.lstTypeBiere());
        return TypeBiere.lstTypeBiere();

    }

    @GetMapping
    public String init(Biere biere) {
        return "azer";
    }

    @PostMapping
    public String valid(@Valid Biere biere, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "azer";
        }

        try {
            brasserieService.addBiere(biere);
        } catch (BrasserieServiceException e) {
            e.printStackTrace();
        }
        return "redirect:/biere";
    }

}
