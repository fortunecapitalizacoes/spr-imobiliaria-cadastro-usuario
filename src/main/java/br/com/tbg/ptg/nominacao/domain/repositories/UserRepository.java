package br.com.tbg.ptg.nominacao.domain.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tbg.ptg.nominacao.domain.models.User;

public interface UserRepository extends MongoRepository<User , String>{

	public User findByEmail(String email);
	
}
