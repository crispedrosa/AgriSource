package br.com.agrisource.user_service.service;

import br.com.agrisource.user_service.model.User;
import br.com.agrisource.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setFullName(user.getFullName());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setCity(user.getCity());
            updatedUser.setState(user.getState());
            updatedUser.setCepCode(user.getCepCode());
            updatedUser.setDateOfBirth(user.getDateOfBirth());
            updatedUser.setUserType(user.getUserType());
            updatedUser.setFarmName(user.getFarmName());
            updatedUser.setFarmDescription(user.getFarmDescription());
            updatedUser.setCertifications(user.getCertifications());
            updatedUser.setActive(user.isActive());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findFarmers() {
        return userRepository.findByUserType("producer");
    }
}
