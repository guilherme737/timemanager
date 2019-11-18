package br.com.guiga.ecxus.timemanager.ponto;

import java.time.LocalDate;

public class PontoDto {

    private LocalDate data;

    private Integer horasTrabalhadas;

    private Long codigoDoUsuario;

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

    public Long getCodigoDoUsuario() {
        return codigoDoUsuario;
    }

    public void setCodigoDoUsuario(Long codigoDoUsuario) {
        this.codigoDoUsuario = codigoDoUsuario;
    }
}
