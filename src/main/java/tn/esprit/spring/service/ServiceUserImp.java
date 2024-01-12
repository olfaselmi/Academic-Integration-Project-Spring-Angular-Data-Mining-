package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserImp implements IServiceUser {
	
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public List<User> retrieveAllUser() {
		
		return  (List<User>) UserRepository.findAll();
	}
	@Override
	public void deleteUser(long Id) {
		UserRepository.deleteById(Id);
		
	}
	@Override
	public Optional<User> retrieveUserById(long Id) {
		
		return UserRepository.findById(Id) ;
	}
	@Override
	public User addUser(User user) {
		return UserRepository.save(user);
		
	}

	@Override
	public User updateUser(User user) {
		return UserRepository.save(user);
	}
	
	@Override
	public User retrieveUserByName(Long Id) {
		// TODO Auto-generated method stub
		return null;
	
}
	}