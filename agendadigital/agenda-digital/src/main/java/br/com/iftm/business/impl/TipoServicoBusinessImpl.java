package br.com.iftm.business.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.TipoServicoBusiness;
import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Service
@Transactional
public class TipoServicoBusinessImpl implements TipoServicoBusiness{

	@Autowired // Vai fazer um mapa do objeto tbm
	private TipoServicoDAO dao;
	
	//--------------------CREATE-----------------------------------------------
	@Override
	@Transactional(propagation = Propagation.REQUIRED) //Required verifica se tem transação ou abre uma nova
	public TipoServico create(TipoServico tipoServico) throws BusinessException {
		
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			
			throw new BusinessException("Nome Requerido!"); 
		}
		return dao.create(tipoServico);
	}

	
	//------------------------READ---------------------------------
	@Override
	@Transactional(readOnly = true) //READONLY a transação vai realizar somente leitura
	public List<TipoServico> read() throws BusinessException {
		
		return dao.read();
	}

	//-----------------------READBYNAME-------------------------------
	@Override
	@Transactional(readOnly = true)
	public List<TipoServico> readByName(String nome) throws BusinessException {
		
		if(StringUtils.isEmpty(nome)) {
			
			throw new BusinessException("Nome Requerido!"); 
		}
		return dao.readByName(nome);
	}

	//---------------------------UPDATE-------------------------------------
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoServico update(TipoServico tipoServico) throws BusinessException{
		
		if(tipoServico.getCodigo() == null) {
			throw new BusinessException("Codigo Requerido!"); 
		}
		
		if(StringUtils.isEmpty(tipoServico.getNome())) {
				
			throw new BusinessException("Nome Requerido!"); //
		}
		return dao.update(tipoServico); // dao é responsavel por tratar da camada de persistencia, 
		//para facilitar a implementação
	}

	//-------------------------DELETE----------------------------------
	@Override
	public void delete(Integer id) throws BusinessException{
		
		if(id == null) {
			throw new BusinessException("Codigo Requerido!");  //
		}
		
		dao.delete(id);
	}
}
