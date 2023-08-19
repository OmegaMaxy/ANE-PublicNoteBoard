package com.hydrax.backend.user;

import com.hydrax.backend.user.exceptions.UserNotFoundException;
import com.hydrax.backend.user.exceptions.UsernameTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public UserDTO addNewUser(User user) {
        Optional<UserDTO> userOptional = userRepository.findUserByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw new UsernameTakenException();
        }
        return userDTOMapper.apply(userRepository.save(user));
    }

    public Optional<UserDTO> getUser(Long id) {
        Optional<UserDTO> userOptional = userRepository.findById(id).map(userDTOMapper);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        return userOptional;
    }
}
