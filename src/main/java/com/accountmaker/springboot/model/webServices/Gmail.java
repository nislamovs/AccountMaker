package com.accountmaker.springboot.model.webServices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name="gmail")
public class Gmail implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter private Long id;

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

    public Gmail() {}

    public Gmail(boolean isRandom) {
        if(isRandom) {
            this.firstname = RandomStringUtils.randomAlphanumeric(15);
            this.lastname = RandomStringUtils.randomAlphanumeric(15);
            this.username = RandomStringUtils.randomAlphanumeric(15);
            this.password = RandomStringUtils.randomAlphanumeric(15);
            this.birthdayMonth = Month.getRandomMonth().toString();
            this.birthdayDay = getRandomBirthday();
            this.birthdayYear = getRandomBirthYear();
            this.gender = Gender.getRandomGender().toString();
        }
    }

    public enum Gender {
        MALE ("Male"), FEMALE ("Female"),
        OTHER ("Other"), RATHER_NOT_SAY ("Rather not say");

        private final String gender;

        private Gender(String s) {
            gender = s;
        }

        public boolean equals(String otherGender) {
            return gender.equals(otherGender);
        }

        public static Gender getRandomGender() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

        public String toString() {
            return this.gender;
        }
    }

    public enum Month {
        JANUARY ("January"),
        FEBRUARY ("February"),
        MARCH ("March"),
        APRIL ("April"),
        MAY ("May"),
        JUNE ("June"),
        JULY ("July"),
        AUGUST ("August"),
        SEPTEMBER ("September"),
        OCTOBER ("October"),
        NOVEMBER ("November"),
        DECEMBER ("December");

        private final String month;

        private Month(String month) {
            this.month = month;
        }

        public boolean equals(String otherMonth) {
            return month.equals(otherMonth);
        }

        public static Month getRandomMonth() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

        public String toString() {
            return this.month;
        }
    }

    public static String getRandomBirthday() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 28 + 1));
    }

    public static String getRandomBirthYear() {
        Integer age = ThreadLocalRandom.current().nextInt(19, 65 + 1);
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - age);
    }

    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
