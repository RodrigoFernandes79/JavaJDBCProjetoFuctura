package dAo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import model.Cliente;

public class ClienteDao {
public void inserir(Cliente cliente) throws ClassNotFoundException, SQLException {
	String sql = "INSERT INTO CLIENTE(nome,ano_nascim,sexo,cpf) VALUES(?,?,?,?)";
	
	Connection conexao;
	
	try {
	conexao = ConexaoJDBC.getConexao();
	PreparedStatement ps = conexao.prepareStatement(sql);
	
	ps.setString(1,cliente.getNome());
	ps.setString(2,cliente.getAnoNascim());
	ps.setString(3,cliente.getSexo());
	ps.setString(4,cliente.getCpf());
	
	
	ps.execute();
	
	
	}catch(SQLException e) {
		e.printStackTrace();
	}
			
}

public void atualizar(Cliente cliente) throws ClassNotFoundException {
	
	String sql = "UPDATE CLIENTE SET NOME=?, ANO_NASCIM=?, SEXO=?, CPF=?,WHERE ID_CLIENTE=?";
	Connection conexao;
	
	try {
		conexao = ConexaoJDBC.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		ps.setString(1,cliente.getNome());
		ps.setString(2, cliente.getAnoNascim());
		ps.setString(3, cliente.getSexo());
		ps.setString(4, cliente.getCpf());
		ps.setFloat(5, cliente.getId_cliente());
		
		
		ps.execute();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
}

public void deletar(long id_cliente) throws SQLException, ClassNotFoundException {
	
	String sql = "DELETE * FROM CLIENTE WHERE ID_CLIENTE=?";
	Connection conexao;
	
	try {
		conexao = ConexaoJDBC.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		ps.setLong(1, id_cliente);
		
		ps.execute();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public List<Cliente> listarTodos() throws ClassNotFoundException {
	String sql = "SELECT * FROM CLIENTE";
	Connection conexao;
	
	List<Cliente> listarCliente = new ArrayList<Cliente>();
	
	try {
		conexao = ConexaoJDBC.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet resultado = ps.executeQuery();
		
		while(resultado.next()) {
			
			Cliente cliente = new Cliente();
			cliente.setId_cliente(resultado.getLong("ID_ALUNO"));
			cliente.setNome(resultado.getString("NOME"));
			cliente.setAnoNascim(resultado.getString("ANO_NASCIM"));
			cliente.setSexo(resultado.getString("SEXO"));
			cliente.setCpf(resultado.getString("CPF"));
			
			
			listarCliente.add(cliente);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	return listarCliente;
	
}




}
