package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO{

	@Autowired // AUTOWIRED Sinaliza para o string a instancia deste objeto
	private SessionFactory sessionFactory;
	
	private List<TipoServico> lista = new ArrayList<>();
	
	private int indice = 0;
	
	//--------------------CREATE---------------------------
	@Override
	public TipoServico create(TipoServico tipoServico) {
		
		sessionFactory.getCurrentSession().save(tipoServico);
		sessionFactory.getCurrentSession().flush();
		
		return tipoServico;
	}
	
	//-------------------READ------------------------------
	@Override
	public List<TipoServico> read() {
		
		//CRITERIA é uma  interface e tem como objeto de retorno TipoServico
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);
		
		return criteria.list(); // o metodo retorna uma lista de tipo servico
	}

	//--------------------------READBYNAME-----------------
	@Override
	public List<TipoServico> readByName(String nome) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);
		
		criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE).ignoreCase()); //IGNORECASE é para não ter problemas com a leitura 
		//caso o registro estiver escrito com letra maiúscula ou minúscula.
		//RESTRICTIONS vai restringir a busca pelo nome do tipo do serviço.
		//MATCHMODE ANYWHERE faz a busca com mais precisão do like, mas pode pesar sua consulta no BD
		
		return criteria.list();
	}

	//----------------------UPDATE------------------------
	@Override
	public TipoServico update(TipoServico tipoServico) {
		
		sessionFactory.getCurrentSession().update(tipoServico);
		sessionFactory.getCurrentSession().flush();
		
		return tipoServico;
	}

	
	//---------------DELETE-------------------------------
	@Override
	public void delete(Integer id) {
		
		//É necessário instanciar o objeto e passar o seu código
		//pois como vai excluir o registro se não sabe a quem 
		//o codigo ele pertence
		TipoServico tipoServico = new TipoServico();
		tipoServico.setCodigo(id);
		
		sessionFactory.getCurrentSession().delete(tipoServico);
		sessionFactory.getCurrentSession().flush();
		
	}
}
