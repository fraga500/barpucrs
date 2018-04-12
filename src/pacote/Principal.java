package pacote;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RepositorioClientes cad = new RepositorioClientes();
        int opcao = 0;
        System.out.println("\f");
        do {
            System.out.println("Informe: ");
            System.out.println("1 - Para cadastrar");
            System.out.println("2 - Para imprimir todos");
            System.out.println("3 - Para pesquisar por nome");
            System.out.println("4 - Para remover baseado no cpf");
            System.out.println("5 - Para imprimir quantidade de clientes");
            System.out.println("0 - SAIR");
            opcao = in.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cad.addCliente(formulario());
                    break;
                case 2:
                    cad.imprimeTodosNoBar();
                case 3:
                    System.out.print("Nome: ");
                    String cpfPesquisa = in.next();
                    Cliente clientePesquisa = cad.pesquisaPorNome(cpfPesquisa);
                    if (clientePesquisa != null) {
                        System.out.println("\n\nCliente encontrado: ");
                        System.out.println(clientePesquisa.toString());
                    } else {
                        System.out.println("\n\nCliente não encontrado no cadastro. ");
                    }
                    break;
                case 4:
                    System.out.print("CPF: ");
                    String cpf = in.next();
                    cad.removeCliente(cpf);
                    break;
//                case 5:
//                    Cliente getAllClientes = cad.getNumeroClientes(impressaoClientes)
//                    cad.getNumeroClientes(getAllClientes);
//                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

    }

    public static Cliente formulario() {
        Scanner in = new Scanner(System.in);
        String nome, cpf;
        int idade, numeroSocio;
        char genero, confirmaSocio;

        System.out.println("Formulario:");
        System.out.print("Nome: ");
        nome = in.next();
        System.out.print("CPF: ");
        cpf = in.next();
        System.out.print("Idade: ");
        idade = in.nextInt();
        System.out.print("Genero: ");
        genero = in.next().charAt(0);
        System.out.println("O cliente e socio do estabelecimento?(S/N)");
        confirmaSocio = in.next().charAt(0);//(tratar)
        if (confirmaSocio == 'S') {
            System.out.print("Digite o numero de socio:");
            numeroSocio = in.nextInt();
            Socio s = new Socio(numeroSocio, nome, cpf, idade, genero);
            return s;
        } else {
            Cliente c = new Cliente(nome, cpf, idade, genero);
            return c;
        }
    }
}
