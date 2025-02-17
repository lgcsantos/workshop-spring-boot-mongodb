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
import com.lgcsantos.workshopmongo.dto.CommentDto;
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
		Post post2 = new Post(null,sdf.parse("21/07/2023"), "Boa noite!", "Estou mega feliz hoje", new AuthorDTO(maria));
		
		CommentDto c1 = new CommentDto(null, "Boa Viagem Mano!", sdf.parse("21/07/2022"), new AuthorDTO(alex));
		CommentDto c2 = new CommentDto(null, "Aproveite!", sdf.parse("15/08/2022"), new AuthorDTO(bob));
		CommentDto c3 = new CommentDto(null, "Tenha um ótimo dia!", sdf.parse("14/12/2022"), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
	
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
	
	
}
