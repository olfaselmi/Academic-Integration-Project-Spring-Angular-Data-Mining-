package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Matching;

@Repository
public interface MatchingRepository extends CrudRepository<Matching, Long>   {
	

}
