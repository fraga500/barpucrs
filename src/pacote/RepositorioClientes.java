package pacote;

import java.util.ArrayList;

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
            if (c.getCpf() == cpf) {
                listaClienteNoBar.remove(c);
                System.out.println("Cliente com o cpf " + cpf + "saiu do estabelecimento.");
                removido = true;
            }
        }
        if(removido = false){
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

    public Cliente pesquisaPorCpf(String cpf) {
        for (Cliente c : listaClienteNoBar) {
            if (c.getCpf() == cpf) {
                return c;
            }
        }
        return null;
    }

    public void getNumeroClientes(Cliente[] impressaoClientes) {
        System.out.println("Foram encontrados " + impressaoClientes.length + " clientes cadastrados. \n\n");
    }
    
    

}
