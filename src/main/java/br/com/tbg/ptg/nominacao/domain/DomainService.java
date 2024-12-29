package br.com.tbg.ptg.nominacao.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tbg.ptg.nominacao.application.dto.UserDTO;
import br.com.tbg.ptg.nominacao.application.mapper.UserMapper;
import br.com.tbg.ptg.nominacao.domain.models.User;

@Service
public class DomainService {
	
	@Autowired
	private UserMapper mapper;
		
	public User registerUser(UserDTO user) {	
		return mapper.fromDtoToModel(user);
	}
	
}