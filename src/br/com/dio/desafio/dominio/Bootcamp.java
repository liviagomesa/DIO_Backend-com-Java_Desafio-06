package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    // atributos
    private final LocalDate dataInicial = LocalDate.now().minusDays(25);
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private String nome;
    private String descricao;
    private Set<Dev> devsInscritos;
    private Set<Conteudo> conteudos;

    // construtor
    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        devsInscritos = new HashSet<>();
        conteudos = new LinkedHashSet<>();
        System.out.println(this + " criado com sucesso!");
    }

    // getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public double getXpTotal() {
        double xpTotal = 0d;
        for (Conteudo c : conteudos) {
            xpTotal += c.getXp();
        }
        return xpTotal;
    }

    // métodos sobrescritos
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao)
                && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal)
                && Objects.equals(devsInscritos, bootcamp.devsInscritos)
                && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }

    @Override
    public String toString() {
        return "Bootcamp " + nome.toUpperCase();
    }

    // métodos próprios da classe
    public void adicionarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
        System.out
                .println(conteudo + " adicionado a " + this + " com sucesso!");
    }

    public void imprimirConteudo() {
        System.out.println("Conteúdo de " + this + ":");
        for (Conteudo c : conteudos) {
            System.out.println("- " + c);
        }
    }

}
