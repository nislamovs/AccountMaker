package com.accountmaker.springboot.repositories;

import com.accountmaker.springboot.model.webServices.Github;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubRepository extends JpaRepository<Github, Long> {

    Github findByFirstname(String name);

}
