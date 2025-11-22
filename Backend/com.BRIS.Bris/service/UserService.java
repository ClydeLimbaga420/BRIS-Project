package com.BRIS.Login.service;

import com.BRIS.Login.entity.User;
import com.BRIS.Login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String gmailAccount, String password) {
        password = hashPassword(password);
        return userRepository.findByGmailAccountAndPassword(gmailAccount, password);
    }

    private String hashPassword(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public User findByGmail(String gmail) {
        return userRepository.findByGmailAccount(gmail);
    }

    public void saveResetToken(User user, String token) {
        user.setResetToken(token);
        userRepository.save(user);
    }


    public User findByResetToken(String token) {
        return userRepository.findByResetToken(token);
    }


    public void updatePassword(User user, String newPassword) {
        user.setPassword(hashPassword(newPassword));
        user.setResetToken(null);
        userRepository.save(user);
    }
}
