package br.com.iftm.dao.impl;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.iftm.controller.dto.FiltroPrestador;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.TipoServico;


@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	//----------------------CREATE--------------------------------
	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {
		
		sessionFactory.getCurrentSession().save(prestadorServico);
		sessionFactory.getCurrentSession().flush();
		
		return prestadorServico;
	}

	//----------------------READ---------------------------------------
	@Override
	public List<PrestadorServico> read() {
		
		//CRITERIA é uma  interface e tem como objeto de retorno TipoServico
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
				
		return criteria.list(); // o metodo retorna uma lista de tipo servico
	}


	//--------------------------UPDATE---------------------------------------
	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {


		sessionFactory.getCurrentSession().update(prestadorServico);
		sessionFactory.getCurrentSession().flush();
		
		return prestadorServico;
	}

	//-----------------------DELETE--------------------------------------------
	@Override
	public void delete(Integer id) {
		
		PrestadorServico prestadorServico = sessionFactory.getCurrentSession().get(PrestadorServico.class, id);
		
		sessionFactory.getCurrentSession().delete(prestadorServico);
	}

	@Override
	public List<PrestadorServico> readByFiltros(FiltroPrestador filtroPrestador) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		Criteria criteriaCidade = criteria.createCriteria("cidade");
		
		if(!StringUtils.isEmpty(filtroPrestador.getNome())) {
			
			criteria.add(Restrictions.like("nome", filtroPrestador.getNome(), MatchMode.ANYWHERE).ignoreCase());
		}
		
		if(filtroPrestador.getEstado() != null) {
			
			criteriaCidade.add(Restrictions.eq("estado", filtroPrestador.getEstado()));
		}
		
		if(filtroPrestador.getCidade() != null && filtroPrestador.getCidade().getCodigo() != null) {
			
			criteria.add(Restrictions.eq("cidade", filtroPrestador.getCidade()));
		}
		
//		if(filtroPrestador.getTiposServicos() != null && filtroPrestador.getTiposServicos().isEmpty()) {
//			
//			criteriaCidade.add(Restrictions.in("tiposServicos", filtroPrestador.getTiposServicos().stream().map(TipoServico::getCodigo).co));
//		}
		
		return criteria.list();
	}

	
	
}
