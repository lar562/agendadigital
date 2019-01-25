package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.iftm.entity.enus.Estado;

@Entity
@Table(name = "TB_CIDADE",schema = "ESTAGIO_EVERIS", uniqueConstraints = {
		@UniqueConstraint(name = "UN_CIDADE", columnNames = {"NOME_CIDADE", "SIG_ESTADO"})
})
@SequenceGenerator(name = "SQ_CIDADE", sequenceName = "SQ_CIDADE", initialValue = 1, allocationSize = 1, 
schema = "ESTAGIO_EVERIS")

public class Cidade {

	@Id
	//GENERETEVALUE  vai alterar o valor da sequenci
	@Column(name = "CODIGO_CIDADE")
	@GeneratedValue(generator = "SQ_CIDADE", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name = "NOME_CIDADE", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "SIG_ESTADO", nullable = false, length = 2)
	@Enumerated(EnumType.STRING) //Tipo String para pegar o valor da variável estado
	private Estado estado;
	
	
	
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
