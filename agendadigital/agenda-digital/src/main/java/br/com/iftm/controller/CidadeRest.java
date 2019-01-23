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
import br.com.iftm.business.CidadeBusiness;
import br.com.iftm.business.TipoServicoBusiness;
import br.com.iftm.business.impl.CidadeBusinessImpl;
import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.TipoServico;
import br.com.iftm.entity.enus.Estado;


@RestController 
@RequestMapping(value = "/cidade") 
public class CidadeRest {
	
	@Autowired
	private CidadeBusiness business = new CidadeBusinessImpl();
	
	
	
	@PostMapping()
	public ResponseEntity<?> create (@RequestBody Cidade cidade){


		try {
			cidade = business.create(cidade);
			
			return ResponseEntity.ok(cidade);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	
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
			
			List<Cidade> readbyname = business.readByName(nome);
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
	
	@GetMapping("/filtro/estado")
	public ResponseEntity<?> readByEstado(@PathParam("estado") Estado estado){
		
		try {
			
			List<Cidade> readbyestado = business.readByEstado(estado);
			if(readbyestado == null || readbyestado.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(readbyestado);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}	
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Cidade cidade){
		
		try {
			cidade = business.update(cidade);
			
			return ResponseEntity.ok(cidade);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(e);
		}
	}
	

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
