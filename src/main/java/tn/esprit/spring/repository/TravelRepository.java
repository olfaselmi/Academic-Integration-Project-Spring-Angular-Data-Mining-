package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.User;

import java.util.Date;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long>  {
//public List<Travel> findByUser(User user);
public Travel findFirstByDateDepartingAfterAndUserOrderByDateDeparting(Date date,User u);
public List<Travel> findByUser(User user);
public Integer countTravelByDestination(String des);
    public Integer countTravelByUser(User u);
}
