package com.example.journal.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="order_itme")
public class OrderItme {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ordername;

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderqt() {
        return orderqt;
    }

    public void setOrderqt(String orderqt) {
        this.orderqt = orderqt;
    }

    @Column(nullable = false)
    private String orderqt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
