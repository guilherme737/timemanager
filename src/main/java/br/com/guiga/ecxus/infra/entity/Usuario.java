package br.com.guiga.ecxus.infra.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    public enum Permissao {USUARIO, GERENTE, ADMIN}

    @Id
    @Column
    @SequenceGenerator(name = "seq_usuario", sequenceName = "usuario_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    @Column()
    private String nome;

    @NotNull(message = "Login é obrigatório")
    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private Integer horasDeTrabalhoPreferidasPorDia;

    @Column
    private Permissao permissao;

    public Usuario() {

    }

    public Usuario(String nome, String login, String senha, Integer horasDeTrabalhoPreferidasPorDia, Permissao permissao) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.horasDeTrabalhoPreferidasPorDia = horasDeTrabalhoPreferidasPorDia;
        this.permissao = permissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getHorasDeTrabalhoPreferidasPorDia() {
        return horasDeTrabalhoPreferidasPorDia;
    }

    public void setHorasDeTrabalhoPreferidasPorDia(Integer horasDeTrabalhoPreferidasPorDia) {
        this.horasDeTrabalhoPreferidasPorDia = horasDeTrabalhoPreferidasPorDia;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
