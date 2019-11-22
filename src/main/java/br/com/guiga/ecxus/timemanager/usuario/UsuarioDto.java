package br.com.guiga.ecxus.timemanager.usuario;

public class UsuarioDto {

    private String nome;

    private String login;

    private String senha;

    private Integer horasDeTrabalhoPreferidasPorDia;

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
}
