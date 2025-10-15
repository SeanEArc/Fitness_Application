package com.Arc.FitnessApp.services;

import com.Arc.FitnessApp.models.Users;
import com.Arc.FitnessApp.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service annotation is used to indicate that this class is a service class. It is a specialization of the @Component annotation.
// This is a class that contains business logic and calls methods in the repository layer.
// Essentially, it acts as a bridge between the controller and repository layers.
// Analogy: This is the workshop and the controller is the customer.
// The customer (controller) comes to the workshop (service) with a request, and the workshop (service) processes the request and calls the repository (toolbox) to get the job done.

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService (UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<Users> getUserById(long id) {
        return usersRepository.findById(id);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users saveUser(Users users) {
        return usersRepository.save(users);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }




}
