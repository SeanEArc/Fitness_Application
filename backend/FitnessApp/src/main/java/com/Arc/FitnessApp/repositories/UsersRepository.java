package com.Arc.FitnessApp.repositories;


import com.Arc.FitnessApp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long> {

    Users findByUsername(String username);

}
