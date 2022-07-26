package com.lgcsantos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lgcsantos.workshopmongo.domain.Post;
import com.lgcsantos.workshopmongo.domain.User;
import com.lgcsantos.workshopmongo.dto.AuthorDTO;
import com.lgcsantos.workshopmongo.repository.PostRepositoy;
import com.lgcsantos.workshopmongo.repository.UserRepositoy;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepositoy userRepository;
	
	@Autowired
	private PostRepositoy postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2022"), "Partiu viagem", "Vou viajar para Guarujá, pegar uma praia. Abraço! ", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("21/07/2023"), "Boa noite!", "Estou mega felix hoje", new AuthorDTO(maria));

		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
