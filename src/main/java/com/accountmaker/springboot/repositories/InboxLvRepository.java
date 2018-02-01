package com.accountmaker.springboot.repositories;

import com.accountmaker.springboot.model.webServices.InboxLv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboxLvRepository  extends JpaRepository<InboxLv, Long> {

    InboxLv findByFirstname(String name);
}
