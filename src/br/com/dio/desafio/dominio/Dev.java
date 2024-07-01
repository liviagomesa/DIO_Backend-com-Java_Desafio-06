package br.com.dio.desafio.dominio;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Dev {

    // atributos
    private String nome;
    private Set<Conteudo> conteudosInscritos;
    private Set<Conteudo> conteudosConcluidos;
    private double xp;

    // construtor
    public Dev(String nome) {
        this.nome = nome;
        conteudosInscritos = new LinkedHashSet<>();
        conteudosConcluidos = new LinkedHashSet<>();
        xp = 0;
        System.out.println(this + " criado com sucesso!");
    }

    // getters
    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public double getXp() {
        return xp;
    }

    // métodos sobrescritos
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos)
                && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    @Override
    public String toString() {
        return "Dev " + nome.toUpperCase();
    }

    // métodos próprios da classe
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
        System.out.println("A inscrição de " + this + " em " + bootcamp + " foi realizada.");
    }

    public void progredir() {
        // obtemos o primeiro elemento (da classe conteudo) da stream de
        // conteudosInscritos e encapsulamos em um Optional<Conteudo>, o que significa
        // que pode ou não haver um elemento presente.
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            xp += conteudo.get().getXp();
            System.out.println("Parabéns, " + this + "! Você concluiu o conteúdo " + conteudo.get() + " e ganhou +"
                    + conteudo.get().getXp() + " XP");
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public void imprimirXp() {
        System.out.println("XP " + this + ": " + xp);
    }

    public void imprimirProgresso(Bootcamp bootcamp) {
        double avanco = xp / bootcamp.getXpTotal();
        System.out.println("Progresso de " + this + ":");
        for (Conteudo c : conteudosConcluidos) {
            System.out.println("- " + c + ": 100%");
        }
        for (Conteudo c : conteudosInscritos) {
            System.out.println("- " + c + ": 0%");
        }
        System.out.printf("Avanço geral: %.1f%%\n", avanco * 100);
    }

    public void imprimirPlanejamento(Bootcamp bootcamp) {
        long horasPendentes = 0;
        for (Conteudo c : conteudosInscritos) {
            if (c.getClass().getSimpleName().equals("Curso")) {
                Curso d = (Curso) c;
                horasPendentes += d.getCargaHoraria();
            }
        }
        long diasAteFim = ChronoUnit.DAYS.between(LocalDate.now(), bootcamp.getDataFinal());
        double horasDiariasPlanejadas = (double) horasPendentes / diasAteFim;
        System.out.println(bootcamp + " vai acabar em " + bootcamp.getDataFinal() + ". Você tem " + horasPendentes
                + " horas de cursos pendentes e " + diasAteFim + " dias restantes.");
        System.out.printf("Sugestão: estude %.2f horas por dia para terminar.\n", horasDiariasPlanejadas);
    }
}
