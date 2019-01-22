package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoBusiness {
	
	/**
	 * Método responsável por garantir os parametros obrigatorios,
	 * bem como solicitar a camada de acesso a dados que persista o objeto
	 * {@link TipoServico}.
	 * 
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido.
	 * @throws BusinessException 
	 */

	TipoServico create(TipoServico tipoServico) throws BusinessException;
	
	
	/**
	 * Método resposável por recuperar a base de dados todos os objetos
	 * {@link TipoServico}
	 * 
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException 
	 */
	List<TipoServico> read() throws BusinessException;
	
	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos 
	 * {@link TipoServico}, cujo nome possua parte do parametro Nome.
	 * 
	 * @param nome Parte do nome a ser buscado
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException 
	 */
	
	List<TipoServico> readByName(String nome) throws BusinessException;
	
	
	/**
	 * Metodo responsavel por persistir (atualizar) na base de dados o objeto
	 * {@link TipoServico}
	 * 
	 * @param tipoServico Objeto a ser persistido
	 * @return Objeto persistido
	 * @throws BusinessException 
	 */
	TipoServico update(TipoServico tipoServico) throws BusinessException;
	
	
	/**
	 * Metodo responsavel por excluir da base de dados
	 * o objeto {@link TipoServico} referente ao id informado.
	 * 
	 * @param id Identificador do objeto {@link TipoServico} a ser 
	 * @throws BusinessException 
	 */
	void delete(Integer id) throws BusinessException;

}
