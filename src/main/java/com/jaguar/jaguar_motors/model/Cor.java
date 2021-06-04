package com.jaguar.jaguar_motors.model;

import javax.persistence.*;

@Entity
public class Cor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String cor;
}
