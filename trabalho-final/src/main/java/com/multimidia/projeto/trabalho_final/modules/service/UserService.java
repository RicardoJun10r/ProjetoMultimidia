package com.multimidia.projeto.trabalho_final.modules.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multimidia.projeto.trabalho_final.modules.config.ModelMapperConfig;
import com.multimidia.projeto.trabalho_final.modules.model.User;
import com.multimidia.projeto.trabalho_final.modules.repo.UserRepo;
import com.multimidia.projeto.trabalho_final.modules.shared.UserResponseDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    private ModelMapper mapper = new ModelMapperConfig().modelMapper();

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> mapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    public User findById(UUID id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user;
        }
        return null;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
