package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.TipoServico;
import br.com.iftm.entity.enus.Estado;

@Repository
public class CidadeDAOImpl implements CidadeDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	private List<Cidade> lista = new ArrayList<>();
	
	private int indice = 0;
	
	
	//---------------CREATE--------------
	@Override
	public Cidade create(Cidade cidade) {
		
		sessionFactory.getCurrentSession().save(cidade);
		sessionFactory.getCurrentSession().flush();
		
		return cidade;
	}

	
	//--------------READ-------------------
	@Override
	public List<Cidade> read() {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		
		return criteria.list();
	}
	
	
	//-----------------UPDATE---------------------------
	@Override
	public Cidade update(Cidade cidade) {
		

		sessionFactory.getCurrentSession().update(cidade);
		sessionFactory.getCurrentSession().flush();
		
		return cidade;
	}

	
	//---------------------DELETE---------------------------
	@Override
	public void delete(Integer id) {
		
		Cidade cidade = new Cidade();
		
		cidade.setCodigo(id);
		
		sessionFactory.getCurrentSession().delete(cidade);
		sessionFactory.getCurrentSession().flush();
		
	}

	//------------------READBYESTADO-----------------------------
	@Override
	public List<Cidade> readByEstado(Estado estado) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);
		
		criteria.add(Restrictions.eq("estado", estado)); //Quando é objeto a ser buscado deve utilizar o Restrinction.eq
		//que é uma igualdade
		
		return criteria.list();
	}

}
