package br.com.tbg.ptg.nominacao.infra.entrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import br.com.tbg.ptg.nominacao.application.dto.LoginRequestDTO;
import br.com.tbg.ptg.nominacao.application.dto.LoginResponseDTO;
import br.com.tbg.ptg.nominacao.application.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtService jwtService;

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
	       
	    	try {
	            Authentication authentication = authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            loginRequest.getEmail(),
	                            loginRequest.getPassword()
	                    )
	            );

	            String token = jwtService.generateToken(authentication.getName());
	            return ResponseEntity.ok(new LoginResponseDTO(token));

	        } catch (AuthenticationException ex) {
	            return ResponseEntity.badRequest().body("Credenciais inválidas: " + ex.getMessage());
	        }
	    }
}
