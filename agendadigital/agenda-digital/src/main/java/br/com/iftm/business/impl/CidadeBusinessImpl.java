package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.CidadeBusiness;
import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.dao.impl.CidadeDAOImpl;
import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enus.Estado;

@Service
public class CidadeBusinessImpl implements CidadeBusiness {

	private CidadeDAO dao = new CidadeDAOImpl();
	
	//-----------------CREATE-------------------------------
	@Override
	public Cidade create(Cidade cidade) throws BusinessException {

		if(StringUtils.isEmpty(cidade.getNome())) {
			
			throw new BusinessException("Nome Requerido!"); 
		}
		

		if(cidade.getEstado() == null) {
			
			throw new BusinessException("Estado Requerido!"); 
		}
		
		return dao.create(cidade);
	}
	
	
	//--------------------READ-------------------------------
	@Override
	public List<Cidade> read() throws BusinessException {
		
		return dao.read();
	}

	//---------------------READBYNAME-------------------------------------
	@Override
	public List<Cidade> readByName(String nome) throws BusinessException {
		
		if(StringUtils.isEmpty(nome)) {
			
			throw new BusinessException("Nome Requerido!"); 
		}
		return dao.readByName(nome);
	}

	@Override
	public List<Cidade> readByEstado(Estado estado) throws BusinessException {
		
		if(estado == null) {
			
			throw new BusinessException("Estado Requerido!"); 
		}
		return dao.readByEstado(estado);
	}

	
	//--------------------------UPDATE------------------------------------
	@Override
	public Cidade update(Cidade cidade) throws BusinessException {
		
		if(cidade.getCodigo() == null) {
			throw new BusinessException("Codigo Requerido!"); 
		}
		
		if(StringUtils.isEmpty(cidade.getNome())) {
				
			throw new BusinessException("Nome Requerido!"); 
		}
		
		if(cidade.getEstado() == null) {
			
			throw new BusinessException("Estado Requerido!"); 
		}
		
		return dao.update(cidade);
	}

	
	//--------------------DELETE--------------------------------
	@Override
	public void delete(Integer id) throws BusinessException {
	
		if(id == null) {
			throw new BusinessException("Codigo Requerido!");  //
		}
		
		dao.delete(id);
		
	}

}
