package tn.esprit.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Statut;
import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.TravelRepository;
import tn.esprit.spring.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
@Service
public class ServiceTravelImp implements IServiceTravel {


	@Autowired
	TravelRepository TravelRepository;
	@Autowired
	UserRepository UserRepository;


	@Override
	public List<Travel> retrieveAllTravel() {

		return (List<Travel>) TravelRepository.findAll();
	}


	@Override
	public void deleteTravel(Long id) {
		TravelRepository.deleteById(id);

	}

	@Override
	public Optional<Travel> retrieveTravelById(Long id) {

		return TravelRepository.findById(id);
	}

	@Override
	public Travel addTravel(Travel travel, Long Id, Long camp) {
		User user2 = UserRepository.findById(camp).orElse(null);
		if (user2 == null) {
			log.info("invalid user");
			return null;
		}

		if (user2.getCategorie() != Categorie.Company) {
			log.info("not a Company");
			return null;
		}

		if (travel.getDateReturning().after(travel.getDateDeparting())) {
			User u = UserRepository.findById(Id).orElse(null);
			travel.setUser(u);
			return TravelRepository.save(travel);
		}
		log.info("Date invalid");
		return null;

	}

	@Override
	public Travel updateTravel(Travel travel) {

		return TravelRepository.save(travel);
	}


	@Override
	public Travel retrieveTravelName(Long id) {

		return null;
	}


	//get travel by user
	@Override
	public List<Travel> getTravelUser(Long Id) {

		User user = UserRepository.findById(Id).orElse(null);
		return TravelRepository.findByUser(user);


	}


	@Override
	public Map<Long, Travel> getCompagnion(Long Id) {

		User u = UserRepository.findById(Id).orElse(null);
		if (u == null)
			return null;
		Travel tr = TravelRepository.findFirstByDateDepartingAfterAndUserOrderByDateDeparting(new Date(), u);

		Map<Long, Travel> map = new HashMap<Long, Travel>();

		List<Travel> travels = TravelRepository.findAll().stream().filter(t -> !u.getTravels().contains(t))
				.filter(e -> e.getDateDeparting().before(tr.getDateDeparting())).
				filter(e -> e.getDateReturning().after(tr.getDateDeparting())).filter(e -> !e.getStatus().equals(Statut.Canceled))
				.filter(e -> e.getDestination().equals(tr.getDestination())).collect(Collectors.toList());

		for (Travel t : travels) {
			map.put(t.getUser().getId(), t);
		}

		return map;

	}

	public String TopDest() {
		List<Travel> travels = TravelRepository.findAll();
		return travels.stream().max((u, v) -> TravelRepository.countTravelByDestination(u.getDestination()) -
				TravelRepository.countTravelByDestination(v.getDestination())).map(t -> t.getDestination()).orElse(null);
	}

	public User MostTravledUser() {
		List<Travel> travels = TravelRepository.findAll();
		return travels.stream().max((u, v) -> TravelRepository.countTravelByUser(u.getUser()) -
				TravelRepository.countTravelByUser(v.getUser())).map(t -> t.getUser()).orElse(null);

	}
}

