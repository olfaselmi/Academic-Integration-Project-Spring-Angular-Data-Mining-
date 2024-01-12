package tn.esprit.spring.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.service.IServiceMatching;


@RestController
@Api(tags = "Matching")
@RequestMapping("/matching")
public class MatchingRestController {

	
	@Autowired
	IServiceMatching matchingservice;
	
	
	
	
	
	
	 @PostMapping("/addmatching/{id}")
		@ResponseBody
			public void addMatching(@PathVariable("id") Long Id) {
				 matchingservice.addMatching( Id);
    
		}
	 
	 
	 
}

