package com.accountmaker.springboot.repositories;

import com.accountmaker.springboot.model.webServices.Gmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GmailRepository extends JpaRepository<Gmail, Long> {

    Gmail findByFirstname(String name);
}
