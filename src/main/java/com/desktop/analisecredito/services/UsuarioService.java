package com.desktop.analisecredito.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.desktop.analisecredito.domain.Usuario;
import com.desktop.analisecredito.repositories.UsuarioRepository;
import com.desktop.analisecredito.services.exception.DataIntegrityException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado", null);
		}
		return obj.orElse(null);
	}
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Usuario update(Usuario obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete (Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir");
		}
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
}