package controller.exercicio1;

import javax.swing.JOptionPane;

import model.bo.TelefoneBO;
import model.entity.exercicio01.Cliente;
import model.entity.exercicio01.Telefone;

public class TelefoneController {
	

	private TelefoneBO bo = new TelefoneBO();

	/**
	 * Salva um novo telefone, validando os valores informados
	 * 
	 * @param novoTelefone o telefone a ser salvo;
	 * @return uma mensagem informando uma das opções a seguir:
	 * 
	 *         (1) há campos para ajustar
	 * 
	 *         (2) salvo com sucesso
	 * 
	 *         (3) erro ao salvar
	 */


	
	public String validarCodigoPais(String codigoPais) {
		String mensagem = "";
		
		if(codigoPais.isEmpty()) {
			mensagem = "O campo de Código do País deve ser preenchido.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		return mensagem;
	}
	
	public String validarDdd(String ddd) {
		String mensagem = "";
		
		if(ddd.isEmpty()) {
			mensagem = "O campo de DDD deve ser preenchido.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		return mensagem;
	}
	
	public String validarNumero(String numero) {
		String mensagem = "";
		
		if(numero.length() != 9) {
			mensagem = "O campo de NUMERO deve possuir até 9 dígitos.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		return mensagem;
	}
	
	public String validarNumeroObrigatorio(String numero) {
		String mensagem = "";
		
		if(numero.isEmpty()) {
			mensagem = "O campo de NUMERO deve ser preenchido.\n";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		return mensagem;
	}

	public String salvarTelefone(Object cbDono, String txtCodigoPais, String txtDdd, String txtNumero, boolean cbMovel, boolean cbAtivo) {
        String mensagem = "";
        
        System.out.println(txtNumero);
        TelefoneBO bo = new TelefoneBO();
        Telefone telefone = criarTelefone(cbDono, txtCodigoPais, txtDdd, txtNumero, cbMovel, cbAtivo);
        bo.salvar(telefone);
        return mensagem;
    }
    public Telefone criarTelefone(Object cbDono, String txtCodigoPais, String txtDdd, String txtNumero, boolean cbMovel, boolean cbAtivo) {
    	Telefone telefone = new Telefone ();
        telefone.setCodigoPais(txtCodigoPais);
        telefone.setDdd(txtDdd);
        telefone.setNumero(txtNumero);
        telefone.setMovel(cbMovel);
        telefone.setAtivo(cbAtivo);

        Cliente cliente = (Cliente)cbDono;
        telefone.setDono(cliente);

        return telefone;
    }

}
