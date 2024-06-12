package ru.naburnm8.bmstu.datamanagementnirbackend.models;

import jakarta.persistence.*;

@Entity
public class Storage {

    @Id
    @GeneratedValue
    private int idItem;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Catalogue item;

    private int quantity;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Catalogue getItem() {
        return item;
    }

    public void setItem(Catalogue item) {
        this.item = item;
    }
}
