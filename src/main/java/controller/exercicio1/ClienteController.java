package controller.exercicio1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.bo.ClienteBO;

import model.dao.exercicio01.ClienteDAO;
import model.entity.exercicio01.Cliente;
import model.entity.exercicio01.Endereco;


public class ClienteController {

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
	
	public String validarSobrenome(String sobrenome) {
		String mensagem = "";
		
		if(sobrenome.isEmpty()) {
			mensagem = "O campo SOBRENOME não pode ficar vazio.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		
		return mensagem;
	}
	
	public String validarCpf(String cpf) {
		String mensagem = "";
		
		if(cpf.length() != 11) {
			mensagem = "O campo CPF não pode ter mais de 11 dígitos.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		return mensagem;
	}
	
	public String validarNome(String nome) {
		String mensagem = "";
		
		if(nome.isEmpty()) {
			mensagem = "O campo NOME não pode ficar vazio.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		return mensagem; 
	}
	
	public String validarCpfObrigatorio(String cpf) {
		String mensagem = "";
		
		if(cpf.isEmpty()) {
			mensagem = "O campo CPF não pode ficar vazio.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		return mensagem; 
	}
	
	public String salvarCliente(String txtNome, String txtSobrenome, String txtCpf, Object txtEndereco) {
        String mensagem = "";
        
        

        ClienteBO bo = new ClienteBO();
        Cliente cliente = criarCliente(txtNome, txtSobrenome, txtCpf, txtEndereco);
        bo.salvar(cliente);
        return mensagem;
    }
	
    public Cliente criarCliente(String txtNome, String txtSobrenome, String txtCpf, Object txtEndereco) {
        Cliente cliente = new Cliente ();
        cliente.setNome(txtNome);
        cliente.setSobrenome(txtSobrenome);
        cliente.setCpf(txtCpf);

        Endereco endereco = (Endereco)txtEndereco;
        cliente.setEndereco(endereco);

        return cliente;
    }
}
