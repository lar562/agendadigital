package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//UNIQUECONSTRAINTS para não ter um registro repetido na tabela.
//ENTITY é para o hibernate saber que essa classe é persistente
@Entity
@Table(name = "TB_TIPOSERVICO", schema = "ESTAGIO_EVERIS", uniqueConstraints = {
		@UniqueConstraint(name = "UN_TIPO_SERVICO", columnNames = {"NOME_TIPOSERVICO"})
})
@SequenceGenerator(name = "SQ_TIPOSERVICO", sequenceName = "SQ_TIPOSERVICO", initialValue = 1, allocationSize = 1,
schema = "ESTAGIO_EVERIS")
public class TipoServico {
	
	@Id
	//GENERETEVALUE  vai alterar o valor da sequenci
	@Column(name = "CODIGO_TIPOSERVICO")
	@GeneratedValue(generator = "SQ_TIPOSERVICO", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	
	@Column(name = "NOME_TIPOSERVICO", nullable = false, length = 100) //existe para padronizar as coisas
	private String nome;
	
	
	
	//------------------------------MÉTODOS GET AND SET---------------------------------------------
	
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

}
