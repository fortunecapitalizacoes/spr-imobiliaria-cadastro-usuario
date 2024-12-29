package br.com.tbg.ptg.nominacao.infra.entrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.tbg.ptg.nominacao.application.dto.UserDTO;
import br.com.tbg.ptg.nominacao.domain.DomainService;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/users")
@Log
public class UserController {
	
	@Autowired
	private DomainService domainService;
	
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody UserDTO userDto) {
        return ResponseEntity.ok(domainService.registerUser(userDto));
    }
}
