package com.netbiis;


import java.util.HashSet; 
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class Cliente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCliente;
	private String cpf;
	private String nome;
	private String email;
	private Set<Pagamento> pagamentos = new HashSet<Pagamento>(0);

	public Cliente() {
	}

	public Cliente(String cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	
	public Cliente(Integer idCliente, String cpf, String nome, String email) {
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public Cliente(String cpf, String nome, String email, Set<Pagamento> pagamentos) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.pagamentos = pagamentos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idCliente", unique = true, nullable = false)
	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "cpf", unique = true, nullable = false, length = 19)
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "nome", nullable = false, length = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Pagamento> getPagamentos() {
		return this.pagamentos;
	}
 
	public void setPagamentos(Set<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	@Override
	public String toString() {
		return "Cliente => [Identificação: "+idCliente+" , CPF: "+cpf+" , nome: " + nome + " , E-mail: "+email+" ] ";
	}

}
