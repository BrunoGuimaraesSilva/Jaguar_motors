package com.jaguar.jaguar_motors.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cor cor;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy")
    private LocalDate ano_modelo;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy")
    private LocalDate ano_fabricacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Usuario usuario;

    @Column(nullable = false)
    private String foto;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
