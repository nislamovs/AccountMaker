package com.accountmaker.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="APP_USER")
public @Data class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	@Getter @Setter private int id;

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	@Getter @Setter private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Getter @Setter private String password;

	@Column(name = "firstname")
	@NotEmpty(message = "*Please provide your name")
	@Getter @Setter private String name;

	@Column(name = "lastname")
	@NotEmpty(message = "*Please provide your last name")
	@Getter @Setter private String lastName;

	@Column(name = "active")
	@Getter @Setter private int active;

	@Column(name = "activation_keyword")
	@Getter @Setter private String keyword;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "registration_date")
	@Getter @Setter private DateTime regdate;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	@Getter @Setter private Set<Role> roles;

}
