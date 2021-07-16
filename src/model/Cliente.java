package model;

public class Cliente {
	
	private Long id_cliente;
	private String nome;
	private String cpf;
	private String sexo;
	private String anoNascim;
	
	
	
	
	
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getAnoNascim() {
		return anoNascim;
	}
	public void setAnoNascim(String anoNascim) {
		this.anoNascim = anoNascim;
	}
	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo
				+ ", anoNascim=" + anoNascim + "]";
	}
	
	
	

}
