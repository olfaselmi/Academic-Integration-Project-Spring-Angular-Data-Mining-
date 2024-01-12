package tn.esprit.spring.service;

import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface IServiceTravel {

	public List<Travel> retrieveAllTravel();
	public void deleteTravel (Long id);
	public Optional<Travel> retrieveTravelById(Long id);
	public Travel retrieveTravelName (Long id);
	public Travel addTravel(Travel travel,Long Id,Long camp);
	public Travel updateTravel(Travel travel);
	public List<Travel> getTravelUser(Long Id);
	public Map<Long,Travel> getCompagnion(Long Id);
	public String TopDest();
	public User MostTravledUser();

}
