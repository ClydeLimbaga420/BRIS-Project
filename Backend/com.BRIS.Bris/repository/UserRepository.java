package com.BRIS.Login.repository;

import com.BRIS.Login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByGmailAccountAndPassword(String gmailAccount, String password);
}
