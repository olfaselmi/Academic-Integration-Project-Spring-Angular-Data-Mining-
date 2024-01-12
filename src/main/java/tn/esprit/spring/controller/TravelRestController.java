package tn.esprit.spring.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.TravelRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.IServiceTravel;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@Api(tags = "travel")
@RequestMapping("/travel")
public class TravelRestController {
	
	@Autowired
	IServiceTravel travelservice;
	@Autowired
	TravelRepository tr;
	@Autowired
	UserRepository userRepository;


	
	@GetMapping("/travels")
	@ResponseBody
	public List<Travel> getTravels(){
		return travelservice.retrieveAllTravel();
	}
	
	
	@GetMapping("/travel/{id}")
	@ResponseBody
	public Optional<Travel> getTravelById(@PathVariable("id") Long id){
		return travelservice.retrieveTravelById(id);
		
	}
		
		 @PostMapping("{idcamp}/addtravel/{id}")
		@ResponseBody
			public Travel addTravel(@RequestBody Travel travel,@PathVariable("id") Long Id,@PathVariable("idcamp")Long camp) {
				return travelservice.addTravel(travel, Id,camp);
       
		}
		 @GetMapping("/listeComplaints/{Id}")
		 @ResponseBody
		 List<Travel> getTravelByUser(@PathVariable("Id") Long Id) {
		 return travelservice.getTravelUser(Id);
		 }

@GetMapping("/getcompagion/{Id}")
@ResponseBody
public Map<Long,Travel> getCompagnion(@PathVariable("Id") Long Id){
	   return travelservice.getCompagnion(Id);

}



		 
		
			@PutMapping("/updatetravel")
			@ResponseBody
			public Travel updateTravel(@RequestBody Travel travel) {
			return travelservice.updateTravel(travel);
			}
			
			@DeleteMapping("/deletetravel/{travelId}")
			@ResponseBody
			@CrossOrigin
			public void removeClient(@PathVariable("travelId") Long travelId) {
			travelservice.deleteTravel(travelId);
			}

	@GetMapping("/getDestination/{destination}")
	@ResponseBody
	public Integer getDestination (@PathVariable("destination") String des){
		return tr.countTravelByDestination(des);

	}
	@GetMapping("/Top")
	@ResponseBody
	public String getTop (){
		return travelservice.TopDest();

	}
	@GetMapping("/getNombreTravel/{id}")
	@ResponseBody
	public Integer getNbTravel (@PathVariable("id") Long id){
		User user=userRepository.findById(id).orElse(null);
		return tr.countTravelByUser(user);

	}
	@GetMapping("/MostUser")
	@ResponseBody
	public User getMostUser (){
		return travelservice.MostTravledUser();

	}


}