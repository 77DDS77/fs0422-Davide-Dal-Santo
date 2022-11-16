package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Entities.User;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    @Autowired
    PasswordEncoder encoder;

    /**
     * method to save and persist in db a User entity
     */
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return ur.save(user);
    }

    /**
     * simple get All Users, return an iterable of Users
     */
    public Iterable<User> getAllUsers() {
        return ur.findAll();
    }

    /**
     * simple get All Users, return a pageable of users for lighter payloads
     */
    public Page<User> getAllUsersPageable(Pageable p) {
        return ur.findAll(p);
    }

    /**
     * easy find by id, if id is non-existent throws an exception
     */
    public User findById(Long id) throws ByIdNotFoundException {
        Optional<User> found = ur.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new ByIdNotFoundException("User", id);
    }

    /**
     * update, takes the ID of the "original" User and a User object to get the props that we will
     * assign to the original, now updated, User.
     */
    public User updateUser(Long id, User updatedUser) throws ByIdNotFoundException {
        User origUser = findById(id);
        origUser.setNome(updatedUser.getNome());
        origUser.setCognome(updatedUser.getCognome());
        origUser.setEmail(updatedUser.getEmail());
        origUser.setUsername(updatedUser.getUsername());
        origUser.setRoles(updatedUser.getRoles());
        //TODO capire se e come fare il cambio password
        ur.save(origUser);
        return origUser;
    }

    /**
     * throws IllegalArgumentException
     */
    public String deleteUser(Long id) {
        ur.deleteById(id);
        return "User delete successfully";
    }
}
