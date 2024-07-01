package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    // atributos
    private LocalDate data;

    // construtor
    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        this.data = data;
        calcularXp();
    }

    // getters (getters de título, descrição e xp já estão na classe Conteudo)
    public LocalDate getData() {
        return data;
    }

    // método sobrescrito da classe Conteudo
    @Override
    public void calcularXp() {
        this.xp = XP_PADRAO + 20d;
    }
}
