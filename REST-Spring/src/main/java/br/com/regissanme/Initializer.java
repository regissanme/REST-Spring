package br.com.regissanme;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import br.com.regissanme.auth.entity.Role;
import br.com.regissanme.auth.entity.User;
import br.com.regissanme.auth.service.RoleService;
import br.com.regissanme.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class Initializer {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostConstruct
	public void criaUsuariosEPermissoes() {
		Role roleAdmin = new Role();

		roleAdmin.setName("ADMIN");

		roleService.save(roleAdmin);

		User user = new User();
		user.setAtivo(true);
		user.setEmail("rsanme@gmail.com");
		user.setNome("Regis Sanme");
		user.setSenha(new BCryptPasswordEncoder().encode("admin"));
		user.setUsername("regissanme");
		user.setRoles(List.of(roleAdmin));

		User save = userService.save(user);
		System.out.println("User saved: " + save);

	}
}
