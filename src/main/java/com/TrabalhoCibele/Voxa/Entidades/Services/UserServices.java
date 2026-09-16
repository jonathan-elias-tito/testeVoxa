package com.TrabalhoCibele.Voxa.Entidades.Services;

import org.springframework.stereotype.Service;

import com.TrabalhoCibele.Voxa.Entities.User;
import com.TrabalhoCibele.Voxa.Repository.UserRepository;

@Service
public class UserServices {
	private final UserRepository userRepository;

	public UserServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User InsertUser(User user) {
		return userRepository.save(user);
	}
}