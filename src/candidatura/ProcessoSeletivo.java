package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Seja bem-vindo ao Processo Seletivo");

        String [] candidatos = {"Felipe", "Márcia", "Julia", "Paulo", "Augusto"};
        for(String candidato: candidatos){
            contatoSelecionado(candidato);
        }
    }

    static void contatoSelecionado(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }
            else {
                System.out.println("Contato realizado com sucesso.");
            }
        } while(continuarTentando && tentativasRealizadas < 3);
        if(atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas);
        }
        else {
            System.out.println("Não conseguimos contato com " + candidato + ", número maximo de tentativa é " + tentativasRealizadas);
        }
    }
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados (){
        String [] candidatos = {"Felipe", "Márcia", "Julia", "Paulo", "Augusto"};

        System.out.println("Lista de candidatos:");
        for(int ind = 0; ind < candidatos.length; ind++){
            System.out.println("O candidato de nº" + (ind+1) + " é o " + candidatos[ind]);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Felipe", "Márcia", "Julia", "Paulo", "Augusto", "Mônica", "Fabricio", "Mirela", "Daniela", "Jorge"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " está pedindo " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            else {
                System.out.println("O candidato " + candidato + " NÃO foi selecionado para a vaga.");
            }
            candidatoAtual++;
        }
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato.");
        }
        else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra-proposta.");
        }
        else {
            System.out.println("Aguardando o resultado dos demais candidatos.");
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
}