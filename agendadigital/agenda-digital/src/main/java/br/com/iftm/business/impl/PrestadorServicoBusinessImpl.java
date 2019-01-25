package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.controller.dto.FiltroPrestador;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.dao.impl.PrestadorServicoDAOImpl;
import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.Telefone;
import br.com.iftm.entity.TipoServico;

@Service
@Transactional
public class PrestadorServicoBusinessImpl  implements PrestadorServicoBusiness{
	
	@Autowired
	private PrestadorServicoDAO dao;

	//--------------------------------------CREATE--------------------------------------------
	@Override
	@Transactional(propagation = Propagation.REQUIRED) 
	public PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException {
		
		if(StringUtils.isEmpty(prestadorServico.getNome())) {
			
			throw new BusinessException("Nome Requerido!"); 
		}
		
		if(prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {
			
			throw new BusinessException("Cidade Requerido!"); 
		}
		
		if(prestadorServico.getTipoLogradouro() == null) {
			
			throw new BusinessException("Tipo Logradouro Requerido!");
		}
		

		if(prestadorServico.getLogradouro().isEmpty()) {
			
			throw new BusinessException("Logradouro Requerido!"); 
		}
		
		if(StringUtils.isEmpty(prestadorServico.getNumero())) {
			
			throw new BusinessException("Número  Requerido!"); 
		}
		
		if(StringUtils.isEmpty(prestadorServico.getBairro())) {
			
			throw new BusinessException("Bairro Requerido!");
		}
		
		if(prestadorServico.getTelefone() == null || prestadorServico.getTelefone().isEmpty()) {
			
			throw new BusinessException("Pelo menos um Telefone é Requerido!"); 
		}
		
		
		for (Telefone telefone : prestadorServico.getTelefone()) {
			
			if(telefone.getDdd() == null) {
				throw new BusinessException("DDD requerido"); 
			}
			
			if(telefone.getNumero() == null) {
				throw new BusinessException("Número do telefone Requerido"); 
			}
			
			telefone.setPrestadorServico(prestadorServico);
		}
		
		if(prestadorServico.getTipoServico() == null || prestadorServico.getTipoServico().isEmpty()) {
			
			throw new BusinessException("Pelo menos um Tipo de Servico é Requerido!"); 
		}
		
		for (TipoServico tipoServico : prestadorServico.getTipoServico()) {
			
			if(tipoServico.getCodigo() == null) {
				throw new BusinessException("Codigo Tipo de Servico Requerido"); 
			}
		}
		
		return dao.create(prestadorServico);
	}
	
	
	//----------------------------------READ--------------------------------------
	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> read() throws BusinessException {
		return dao.read();
	}

	
	//--------------------------------UPDATE-------------------------------------------------------
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico update(PrestadorServico prestadorServico) throws BusinessException {
		
		if(prestadorServico.getCodigo() == null) {
			throw new BusinessException("Codigo Requerido!"); 
		}
		
		if(StringUtils.isEmpty(prestadorServico.getNome())) {
			
			throw new BusinessException("Nome Requerido!"); 
		}
		
		if(prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {
			
			throw new BusinessException("Cidade Requerido!"); 
		}
		
		if(prestadorServico.getTipoLogradouro() == null) {
			
			throw new BusinessException("Tipo Logradouro Requerido!");
		}
		

		if(prestadorServico.getLogradouro().isEmpty()) {
			
			throw new BusinessException("Logradouro Requerido!"); 
		}
		
		if(StringUtils.isEmpty(prestadorServico.getNumero())) {
			
			throw new BusinessException("Número  Requerido!"); 
		}
		
		if(StringUtils.isEmpty(prestadorServico.getBairro())) {
			
			throw new BusinessException("Bairro Requerido!");
		}
		
		if(prestadorServico.getTelefone() == null || prestadorServico.getTelefone().isEmpty()) {
			
			throw new BusinessException("Pelo menos um Telefone é Requerido!"); 
		}
		
		
		for (Telefone telefone : prestadorServico.getTelefone()) {
			
			if(telefone.getDdd() == null) {
				throw new BusinessException("DDD requerido"); 
			}
			
			if(telefone.getNumero() == null) {
				throw new BusinessException("Número do telefone Requerido"); 
			}
			
			telefone.setPrestadorServico(prestadorServico);
		}
		
		if(prestadorServico.getTipoServico() == null || prestadorServico.getTipoServico().isEmpty()) {
			
			throw new BusinessException("Pelo menos um Tipo de Servico é Requerido!"); 
		}
		
		for (TipoServico tipoServico : prestadorServico.getTipoServico()) {
			
			if(tipoServico.getCodigo() == null) {
				throw new BusinessException("Codigo Tipo de Servico Requerido"); 
			}
		}
		
		return dao.update(prestadorServico);
	}

	//--------------------------DELETE----------------------------------
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {
		
		if(id == null) {
			throw new BusinessException("Codigo Requerido!"); 
		}
		
		dao.delete(id);
	}


	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> readByFiltros(FiltroPrestador filtroPrestador) throws BusinessException {
		
		return dao.readByFiltros(filtroPrestador);
	}
	
	

}
