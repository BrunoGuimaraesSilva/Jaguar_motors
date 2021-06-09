package com.jaguar.jaguar_motors.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Erro ao salvar o id_marca")
    @JoinColumn(nullable = false)
    private Integer id_marca;

    @NotNull(message = "Erro ao salvar o id_cor")
    @JoinColumn(nullable = false)
    private Integer id_cor;

    @NotNull(message = "Erro ao salvar o modelo")
    @Column(nullable = false)
    private String modelo;

    @NotNull(message = "Erro ao salvar o ano_modelo")
    @Column(nullable = false)
    private Date ano_modelo;

    @NotNull(message = "Erro ao salvar o ano_fabricacao")
    @Column(nullable = false)
    private Date ano_fabricacao;

    @NotNull(message = "Erro ao salvar o valor")
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull(message = "Erro ao salvar o id_usuario")
    @JoinColumn(nullable = false, unique = true)
    private Integer id_usuario;

    @NotNull(message = "Erro ao salvar a foto")
    @Column(nullable = true)
    private String foto;

    @NotNull(message = "Erro ao salvar o tipo")
    private Integer id_tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public Integer getId_cor() {
        return id_cor;
    }

    public void setId_cor(Integer id_cor) {
        this.id_cor = id_cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(Date ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public Date getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(Date ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }
}
