package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.TipoServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private List<PrestadorServico> lista = new ArrayList<>();
		
	private int indice = 0;
	
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

	
	
}
