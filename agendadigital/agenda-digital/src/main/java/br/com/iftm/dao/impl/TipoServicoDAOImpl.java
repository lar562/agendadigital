package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO{

	private List<TipoServico> lista = new ArrayList<>();
	
	private int indice = 0;
	
	//--------------------CREATE---------------------------
	@Override
	public TipoServico create(TipoServico tipoServico) {
		
		tipoServico.setCodigo(indice++);
		
		lista.add(tipoServico);
		
		return tipoServico;
	}
	
	//-------------------READ------------------------------
	@Override
	public List<TipoServico> read() {
		
		return lista;
	}

	//--------------------------READBYNAME-----------------
	@Override
	public List<TipoServico> readByName(String nome) {
		
		List<TipoServico> listaRetorno = new ArrayList<>();
		
		for(TipoServico tipoServico3 : lista) {
			if(tipoServico3.getNome().toUpperCase().contains(nome.toUpperCase())) {
				listaRetorno.add(tipoServico3);
			}
		}	
		return listaRetorno;
	}

	//----------------------UPDATE------------------------
	@Override
	public TipoServico update(TipoServico tipoServico) {
		
		for(TipoServico tipoServico2 : lista) {
			
			if(tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				tipoServico2.setNome(tipoServico.getNome());
			}
		}
		return tipoServico;
	}

	
	//---------------DELETE-------------------------------
	@Override
	public void delete(Integer id) {
		for(TipoServico tipoServico2 : lista) {
			
			if(tipoServico2.getCodigo().equals(id)) {
				lista.remove(tipoServico2);
				break;
			}
		}	
	}
}
