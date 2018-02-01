package com.accountmaker.springboot.model.webServices;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="inboxlv")
public class InboxLv {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "firstname", nullable=false)
    @NotEmpty(message = "*Please provide your first name")
    @Getter @Setter private String firstname;

    @Column(name = "lastname", nullable=false)
    @NotEmpty(message = "*Please provide your last name")
    @Getter @Setter private String lastname;

    @Column(name = "username", nullable=false)
    @NotEmpty(message = "*Please provide your username")
    @Getter @Setter private String username;

    @Column(name = "password", nullable=false)
    @NotEmpty(message = "*Please provide your password")
    @Getter @Setter private String password;

    @Column(name = "birthday_month", nullable=false)
    @NotEmpty(message = "*Please provide your birthday month")
    @Getter @Setter private String birthdayMonth;

    @Column(name = "birthday_day", nullable=false)
    @NotEmpty(message = "*Please provide your birthday date")
    @Getter @Setter private String birthdayDay;

    @Column(name = "birthday_year", nullable=false)
    @NotEmpty(message = "*Please provide your birthday year")
    @Getter @Setter private String birthdayYear;

    @Column(name = "gender", nullable=false)
    @NotEmpty(message = "*Please provide your gender")
    @Getter @Setter private String gender;

    @Column(name = "phonenumber")
    @Getter @Setter private String phonenumber;

    @Column(name = "current_email")
    @Getter @Setter private String currentEmail;

    @Column(name = "location")
    @Getter @Setter private String location;

}
