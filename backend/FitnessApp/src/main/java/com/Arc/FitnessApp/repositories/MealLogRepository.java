package com.Arc.FitnessApp.repositories;


import com.Arc.FitnessApp.models.DailyLoggedFood;
import com.Arc.FitnessApp.models.MealLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealLogRepository extends JpaRepository<MealLog, Long> {

    Optional<MealLog> findFirstByMealType(String mealType);

    List<MealLog> findByMealType(String mealType);

    List<MealLog> findByDailyLoggedFood(DailyLoggedFood dailyLoggedFood);

}
