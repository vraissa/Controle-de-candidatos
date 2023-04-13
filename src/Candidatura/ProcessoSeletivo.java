package Candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
       entrandoEmContato();
       imprimierSelecionados();
       selecaoCandidatos();
       analisarCandidato(valorPretendido());



    }
    static void entrandoEmContato() {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else System.out.println("Contato realizado com sucesso");

        } while (continuarTentando && tentativasRealizadas<3);

    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    static void imprimierSelecionados() {
        String[] candidatos = {"Felipe", "Marcia", "Maria", "Juliana", "Ana", "Carlos", "Lucio"};
        System.out.println("Imprimindo a lista de candidatos informando o indice");

        for(int indice = 0; indice < candidatos.length; indice++ ) {
            System.out.println("O candidato de n° " + (indice+1) + " é " + candidatos[indice]);

        }
    }

        static void selecaoCandidatos() {

            String[] candidatos = {"Felipe", "Marcia", "Maria", "Juliana", "Ana", "Carlos", "Lucio"};


            int candidatosSelecionados = 0;
            int candidatoAtual = 0;
            double salarioBase = 2000.0;
            while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
                String candidato = candidatos[candidatoAtual];
                double salarioPretendido = valorPretendido();

                System.out.println("O candidato " + candidato + " solicitou esse valor de salário " + salarioPretendido);
                if(salarioBase > salarioPretendido) {
                    System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;

                } candidatoAtual++;
            }

        }

        static double valorPretendido () {
            return ThreadLocalRandom.current().nextDouble(1800, 2200);
        }
        static void analisarCandidato (double salarioPretendido){
            double salarioBase = 2000.0;
            if (salarioBase > salarioPretendido) {
                System.out.println("Ligar para candidato");
            } else if (salarioBase == salarioPretendido) {
                System.out.println("Ligar para o candidato com contraproposta");
            } else {
                System.out.println("Aguardando retorno dos demais candidatos");
            }
        }
    }

