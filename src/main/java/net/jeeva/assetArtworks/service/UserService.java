package net.jeeva.assetArtworks.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.jeeva.assetArtworks.model.User;
import net.jeeva.assetArtworks.web.dto.UserDto;


public interface UserService {
	
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}