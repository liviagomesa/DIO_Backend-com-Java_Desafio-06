package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    // atributos
    private int cargaHoraria;

    // construtor
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
        calcularXp();
    }

    // getters (getters de título, descrição e xp já estão na classe Conteudo)
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // método sobrescrito da classe Conteudo
    @Override
    public void calcularXp() {
        this.xp = XP_PADRAO * cargaHoraria;
    }
}
