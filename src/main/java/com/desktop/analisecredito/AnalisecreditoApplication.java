package com.desktop.analisecredito;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desktop.analisecredito.domain.Cliente;
import com.desktop.analisecredito.domain.Usuario;
import com.desktop.analisecredito.repositories.ClienteRepository;
import com.desktop.analisecredito.repositories.UsuarioRepository;

@SpringBootApplication
public class AnalisecreditoApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cli01 = new Cliente(null, "05542245420", "Rui", "Braz", 28, 1);
		Cliente cli02 = new Cliente(null, "13206222400", "Maria", "Do Carmo", 68, 2);
		Cliente cli03 = new Cliente(null, "33698525412", "Priscilla", "Maria", 36, 1);
		Cliente cli04 = new Cliente(null, "23652145874", "Thiago", "Henrique", 48, 2);
		Cliente cli05 = new Cliente(null, "35795145632", "Rodrigo", "Leiros", 15, 1);
		Cliente cli06 = new Cliente(null, "85214796325", "Gleidson", "Santos", 25, 0);
		Cliente cli07 = new Cliente(null, "12345678910", "Geilson", "Andrade", 30, 0);
		Cliente cli08 = new Cliente(null, "11121314151", "Rafael", "Navarro", 33, 0);
		Cliente cli09 = new Cliente(null, "61718192021", "Bruno", "Costa", 35, 1);
		Cliente cli10 = new Cliente(null, "22232425262", "Roberta", "Lira", 18, 2);
		Cliente cli11 = new Cliente(null, "72829303132", "Ricardo", "Teixeira", 48, 1);
		Cliente cli12 = new Cliente(null, "33343536373", "Pedro", "Roberto", 70, 2);
		
		Usuario user1 = new Usuario(null, 1, "12345678900", "Rivaldo", "Antunes", "rantunes", "123456");
		Usuario user2 = new Usuario(null, 2, "36985214755", "Rui", "Correia", "rcorreia", "654321");

		clienteRepository.saveAll(Arrays.asList(cli01, cli02, cli02, cli03, cli04, cli05, cli06, cli07, cli08, cli09, cli10, cli11, cli12));
		usuarioRepository.saveAll(Arrays.asList(user1, user2));

	}

}
