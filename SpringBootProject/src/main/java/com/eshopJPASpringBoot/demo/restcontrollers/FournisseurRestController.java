package com.eshopJPASpringBoot.demo.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshopJPASpringBoot.demo.dto.requests.FournisseurRequest;
import com.eshopJPASpringBoot.demo.dto.responses.FournisseurResponse;
import com.eshopJPASpringBoot.demo.dto.responses.JsonViews;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.services.FournisseurSerivce;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurRestController {

    @Autowired
    FournisseurSerivce fournisseurSerivce;

    @GetMapping("/{id}")
    @JsonView(JsonViews.Fournisseur.class)
    public FournisseurResponse getIdFournisseur(@PathVariable Integer id) {
        return new FournisseurResponse(fournisseurSerivce.findById(id), true);
    }

    @GetMapping("/{id}/produits")
    @JsonView(JsonViews.FournisseurAvecProduits.class)
    public FournisseurResponse getIdFournisseurWithProducts(@PathVariable Long id) {
        return new FournisseurResponse(fournisseurSerivce.findByIdWithProduit(id));
    }

    @PostMapping("/")
    public FournisseurResponse createFournisseur(@RequestBody FournisseurRequest fournisseurRequest) {
        Fournisseur fournisseur = new Fournisseur();
        BeanUtils.copyProperties(fournisseurRequest, fournisseur);
        return new FournisseurResponse(fournisseurSerivce.creationFournisseur(fournisseur), true);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Fournisseur.class)
    public FournisseurResponse updateFournisseur(@PathVariable Integer id, @RequestBody Fournisseur fournisseur) {
        fournisseur.setId(id);
        return new FournisseurResponse(fournisseurSerivce.updateFournisseur(fournisseur));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteFournisseurById(@PathVariable Integer id) {
        fournisseurSerivce.delete(id);
    }

}
