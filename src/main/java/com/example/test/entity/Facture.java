package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idFacture;
    private float monatantRemise;
    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    private Boolean active;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "facture")
    private List<DetailFacture> detailFactureList;


}