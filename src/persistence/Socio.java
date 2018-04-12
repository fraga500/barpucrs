/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import persistence.Cliente;

/**
 *
 * @author PedroFranceschinideF
 */
public class Socio extends Cliente {
    
    private int numero;

    public Socio(int numero, String nome, String cpf, int idade, char genero) {
        super(nome, cpf, idade, genero);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    

    @Override
    public String toString() {
        return super.toString() + "\nNumero de socio:" + numero;
    }
    
    
}