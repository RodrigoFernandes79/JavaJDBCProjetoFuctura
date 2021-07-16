package dAo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import model.Cliente;
import model.Contato;

public class ContatoDao {
	public void inserir(Contato contato) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO CONTATO(DDD,NUMERO,EMAIL,ID_CLIENTE) VALUES(?,?,?,?)";

		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1,contato.getDdd());
			ps.setString(2,contato.getNumero());
			ps.setString(3,contato.getEmail());
			ps.setLong(4, contato.getCliente().getId_cliente());



			ps.execute();


		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	public void atualizar(Contato contato) throws ClassNotFoundException {

		String sql = "UPDATE CONTATO SET DDD=?, NUMERO=?, EMAIL=?, ID_CLIENTE=? WHERE ID=?";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1,contato.getDdd());
			ps.setString(2,contato.getNumero());
			ps.setString(3,contato.getEmail());
			ps.setLong(4, contato.getCliente().getId_cliente());
			ps.setLong(5, contato.getId());


			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	public void deletar(Integer id) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM CONTATO_EX WHERE ID=?";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setLong(1, id);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Contato> listarTodos() throws ClassNotFoundException {
		String sql = "SELECT * FROM CONTATO";
		Connection conexao;

		List<Contato> listarContato = new ArrayList<Contato>();

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();

			while(resultado.next()) {

				Contato contato = new Contato();
				contato.setId(resultado.getLong("ID_CONTATO"));
				contato.setDdd(resultado.getString("DDD"));
				contato.setNumero(resultado.getString("NUMERO"));
				contato.setEmail(resultado.getString("EMAIL"));
				
				



				listarContato.add(contato);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return listarContato;
		
		
	}
	
}




