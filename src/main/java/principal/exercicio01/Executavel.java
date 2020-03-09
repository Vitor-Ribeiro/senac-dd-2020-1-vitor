package principal.exercicio01;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.bo.ClienteBO;
import model.dao.exercicio01.ClienteDAO;
import model.dao.exercicio01.EnderecoDAO;
import model.entity.exercicio01.Cliente;
import model.entity.exercicio01.Endereco;
import model.entity.exercicio01.Telefone;

public class Executavel {

	public static void main(String[] argumentosLinhaDeComando) {

		// TODO criar e SALVAR telefones
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();

		// Exerc�cio 2
		Cliente cliente1 = obterClienteDaTela();

		// - Salvar no banco (APENAS TESTES, AINDA VIOLANDO O MVC)
		ClienteBO clienteBO = new ClienteBO();
		String mensagem = clienteBO.salvar(cliente1);

		JOptionPane.showMessageDialog(null, mensagem);

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

		return novoCliente;
	}
}