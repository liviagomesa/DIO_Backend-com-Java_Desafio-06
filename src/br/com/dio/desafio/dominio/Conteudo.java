package br.com.dio.desafio.dominio;

public abstract class Conteudo {

    // atributos
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;
    protected double xp; // usado o modificador protected para que as classes derivadas possam usar

    // construtor
    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        System.out.println(this + " criado com sucesso!");
    }

    // getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getXp() {
        return xp;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + titulo.toUpperCase();
    }

    // método próprio da classe (abstrato a implementar nas classes filhas)
    public abstract void calcularXp();
}
