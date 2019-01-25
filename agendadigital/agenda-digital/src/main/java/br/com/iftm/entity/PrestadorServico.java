package br.com.iftm.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.iftm.entity.enus.TipoLogradouro;

@Entity
@Table(name = "TB_PRESTADORSERVICO", schema = "ESTAGIO_EVERIS")
@SequenceGenerator(name = "SQ_PRESTADORSERVICO", sequenceName = "SQ_PRESTADORSERVICO", initialValue = 1, allocationSize = 1,
schema = "ESTAGIO_EVERIS")
public class PrestadorServico {

	@Id
	//GENERETEVALUE  vai alterar o valor da sequenci
	@Column(name = "CODIGO_PRESTADORSERVICO")
	@GeneratedValue(generator = "SQ_PRESTADORSERVICO", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name = "NOME_PRESTADORSERVICO", nullable = false, length = 100)
	private String nome;
	
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
	@JoinColumn(name = "CODIGO_CIDADE", nullable = false ,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
			name = "FK_TB_PRESTADOR_SERV_TB_CIDADE"))
	private Cidade cidade;
	
	
	@Column(name = "BAIRRO_PRESTADORSERVICO", nullable = false, length = 50)
	private String bairro;
	
	
	@Column(name = "CEP_PRESTADORSERVICO",nullable = true, length = 10)
	private String cep;
	
	
	@Column(name = "TIPO_LOGRADOURO", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;
	
	
	@Column(name = "LOUGRADOURO", nullable = false, length = 100)
	private String logradouro;
	
	
	@Column(name = "COMPLEMENTO", nullable = true, length = 200)
	private String complemento;
	
	
	@Column(name = "NUMERO_CASA", nullable = false)
	private Integer numero;
	
	
	@Column(name = "EMAIL", nullable = true, length = 80)
	private String email;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, 
			targetEntity = Telefone.class)
	private Set<Telefone> telefone;
	

	//JOINCOLUMNS é por causa que uma das minhas tabelas pode ter chave composta
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = TipoServico.class)
	@JoinTable(name = "RL_SERVICO_CREDENCIADO", schema = "ESTAGIO_EVERIS", joinColumns = {
		@JoinColumn(name = "CODIGO_PRESTADORSERVICO")}, inverseJoinColumns = { @JoinColumn(name = "CODIGO_TIPOSERVICO")
				
	})
	private Set<TipoServico> tipoServico;
	
	
	
	
	//------------------------------MÉTODOS GET AND SET---------------------------------------
	
	public Set<TipoServico> getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(Set<TipoServico> tipoServico) {
		this.tipoServico = tipoServico;
	}
	public Set<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
