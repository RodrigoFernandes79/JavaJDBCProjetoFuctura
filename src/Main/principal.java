package Main;

import java.sql.SQLException;
import java.util.List;

import dAo.ClienteDao;
import dAo.ContatoDao;
import dAo.EnderecoDao;
import model.Cliente;
import model.Contato;
import model.Endereco;

public class principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Cliente cliente =new Cliente();
		
		
		cliente.setNome("Paula Tejano");
		cliente.setCpf("425778");
		cliente.setSexo("F");
		cliente.setAnoNascim("1979");
		
		ClienteDao clienteDao =new ClienteDao();
		//clienteDao.inserir(cliente);
		
		//clienteDao.deletar(3l);
		
		Endereco endereco=new Endereco();
		cliente.setId_cliente(4l);
		
		endereco.setCep("5553-110");
		endereco.setBairro("Roda de Fogo");
		endereco.setRua("Rua Esquisita");
		endereco.setNumero("666");
		endereco.setCidade("Recife");
		endereco.setEstado("PE");
		endereco.setCliente(cliente);
		
		EnderecoDao enderecoDao = new EnderecoDao();
		//enderecoDao.inserir(endereco);
		
		//enderecoDao.deletar(5);

		Contato contato = new Contato();
		cliente.setId_cliente(5l);
		
		contato.setDdd("81");
		contato.setNumero("99884110");
		contato.setEmail("sivirino_s@gmail.com");
		contato.setCliente(cliente);
		
		ContatoDao contatoDao = new ContatoDao();
		//contatoDao.inserir(contato);
		
		
		List<Contato> listaContato = contatoDao.listarTodos();
		System.out.println(listaContato);
	}

}
