package com.Arc.FitnessApp.repositories;

import com.Arc.FitnessApp.models.MealFoodItem;
import com.Arc.FitnessApp.models.MealLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealFoodItemRepository extends JpaRepository<MealFoodItem, Long> {

    List<MealFoodItem> findByMealLog(MealLog mealLog);

//    THIS IS FOR AFTER I CREATE FOODITEM ENTITY
//    List<MealFoodItem> findByFoodItem(FoodItem foodItem0);
//
//    List<MealFoodItem> findByCustomMeal(CustomMeal customMeal);

    List<MealFoodItem> findByMealLogId(Long mealLogId);

}
