package ru.naburnm8.bmstu.datamanagementnirbackend.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Catalogue item;
    private int qItem;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfTransaction;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Clients client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getqItem() {
        return qItem;
    }

    public void setqItem(int qItem) {
        this.qItem = qItem;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }


    public Catalogue getItem() {
        return item;
    }

    public void setItem(Catalogue item) {
        this.item = item;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
