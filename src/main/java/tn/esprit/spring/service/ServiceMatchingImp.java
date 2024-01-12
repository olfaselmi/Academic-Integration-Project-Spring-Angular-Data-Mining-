package tn.esprit.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Matching;
import tn.esprit.spring.entity.Statut;
import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.MatchingRepository;
import tn.esprit.spring.repository.TravelRepository;
import tn.esprit.spring.repository.UserRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ServiceMatchingImp implements IServiceMatching {
	
	@Autowired
	MatchingRepository mr;
	@Autowired
	UserRepository UserRepository;
	@Autowired
	TravelRepository TravelRepository;
	@Autowired 
	ServiceTravelImp st;

	@Override
	public void addMatching( Long Id) {


		User u = UserRepository.findById(Id).orElse(null);
		Travel tr = TravelRepository.findFirstByDateDepartingAfterAndUserOrderByDateDeparting(new Date(), u);
		List<Travel> travels=TravelRepository.findAll().stream().filter(t->!u.getTravels().contains(t))
				.filter(e->e.getDateDeparting().before(tr.getDateDeparting())).
				filter(e->e.getDateReturning().after(tr.getDateDeparting())).filter(e->!e.getStatus().equals(Statut.Canceled))
				.filter(e->e.getDestination().equals(tr.getDestination())).collect(Collectors.toList());
			         

	  for (Travel t : travels) {
		  Matching matching=new Matching();
		   matching.setUser1(u);
		   matching.setUser2(t.getUser());
		   matching.setTravel(tr);
		   matching.setMatchuser1("no");
		   matching.setMatchuser2("no");
		   mr.save(matching);
	}
		
	}
}