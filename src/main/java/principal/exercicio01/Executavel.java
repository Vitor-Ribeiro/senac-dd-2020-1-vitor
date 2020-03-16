package principal.exercicio01;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.bo.ClienteBO;
import model.dao.exercicio01.ClienteDAO;
import model.dao.exercicio01.EnderecoDAO;
import model.dao.exercicio01.TelefoneDAO;
import model.entity.exercicio01.Cliente;
import model.entity.exercicio01.Endereco;
import model.entity.exercicio01.Telefone;

public class Executavel {

	public static void main(String[] args) {
		
		// TODO criar e SALVAR telefones
				ArrayList<Telefone> telefones = new ArrayList<Telefone>();
				//Telefone telefone1 = cadastrarTelefoneDaTela();
				// Exerc�cio 2
				Cliente cliente1 = obterClienteDaTela(); 
				

				// - Salvar no banco (APENAS TESTES, AINDA VIOLANDO O MVC)
				ClienteBO clienteBO = new ClienteBO();
			   String mensagem = clienteBO.salvar(cliente1);

				//JOptionPane.showMessageDialog(null, mensagem);
				
			}

			private static Cliente obterClienteDaTela() {
				String nome = JOptionPane.showInputDialog("Informe o nome");
				String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome");
				String cpf = JOptionPane.showInputDialog("Informe o CPF");

				EnderecoDAO endDAO = new EnderecoDAO();
				ArrayList<Endereco> listaEnderecos = endDAO.consultarTodos();
				
				Object[] enderecos = listaEnderecos.toArray();
				Endereco enderecoSelecionado = (Endereco) JOptionPane.showInputDialog(null, 
						"Selecione um endere�o", "Endere�o", 
						JOptionPane.QUESTION_MESSAGE, 
						null, enderecos, null);

				Cliente novoCliente = new Cliente(nome, sobrenome, cpf, 
						new ArrayList<Telefone>(), enderecoSelecionado);
				ClienteBO cliBO = new ClienteBO();
				cliBO.salvar(novoCliente);
			
				return novoCliente;
			}
			
			private static Telefone cadastrarTelefoneDaTela() {
						
				String codigoPais = JOptionPane.showInputDialog("Informe o c�digo telef�nico do Pa�s: ");
				String ddd = JOptionPane.showInputDialog("Informe o DDD do telefone: ");
				String numero = JOptionPane.showInputDialog("Informe o n�mero do telefone: ");
				
				int isMovel = JOptionPane.showConfirmDialog(null, "Este telefone � m�vel?", "Telefone", JOptionPane.YES_NO_OPTION);
		        boolean movel = false;
		        if(isMovel == 0) {
		            System.out.println("O telefone � m�vel");
		            movel = true;
		        } else if(isMovel == 1) {
		            System.out.println("O telefone � fixo");
		            movel = false;
		        } else {
		            System.out.println("Erro, processo cancelado.");
		            JOptionPane.showMessageDialog(null, "Erro, processo cancelado.");
		        }
		        
		        TelefoneDAO telDAO = new TelefoneDAO();
		        Telefone novoTelefone = new Telefone();
		        int isAtivo = JOptionPane.showConfirmDialog(null, "H� propriet�rio para esta linha?", "Telefone", JOptionPane.YES_NO_OPTION);
		        boolean ativo = false;
		        if(isAtivo == 0) {
		        	ClienteDAO clienteDAO = new ClienteDAO();
					ArrayList<Cliente> listaClientes = clienteDAO.consultarTodos();
					Object[] clientes = listaClientes.toArray();
		        	System.out.println("O telefone est� ativo. Tem propriet�rio.");
		            ativo = true;
		            Cliente clienteSelecionado = (Cliente) JOptionPane.showInputDialog(null, 
							"Selecione um cliente: ", "Cliente", 
							JOptionPane.QUESTION_MESSAGE, 
							null, clientes, null);
		           novoTelefone = new Telefone(0, clienteSelecionado, codigoPais, ddd, numero, movel, ativo);
		           telDAO.salvar(novoTelefone); 
		        } else if(isAtivo == 1) {
		            System.out.println("O telefone est� inativo. N�o tem propriet�rio.");
		            ativo = false;
		            Cliente clienteVazio = new Cliente();
		            novoTelefone = new Telefone(0, clienteVazio, codigoPais, ddd, numero, movel, ativo);
			        telDAO.salvar(novoTelefone);
		            
		        } else {
		            System.out.println("Erro, processo cancelado.");
		            JOptionPane.showMessageDialog(null, "Erro, processo cancelado.");
		        }
		        
		        
		        
			return novoTelefone;	
			}

}