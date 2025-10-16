package com.Arc.FitnessApp.repositories;

import com.Arc.FitnessApp.models.DailyLoggedFood;
import com.Arc.FitnessApp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DailyLoggedFoodRepository extends JpaRepository<DailyLoggedFood, Long> {

    List <DailyLoggedFood> findByUser(Users user);

    Optional<DailyLoggedFood> findByUserAndLogDate(Users users, LocalDate logDate);



}
