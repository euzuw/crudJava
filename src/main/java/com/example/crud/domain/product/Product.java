package com.example.crud.domain.product;


import jakarta.persistence.*;

@Table(name = "product")
@Entity(name = "product")
public class Product {

    //Diz que id é gerado automaticamente e o tipo de geração será
    //de um UUID aleatório
    @Id @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_in_cents")
    private Integer priceInCents;

    public Product(String name, Integer priceInCents) {
        this.name = name;
        this.priceInCents = priceInCents;
    }


    public Product() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
    }
}