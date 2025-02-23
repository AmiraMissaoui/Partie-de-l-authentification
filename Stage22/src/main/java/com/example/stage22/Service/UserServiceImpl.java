package com.example.stage22.Service;

import com.example.stage22.Entity.User;
import com.example.stage22.dto.UserDto;
import com.example.stage22.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired; // Ajout de l'import
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired  // Ajout de l'annotation pour injecter automatiquement UserRepository
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getRole(), userDto.getFullname());
        return userRepository.save(user);
    }
}
