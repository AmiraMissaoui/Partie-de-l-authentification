package com.example.stage22.Service;
import com.example.stage22.Entity.User;
import com.example.stage22.dto.UserDto;

public interface UserServiceInterface {
    User save(UserDto userDto);
}
