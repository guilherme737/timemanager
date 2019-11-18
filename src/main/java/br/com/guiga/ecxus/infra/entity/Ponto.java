package br.com.guiga.ecxus.infra.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ponto {

    @Id
    @Column
    @SequenceGenerator(name = "seq_ponto", sequenceName = "ponto_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ponto")
    private Long id;

    @Column
    private LocalDate data;

    @Column
    private Integer horasTrabalhadas;

    @Column
    private Boolean dentroDoLimiteDeHorasPreferido;

    @ManyToOne
    private Usuario usuario;

    public Ponto() {
    }

    public Ponto(LocalDate data, Integer horasTrabalhadas, Usuario usuario) {
        this.data = data;
        this.horasTrabalhadas = horasTrabalhadas;
        this.dentroDoLimiteDeHorasPreferido = horasTrabalhadas <= usuario.getHorasDeTrabalhoPreferidasPorDia();
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Boolean getDentroDoLimiteDeHorasPreferido() {
        return dentroDoLimiteDeHorasPreferido;
    }

    public void setDentroDoLimiteDeHorasPreferido(Boolean dentroDoLimiteDeHorasPreferido) {
        this.dentroDoLimiteDeHorasPreferido = dentroDoLimiteDeHorasPreferido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
