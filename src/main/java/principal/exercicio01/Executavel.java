package principal.exercicio01;

import java.util.ArrayList;
import java.util.List;

import model.entity.exercicio01.Cliente;

public class Executavel {

	public static void main(String[] args) {
		
		//cadastre 5 clientes na empresa em uma lista de clientes. 
		List <Cliente> clientes = new ArrayList<Cliente>();
		
		Cliente cliente1 = new Cliente(1, "João", "00011122255", criarEndereco(), criarTelefones());
		clientes.add(cliente1);
		
		
		//Cada cliente deve possuir todos os dados preenchidos.

	}

}