package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prixUnitaire ;

    @OneToMany(mappedBy = "produit")
    private List<DetailFacture> detailFactureList;

    @OneToOne(mappedBy = "produit",cascade = CascadeType.PERSIST)
    private DetailProduit detailProduit;

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Rayon rayon;

    @ManyToMany
    private List<Fournisseur> fournisseurs;

}
