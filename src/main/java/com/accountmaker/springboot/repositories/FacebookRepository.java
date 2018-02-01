package com.accountmaker.springboot.repositories;

import com.accountmaker.springboot.model.webServices.Facebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookRepository extends JpaRepository<Facebook, Long> {

    Facebook findByFirstname(String name);
}
