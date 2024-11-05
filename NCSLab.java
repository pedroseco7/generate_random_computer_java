import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Maria Ferraz
 * @author Pedro Seco
 */

/**
 * Classe principal para gerir a aplicação de gestão de computadores do laboratório NCS.
 * Inicializa o ambiente do laboratório, adiciona diferentes tipos de computadores
 * (Servidores, Laptops e Raspberry Pis) e executa métodos para impressão
 * de informações dos computadores e cálculo de consumo energético.
 */
 public class NCSLab {
    public static void main(String[] args) {

        // Criação da lista de computadores
        List<Computador> listaComputadores = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listaComputadores.add(new Servidor());
            listaComputadores.add(new Laptop());
            listaComputadores.add(new RaspberryPi());
        }

        // Scanners para Pausas e recolha de dados.
        Scanner pause = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int opcao;

        //region Menu

        do {
            System.out.println("\nBem-vindo ao NCSlab. Escolha uma das opções:");
            System.out.println("[1] Imprimir todos os computadores existentes");
            System.out.println("[2] Imprimir todos os computadores de arquitetura x64");
            System.out.println("[3] Calcular o consumo energético de cada computador, em Watts");
            System.out.println("[0] Sair");
            System.out.print("\nSeleciona uma opção: ");

            //Garante que a opção seja um nº do tipo inteiro
            while(!input.hasNextInt()){
                input.next();
                System.out.println("Opção inválida! Tente novamente");
                System.out.print("Seleciona uma opção: ");
            }
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Todos os Computadores ---");
                    for (Computador computador : listaComputadores) {
                        System.out.println(computador);
                    }

                    // Pausa no programa
                    System.out.print("\nPressiona enter para voltar ao menu.. ");
                    pause.nextLine();

                    break;

                case 2:
                    System.out.println("\n--- Computadores de Arquitetura x64 ---");
                    for (Computador computador : listaComputadores) {
                        if (computador.arquitetura.equals("x64")) {
                            System.out.println(computador);
                        }
                    }

                    // Pausa no programa
                    System.out.print("\nPressiona enter para voltar ao menu.. ");
                    pause.nextLine();

                    break;

                case 3:
                    System.out.println("\n--- Consumo Energético de Cada Computador ---");
                    for (Computador computador : listaComputadores) {
                        System.out.println("Computador -> ID: " + computador.id + ", consumo energético: "
                                + String.format("%.2f", computador.consumoEnergetico()).replace(",", ".") + "W");
                    }

                    // Pausa no programa
                    System.out.print("\nPressiona enter para voltar ao menu.. ");
                    pause.nextLine();

                    break;

                case 0:
                    System.out.println("A sair do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        // Fecho dos objetos Scanner
        input.close();
        pause.close();

        //endregion
    }
}
