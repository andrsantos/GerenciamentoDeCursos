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


@Entity
@Table(name = "cursos")
public class Cursos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cdCurso;
	private String nome;
	private int valor;
	private String url;
	private Set<Pagamento> pagamentos = new HashSet<Pagamento>(0);

	public Cursos() {
	}

	public Cursos(Integer cdCurso, String nome, int valor, String url) {
		this.nome = nome;
		this.valor = valor;
		this.url = url;
	}
	
	public Cursos(String nome, int valor, String url) {
		this.nome = nome;
		this.valor = valor;
		this.url = url;
	}

	public Cursos(String nome, int valor, String url, Set<Pagamento> pagamentos) {
		this.nome = nome;
		this.valor = valor;
		this.url = url;
		this.pagamentos = pagamentos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cdCurso", unique = true, nullable = false)
	public Integer getCdCurso() {
		return this.cdCurso;
	}

	public void setCdCurso(Integer cdCurso) {
		this.cdCurso = cdCurso;
	}

	@Column(name = "nome", nullable = false, length = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "valor", nullable = false)
	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Column(name = "url", nullable = false, length = 45)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cursos")
	public Set<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(Set<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	@Override
	public String toString() {
		return "Curso => [Código: "+cdCurso+" , Nome: "+nome+" , Valor: "+valor+" , URL: "+url+" ] ";
	}

}
