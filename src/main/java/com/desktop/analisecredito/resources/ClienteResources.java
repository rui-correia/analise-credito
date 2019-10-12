package com.desktop.analisecredito.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desktop.analisecredito.domain.Cliente;
import com.desktop.analisecredito.domain.Usuario;
import com.desktop.analisecredito.services.ClienteService;
import com.desktop.analisecredito.services.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin(origins = "*")
@Api(value = "API REST Clientes")
public class ClienteResources {

	@Autowired
	private ClienteService service;
	
	@Autowired
	private UsuarioService serviceuser;

	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 * 
	 * @ApiOperation(value = "Consulta um Cliente Pelo Id") public
	 * ResponseEntity<Cliente> find(@PathVariable Integer id) {
	 * 
	 * Cliente obj = service.find(id); return ResponseEntity.ok().body(obj); }
	 */

	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	@ApiOperation(value = "Consulta um Cliente Pelo CPF")
	public ResponseEntity<List<Cliente>> findCpf(@RequestParam(value = "cpf") String cpf) {

		List<Cliente> list = service.findAll();

		for (Cliente cliente : new ArrayList<>(list)) {
			if (!cliente.getCpf().equals(cpf)) {
				list.remove(cliente);
			}
		}
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Filtro de clientes Aprovados/Negados ou Aguardando")
	public ResponseEntity<List<Cliente>> findAll(Integer idUser) {

		Usuario user = serviceuser.find(idUser);
		
		List<Cliente> list = service.findAll();
		if (user.getIdCargo() == 2) {

			for (Cliente cliente : new ArrayList<>(list)) {
				if (cliente.getStatus() != 0) {
					list.remove(cliente);
				}
			}
			return ResponseEntity.ok().body(list);
		} else {
			for (Cliente cliente : new ArrayList<>(list)) {
				if (cliente.getStatus() == 0) {
					list.remove(cliente);
				}
			}
			return ResponseEntity.ok().body(list);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Cadastrar Cliente")
	public ResponseEntity<Void> insert(@RequestBody Cliente obj, Integer idUser) {
		Usuario user = serviceuser.find(idUser);
		
		if (user.getIdCargo() == 1) {
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
					.toUri();

			return ResponseEntity.created(uri).build();
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)

	@ApiOperation(value = "Atualiza um Cliente")
	public ResponseEntity<Void> update(@RequestBody Cliente obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "Aprova/Nega um cliente")
	public ResponseEntity<Void> update(Integer idUsuario, Integer idCli, Integer aprovanega) {

		Usuario user = serviceuser.find(idUsuario);
		
		Cliente obj = service.find(idCli);
		if (user.getIdCargo() == 2) {
			obj.setId(idCli);
			if (aprovanega == 1) {
				obj.setStatus(1);
			} else {
				obj.setStatus(2);
			}
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deleta um Cliente")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
