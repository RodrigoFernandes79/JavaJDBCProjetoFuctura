package dAo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import model.Cliente;
import model.Endereco;


public class EnderecoDao {
		String sql = "insert into Endereco (RUA,CEP,numero,bairro,cidade,estado, id_cliente) values (?,?,?,?,?,?,?)";

		Connection conexao;

		public void inserir(Endereco endere�o) {

			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);


				ps.setString(1, endere�o.getRua());
				ps.setString(2, endere�o.getCep());
				ps.setString(3,endere�o.getNumero());
				ps.setString(4, endere�o.getBairro());
				ps.setString(5, endere�o.getCidade());
				ps.setString(6, endere�o.getEstado());
				ps.setLong(7, endere�o.getCliente().getId_cliente());

				ps.execute();




			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	public void atualizar (Endereco endere�o) throws ClassNotFoundException {

		String sql = "UPDATE Endereco SET RUA=?, CEP=? NUMERO=?, BAIRRO=?, CIDADE=?, ESTADO=?, ID_CLIENTE=?"
				+ " WHERE ID_ENDERECO=?";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, endere�o.getRua());
			ps.setString(2, endere�o.getCep());
			ps.setString(3, endere�o.getNumero());
			ps.setString(4, endere�o.getBairro());
			ps.setString(5, endere�o.getCidade());
			ps.setString(5, endere�o.getEstado());
			ps.setLong(6, endere�o.getCliente().getId_cliente());
			ps.setLong(7, endere�o.getId());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	public void deletar(Integer id) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO=?";
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

	public List<Endereco> listarTodos() throws ClassNotFoundException {
		String sql = "SELECT * FROM ENDERECO";
		Connection conexao;

		List<Endereco> listarEndere�o = new ArrayList<Endereco>();

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();

			while(resultado.next()) {

				Endereco endere�o = new Endereco();

				endere�o.setId(resultado.getLong("ID_ENDERECO"));
				endere�o.setRua(resultado.getString("RUA"));
				endere�o.setCep(resultado.getString("CEP"));
				endere�o.setNumero(resultado.getString("NUMERO"));
				endere�o.setBairro(resultado.getString("BAIRRO"));
				endere�o.setCidade(resultado.getString("CIDADE"));
				endere�o.setEstado(resultado.getString("ESTADO"));
				



				listarEndere�o.add(endere�o);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return listarEndere�o;

	}


}
