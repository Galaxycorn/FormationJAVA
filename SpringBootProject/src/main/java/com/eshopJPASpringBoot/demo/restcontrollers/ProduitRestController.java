package com.eshopJPASpringBoot.demo.restcontrollers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshopJPASpringBoot.demo.dto.requests.FournisseurRequest;
import com.eshopJPASpringBoot.demo.dto.requests.ProduitRequest;
import com.eshopJPASpringBoot.demo.dto.responses.FournisseurResponse;
import com.eshopJPASpringBoot.demo.dto.responses.JsonViews;
import com.eshopJPASpringBoot.demo.dto.responses.ProduitResponse;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.services.ProduitService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

    @GetMapping("/all")
    @JsonView(JsonViews.Basic.class)
    public List<ProduitResponse> getAllProduit() {
        return produitService.getAllProduits().stream().map(ProduitResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Produit.class)
    public ProduitResponse getProduitById(@PathVariable Long id) {
        return new ProduitResponse(produitService.findByNumero(id));
    }

    @PostMapping("/")
    public ProduitResponse createProduit(@RequestBody ProduitRequest produitRequest) {
        Produit produit = new Produit();
        BeanUtils.copyProperties(produitRequest, produit);
        return new ProduitResponse(produitService.creationProduit(produit));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Produit.class)
    public ProduitResponse updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        produit.setNumero(id);
        return new ProduitResponse(produitService.updateProduit(produit));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduitById(@PathVariable Long id) {
        produitService.deleteProduit(produitService.findByNumero(id));
    }

}
