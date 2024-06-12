package ru.naburnm8.bmstu.datamanagementnirbackend.models;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Supply {
    @Id
    @GeneratedValue
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateOfArrival;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Catalogue item;

    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
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
