package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String login;
	private String password;
	private String photo;
	private String firstName;
	private String lastName;
	private String email;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	


	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private List<Travel> travels;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user1")
	@JsonIgnore
	private List<Matching> matching1;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user2")
	@JsonIgnore
	private List<Matching> matching2;
	

}
