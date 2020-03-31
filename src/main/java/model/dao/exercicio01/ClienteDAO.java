package model.dao.exercicio01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;
import model.entity.exercicio01.Cliente;
import model.entity.exercicio01.Endereco;
import model.entity.exercicio01.Telefone;

public class ClienteDAO {
	
	public Cliente salvar(Cliente novoCliente) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO CLIENTE(NOME, SOBRENOME, CPF, IDENDERECO) "
				+ " VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoCliente.getNome());
			stmt.setString(2, novoCliente.getSobrenome());
			stmt.setString(3, novoCliente.getCpf());
			stmt.setInt(4, novoCliente.getEndereco().getId());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novoCliente.setId(idGerado);
			}
			System.out.println("Cliente cadastrado com sucesso!");
			// TODO ao salvar um cliente temos que marcar os telefones que ele possui!
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoCliente;
	}



	public boolean alterar(Cliente cliente) {
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE CLIENTE"
				+ "SET NOME=?, SOBRENOME=?, CPF=?, IDENDERECO=? "
				+ " WHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		int registrosAlterados = 0;
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getCpf());
			stmt.setInt(4, cliente.getEndereco().getId());
			stmt.setInt(5, cliente.getId());
			registrosAlterados = stmt.executeUpdate();
			 
			// TODO atualizar a rela��o de telefones que o cliente possui

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return registrosAlterados > 0;
	}

	public Cliente consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Cliente> consultarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente c = construirClienteDoResultSet(rs);
				clientes.add(c);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return clientes;
	}

	/**
	 * 
	 * Constr�i um objeto do tipo Cliente a partir de um registro do resultSet
	 * 
	 * @param resultadoDaConsulta o item do resultSet (isto �, um registro da tabela
	 *                            Cliente)
	 * @return um objeto do tipo Cliente
	 * 
	 */
	private Cliente construirClienteDoResultSet(ResultSet rs) {
		Cliente c = new Cliente();
		try {
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setSobrenome(rs.getString("sobrenome"));
			c.setCpf(rs.getString("cpf"));

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco end = enderecoDAO.consultarPorId(rs.getInt("idendereco"));
			c.setEndereco(end);
			
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			ArrayList<Telefone> telefones = telefoneDAO.consultarTodosPorIdCliente(rs.getInt("id"));
			c.setTelefones(telefones);
		} catch (SQLException e) {
			System.out.println("Erro ao construir cliente a partir do ResultSet. Causa: " + e.getMessage());
		}
		
		return c;
	}

	public boolean cpfJaUtilizado(String cpf) {
		
		Connection conexao = Banco.getConnection();
		String sql = " select id from cliente c " + 
				"where c.cpf = '" + cpf + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		boolean cpfUsado = false;
		
		try {
			ResultSet rs = stmt.executeQuery();
			cpfUsado = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se CPF j� foi usado. Causa: " + e.getMessage());
		}
		
		return cpfUsado;
	}

	
	public boolean excluir(Cliente cliente ) {
		String sql = " DELETE FROM cliente WHERE id = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		try {
			preparedStatement.setInt(1, cliente.getId());
			int codigoRetornoUpdate = preparedStatement.executeUpdate();

			excluiu = (codigoRetornoUpdate == Banco.CODIGO_RETORNO_SUCESSO_EXCLUSAO);
		} catch (SQLException ex) {
			System.out.println(" Erro ao excluir cliente. Id: " + cliente + " .Causa: " + ex.getMessage());
		}
		return excluiu;
	}

	public boolean temClienteCadastradoComCpfUsado(String cpf) {
		String sql = " SELECT cpf FROM cliente WHERE cpf = " + cpf;

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);

		boolean clienteJaCadastrado = false;
		try {
			ResultSet conjuntoResultante = preparedStatement.executeQuery();
			clienteJaCadastrado = conjuntoResultante.next();
		} catch (SQLException ex) {
			System.out.println(" Erro ao verificar se cliente consta no banco. Causa: " + ex.getMessage());
		}

		return clienteJaCadastrado;
	}



	

	




	



}