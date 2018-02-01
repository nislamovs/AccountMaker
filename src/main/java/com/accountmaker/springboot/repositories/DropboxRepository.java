package com.accountmaker.springboot.repositories;

import com.accountmaker.springboot.model.webServices.Dropbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropboxRepository extends JpaRepository<Dropbox, Long> {

    Dropbox findByFirstname(String name);
}