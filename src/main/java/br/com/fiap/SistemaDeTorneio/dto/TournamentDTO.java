package br.com.fiap.SistemaDeTorneio.dto;

import java.time.LocalDate;

public class TournamentDTO {

    private String nome;
    private String jogo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status;
    private Double premiacao;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getJogo() { return jogo; }
    public void setJogo(String jogo) { this.jogo = jogo; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getPremiacao() { return premiacao; }
    public void setPremiacao(Double premiacao) { this.premiacao = premiacao; }
}