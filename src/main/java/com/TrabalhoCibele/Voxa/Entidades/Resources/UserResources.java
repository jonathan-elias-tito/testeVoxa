package com.TrabalhoCibele.Voxa.Entidades.Resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrabalhoCibele.Voxa.Entidades.Services.UserServices;
import com.TrabalhoCibele.Voxa.Entities.User;

@RestController
public class UserResources {

	private final UserServices  userServices;
	public UserResources(UserServices  userServices) {
		this.userServices=userServices;
	}

	@RequestMapping(value="/Users")
	@PostMapping
	public ResponseEntity <User> InsertUser(@RequestBody User user){
		user = userServices.InsertUser(user);
		return ResponseEntity.ok().body(user);
	
	}
}

