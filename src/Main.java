import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // visão do criador de conteúdo para a plataforma
        // criar bootcamp
        Bootcamp bootcamp = new Bootcamp("Santander 2024 - Backend com Java",
                "Aprenda desde os primeiros passos com Java partindo da sintaxe básica até a implementação de uma API utilizando Spring para se tornar um profissional atrativo no mercado.");
        // criar e adicionar conteúdos ao bootcamp
        Curso introducao = new Curso("Introdução à Plataforma Java", "Introdução à Plataforma Java", 8);
        Mentoria aulaInaugural = new Mentoria("Aula Inaugural do Bootcamp",
                "Uma aula inaugural para todos se conhecerem!", LocalDate.now());
        Curso git = new Curso("Versionamento de Código com Git e GitHub",
                "O Git é um conceito essencial no mercado de trabalho atualmente, por isso sempre reforçamos sua importância em nossa metodologia educacional.",
                20);
        Mentoria importanciaLogica = new Mentoria("A importância da lógica",
                "Entenda por que você deve se preocupar com a lógica de programação.", LocalDate.of(2023, 12, 5));
        Mentoria tempo = new Mentoria("Gerenciamento de tempo", "Uma dica muito importante para ter sucesso na área",
                LocalDate.of(2024, 06, 01));
        Curso poo = new Curso("Programação Orientada a Objetos com Java",
                "Entenda os princípios da POO aplicados ao contexto do Java", 30);
        Curso dependencias = new Curso("Testes e Gerenciamento de Dependências em Projetos Java",
                "Aprenda tudo sobre testes e gerenciamento de dependências", 50);
        bootcamp.adicionarConteudo(introducao);
        bootcamp.adicionarConteudo(git);
        bootcamp.adicionarConteudo(aulaInaugural);
        bootcamp.adicionarConteudo(importanciaLogica);
        bootcamp.adicionarConteudo(tempo);
        bootcamp.adicionarConteudo(poo);
        bootcamp.adicionarConteudo(dependencias);

        // visão do aluno
        // criar e inscrever aluno no bootcamp
        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        // visualizar ementa do bootcamp
        bootcamp.imprimirConteudo();
        // progredir (imprimir mensagem de parabéns, informando o conteúdo finalizado e
        // a quantidade de xp obtida)
        devCamila.progredir();
        devCamila.progredir();
        // visualizar progresso (avanço de cada conteúdo e avanço geral)
        devCamila.imprimirProgresso(bootcamp);
        // visualizar prazo para finalizar e quantas horas por dia preciso estudar
        devCamila.imprimirPlanejamento(bootcamp);
        // visualizar xp
        devCamila.imprimirXp();

        Dev devJoao = new Dev("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

    }

}
