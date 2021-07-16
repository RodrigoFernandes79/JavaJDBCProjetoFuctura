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

		public void inserir(Endereco endereço) {

			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);


				ps.setString(1, endereço.getRua());
				ps.setString(2, endereço.getCep());
				ps.setString(3,endereço.getNumero());
				ps.setString(4, endereço.getBairro());
				ps.setString(5, endereço.getCidade());
				ps.setString(6, endereço.getEstado());
				ps.setLong(7, endereço.getCliente().getId_cliente());

				ps.execute();




			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	public void atualizar (Endereco endereço) throws ClassNotFoundException {

		String sql = "UPDATE Endereco SET RUA=?, CEP=? NUMERO=?, BAIRRO=?, CIDADE=?, ESTADO=?, ID_CLIENTE=?"
				+ " WHERE ID_ENDERECO=?";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, endereço.getRua());
			ps.setString(2, endereço.getCep());
			ps.setString(3, endereço.getNumero());
			ps.setString(4, endereço.getBairro());
			ps.setString(5, endereço.getCidade());
			ps.setString(5, endereço.getEstado());
			ps.setLong(6, endereço.getCliente().getId_cliente());
			ps.setLong(7, endereço.getId());

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

		List<Endereco> listarEndereço = new ArrayList<Endereco>();

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();

			while(resultado.next()) {

				Endereco endereço = new Endereco();

				endereço.setId(resultado.getLong("ID_ENDERECO"));
				endereço.setRua(resultado.getString("RUA"));
				endereço.setCep(resultado.getString("CEP"));
				endereço.setNumero(resultado.getString("NUMERO"));
				endereço.setBairro(resultado.getString("BAIRRO"));
				endereço.setCidade(resultado.getString("CIDADE"));
				endereço.setEstado(resultado.getString("ESTADO"));
				



				listarEndereço.add(endereço);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return listarEndereço;

	}


}
