package controller.exercicio1;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.bo.EnderecoBO;
import model.dao.exercicio01.ClienteDAO;
import model.entity.exercicio01.Cliente;
import model.entity.exercicio01.Endereco;
import model.entity.exercicio01.Telefone;

public class ClienteController {
	private static final int TAMANHO_MINIMO_CAMPO_CPF = 1;
	private static final int TAMANHO_MAXIMO_CAMPO_CPF = 11;

	private ClienteBO bo = new ClienteBO();
	
	private ClienteDAO dao = new ClienteDAO();

	public ArrayList<Cliente> listarTodosOsClientes() {
		return dao.consultarTodos();
	}
	
	public String excluir(Cliente cliente) {
		String mensagem = "";
		try {
			mensagem = bo.excluir(cliente);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um número inteiro";
		}
		return mensagem;
	}
	
	public String salvar(String nome, String sobrenome, String cpf, ArrayList<Telefone> telefones, Endereco endereco) {
		String mensagem = "";

		// Validações dos campos
		mensagem += validarCampoDeTexto("Cpf", cpf, TAMANHO_MINIMO_CAMPO_CPF, TAMANHO_MAXIMO_CAMPO_CPF,
				true);
		

		if (mensagem.isEmpty()) {
			Cliente cliente = new Cliente(nome, sobrenome, cpf, telefones, endereco);
			mensagem = bo.salvar(cliente);
		}

		return mensagem;
	}

	private String validarCampoDeTexto(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo,
			boolean obrigatorio) {
		String mensagemValidacao = "";

		if (obrigatorio && valor != null 
					&& !valor.isEmpty() 
					|| valor.length() < tamanhoMinimo 
					|| valor.length() > tamanhoMaximo) {
				mensagemValidacao = nomeDoCampo + " deve possuir pelo menos " + tamanhoMinimo + " e no máximo "
						+ tamanhoMaximo + " caracteres \n";
			}

		return mensagemValidacao;
	}

	
}
