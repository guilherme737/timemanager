package br.com.guiga.ecxus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @Column
    private Long id;

    @Column
    private String nome;
}
