package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Matching implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchingId;
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee1_id")
	private User user1;
	
	private String matchuser1;
	
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee2_id")
	private User user2;
	
	
	
	
	private String matchuser2;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "travelId")
	private Travel travel;
	
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
}
