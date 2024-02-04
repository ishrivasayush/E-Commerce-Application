package com.narainox.ecommercebackendapplication;

import com.narainox.ecommercebackendapplication.models.Role;
import com.narainox.ecommercebackendapplication.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class  ECommerceBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
		try{
			Role role=new Role();
			role.setId(501);
			role.setName("ADMIN");

			Role role1=new Role();
			role1.setId(502);
			role1.setName("USER");


			List<Role> list = List.of(role, role1);
			List<Role> roles = roleRepository.saveAll(list);

			roles.forEach(r->
					System.out.println(r.getName()));


		}
		catch (Exception e)
		{

		}
	}
}
