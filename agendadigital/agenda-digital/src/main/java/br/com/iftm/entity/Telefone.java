package br.com.iftm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_TELEFONE", schema = "ESTAGIO_EVERIS", uniqueConstraints = {
		@UniqueConstraint(name = "UNIQ_TELEFONE", columnNames = {"CODIGO_PRESTADORSERVICO", "DDD_TELEFONE", "NUMERO_TELEFONE"})
})
@SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", initialValue = 1, allocationSize = 1,
schema = "ESTAGIO_EVERIS")
@JsonIgnoreProperties(value = {"prestadorServico"})
public class Telefone {

	//------------------------CÓDIGO TELEFONE--------------------------------
	
	@Id
	//GENERETEVALUE  vai alterar o valor da sequenci
	@Column(name = "CODIGO_TELEFONE")
	@GeneratedValue(generator = "SQ_TELEFONE", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	//---------------------------DDD TELEFONE-----------------------------------------
	
	@Column(name = "DDD_TELEFONE", nullable = false) //existe para padronizar as coisas
	private Integer ddd;
	
	//-----------------------NÚMERO DO TELEFONE--------------------------
	
	@Column(name = "NUMERO_TELEFONE", nullable = false)
	private Integer numero;
	
	//--------------------PRESTADOR SERVICO (OBJETO)-----------------------------
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PrestadorServico.class)
	@JoinColumn(name = "CODIGO_PRESTADORSERVICO", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
	name = "FK_TB_TELEF_TB_PRESTADOR_SERV"))
	private PrestadorServico prestadorServico;
	
	
	//-----------------------------METODOS GET AND SET--------------------------------------------
	
	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}
	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
}
