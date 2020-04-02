package model.bo;

import model.dao.exercicio01.TelefoneDAO;
import model.entity.exercicio01.Telefone;

public class TelefoneBO {

	private TelefoneDAO dao = new TelefoneDAO();

	public String salvar(Telefone telefone) {
		String mensagem = "";

		telefone = dao.salvar(telefone);

		if (telefone.getId() > 0) {
			mensagem = "Telefone cadastrado com sucesso";
		} else {
			mensagem = "Erro ao cadastrar telefone";
		}
		return mensagem;
	}

	public String salvar(String dono, String codigoPais, String ddd, String numero, boolean movel, boolean ativo) {
		
		return null;
	}

}