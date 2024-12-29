package br.com.tbg.ptg.nominacao.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tbg.ptg.nominacao.application.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class User {

	@Id
	private String id;

	private String name; // nome de pessoa ja cadastrada no banco. 
	
    private String email;
    
    private String login;
    
    private String password;
    
    private String roles;
    
}
