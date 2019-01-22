package br.com.iftm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.TipoServicoBusiness;
import br.com.iftm.business.impl.TipoServicoBusinessImpl;
import br.com.iftm.entity.TipoServico;


@RestController //Habilita classe como um serviço rest, também faz a rota 
@RequestMapping(value = "/tiposervico") //Nome do serviço
public class TipoServicoRest {
	
	@Autowired
	private TipoServicoBusiness business = new TipoServicoBusinessImpl();
	
	//------------------Create----------------------
	@PostMapping()
	public ResponseEntity<?> create (@RequestBody TipoServico tipoServico){//? pq não sabe o tipo de objeto que vai ser retornado
		
		try {
			tipoServico = business.create(tipoServico);
			
			return ResponseEntity.ok(tipoServico);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	// Read
	@GetMapping
	public ResponseEntity<?> read(){
		
		try {
			
			return ResponseEntity.ok(business.read());
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	@GetMapping("/filtro/nome")
	public ResponseEntity<?> readByname(@PathParam("nome") String nome){
		
		try {
			
			List<TipoServico> readbyname = business.readByName(nome);
			if(readbyname.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(readbyname);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	//---------------Update-----------------------
	@PutMapping
	public ResponseEntity<?> update(@RequestBody TipoServico tipoServico){
		
		try {
			tipoServico = business.update(tipoServico);
			
			return ResponseEntity.ok(tipoServico);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	
	//--------Delete-------
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		
		try {
			
			business.delete(id);
			
			return ResponseEntity.ok().build();
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}
	}
}
