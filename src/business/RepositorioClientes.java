package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.Instant.now;
import java.util.ArrayList;
import persistence.Cliente;
import persistence.Socio;

public class RepositorioClientes {

    private ArrayList<Cliente> listaClienteNoBar;
    private ArrayList<Cliente> listaClienteDoDia;

    public RepositorioClientes() {
        listaClienteNoBar = new ArrayList<>();
        listaClienteDoDia = new ArrayList<>();
    }

    public void addCliente(Cliente c) {
        listaClienteNoBar.add(c);
        listaClienteDoDia.add(c);
    }

    public void removeCliente(String cpf) {
        boolean removido = false;
        for (Cliente c : listaClienteNoBar) {
            if (c.getCpf().equals(cpf)) {
                listaClienteNoBar.remove(c);
                System.out.println("Cliente com o cpf " + cpf + " saiu do estabelecimento.");
                removido = true;
                break;
            }
        }
        if (removido = false) {
            System.out.println("CPF nao encontrado na lista de clientes que estao no bar.");
        }
    }

    public void imprimeTodosNoBar() {
        for (Cliente c : listaClienteNoBar) {
            System.out.println(c.toString() + "\n");
            System.out.println("----------------------------------\n");
        }
    }

    public Cliente pesquisaPorNome(String nome) {
        for (Cliente c : listaClienteNoBar) {
            if (c.getNome() == nome) {
                return c;
            }
        }
        return null;
    }

    public void pesquisaPorCpf(String cpf) {
        for (Cliente c : listaClienteNoBar) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado: \n" + c.toString());
            } else {
                System.out.println("Cliente nao encontrado.");
            }
        }
    }

    public void NumeroClientes() {
        System.out.println("Numero de clientes que estao no bar no momento: " + listaClienteNoBar.size());
    }

    public void PorcentagemClientes() {
        double contHomem = 0;
        double percentHomem = 0;
        for (Cliente c : listaClienteNoBar) {
            if (c.getGenero() == 'M') {
                contHomem = contHomem + 1;
            }
        }
        if (listaClienteNoBar.size() == 0) {
//             System.out.println("Nao ha clientes no bar.");
        } else {
            percentHomem = contHomem * (100 / listaClienteNoBar.size());
            System.out.println("Percentual de homens no bar:" + percentHomem + "\n"
                    + "Percentual de mulheres no bar:" + (100 - percentHomem));
        }
    }

    public void QuantidadeSociosClientes() {
        int contSocio = 0;
        int contCliente = 0;
        for (Cliente c : listaClienteNoBar) {
            if (c instanceof Socio) {
                contSocio++;
            } else {
                contCliente++;
            }
        }
        System.out.println("Socios no bar: " + contSocio + "\nClientes nao-socios no bar: " + contCliente);
    }

    public void arquivoTxt() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("teste.txt"));
            out.write("Data: " + now());
            out.newLine();
            for (Cliente c : listaClienteDoDia) {
                out.write(c.toString());
                out.newLine();
                out.write("---------------------------------------------");
                out.newLine();
            }
            out.close();
            System.out.println("Os dados dos clientes foram salvos.");
        } catch (IOException ex) {

        }
    }
}
