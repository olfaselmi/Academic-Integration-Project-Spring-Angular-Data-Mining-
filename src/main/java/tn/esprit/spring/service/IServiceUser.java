package tn.esprit.spring.service;

import tn.esprit.spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface IServiceUser {

	public List<User>retrieveAllUser();
	public void deleteUser (long Id);
	public Optional<User> retrieveUserById(long Id);
	public User retrieveUserByName (Long id);
	public User addUser(User user);
	public User updateUser(User user);

}
