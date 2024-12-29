package br.com.tbg.ptg.nominacao.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	
	private String id;

	private String name; // nome de pessoa ja cadastrada no banco.

	private String email;

	private String login;

	private String password;

	private String roles;
	
}
