package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enus.Estado;

public interface CidadeBusiness {
	
	Cidade create(Cidade cidade) throws BusinessException;
	
	List<Cidade> read() throws BusinessException;
	
	Cidade update(Cidade cidade) throws BusinessException;
	
	void delete(Integer id) throws BusinessException;

	List<Cidade> readByEstado(Estado estado) throws BusinessException;

}
