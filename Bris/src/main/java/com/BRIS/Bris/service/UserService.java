package com.BRIS.Bris.service;

import com.BRIS.Bris.entity.User;
import com.BRIS.Bris.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User postUser(User user) {
        return userRepository.save(user);
    }

}
