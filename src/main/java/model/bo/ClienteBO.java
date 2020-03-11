package model.bo;

import javax.swing.JOptionPane;

import model.dao.exercicio01.ClienteDAO;
import model.entity.exercicio01.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();
	/**
	 * Tenta salvar um cliente novo, validando o CPF
	 * @param cliente o Cliente a ser salvo no banco
	 * @return
	 */
	public String salvar(Cliente cliente) {
		String mensagem = "";
		
		if(dao.cpfJaUtilizado(cliente.getCpf())) {
			mensagem = "CPF informado (" + cliente.getCpf() + ") já foi utilizado";
			JOptionPane.showMessageDialog(null, mensagem);

		}else {
			cliente = dao.salvar(cliente);
			
			if(cliente.getId() > 0) {
				mensagem = "Cliente salvo com sucesso";
				JOptionPane.showMessageDialog(null, mensagem);
			}else {
				mensagem = "Erro ao salvar cliente";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}
		
		return mensagem;
	}

}
