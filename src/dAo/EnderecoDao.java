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

		public void inserir(Endereco enderešo) {

			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);


				ps.setString(1, enderešo.getRua());
				ps.setString(2, enderešo.getCep());
				ps.setString(3,enderešo.getNumero());
				ps.setString(4, enderešo.getBairro());
				ps.setString(5, enderešo.getCidade());
				ps.setString(6, enderešo.getEstado());
				ps.setLong(7, enderešo.getCliente().getId_cliente());

				ps.execute();




			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	public void atualizar (Endereco enderešo) throws ClassNotFoundException {

		String sql = "UPDATE Endereco SET RUA=?, CEP=? NUMERO=?, BAIRRO=?, CIDADE=?, ESTADO=?, ID_CLIENTE=?"
				+ " WHERE ID_ENDERECO=?";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, enderešo.getRua());
			ps.setString(2, enderešo.getCep());
			ps.setString(3, enderešo.getNumero());
			ps.setString(4, enderešo.getBairro());
			ps.setString(5, enderešo.getCidade());
			ps.setString(5, enderešo.getEstado());
			ps.setLong(6, enderešo.getCliente().getId_cliente());
			ps.setLong(7, enderešo.getId());

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

		List<Endereco> listarEnderešo = new ArrayList<Endereco>();

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();

			while(resultado.next()) {

				Endereco enderešo = new Endereco();

				enderešo.setId(resultado.getLong("ID_ENDERECO"));
				enderešo.setRua(resultado.getString("RUA"));
				enderešo.setCep(resultado.getString("CEP"));
				enderešo.setNumero(resultado.getString("NUMERO"));
				enderešo.setBairro(resultado.getString("BAIRRO"));
				enderešo.setCidade(resultado.getString("CIDADE"));
				enderešo.setEstado(resultado.getString("ESTADO"));
				



				listarEnderešo.add(enderešo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return listarEnderešo;

	}


}
