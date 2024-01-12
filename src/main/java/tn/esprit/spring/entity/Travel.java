package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Travel implements Serializable{
	

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long travelId;
	@Enumerated(EnumType.STRING)
	private Statut status ;
	@Temporal(TemporalType.DATE)
	private Date dateDeparting;
	@Temporal(TemporalType.DATE)
	private Date dateReturning;
	private String destination;
	private String perimeter;
	
	
	
	@ManyToOne
	@JsonIgnore
	private User user;
	@OneToMany(cascade = CascadeType.ALL , mappedBy="travel")
	@JsonIgnore
	private List<Matching> matchings;
	
}
