package com.Arc.FitnessApp.services;

import com.Arc.FitnessApp.models.FoodItem;
import com.Arc.FitnessApp.models.MealFoodItem;
import com.Arc.FitnessApp.models.MealLog;
import com.Arc.FitnessApp.repositories.MealFoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealFoodItemService {

    private final MealFoodItemRepository mealFoodItemRepository;

    public MealFoodItemService(MealFoodItemRepository mealFoodItemRepository) {
        this.mealFoodItemRepository = mealFoodItemRepository;
    }

    public List<MealFoodItem> getAllMealFoodItems() {
        return mealFoodItemRepository.findAll();
    }

    public Optional<MealFoodItem> getMealFoodItemById(Long id) {
        return mealFoodItemRepository.findById(id);
    }

    public List<MealFoodItem> getMealFoodItemsByMealLog(MealLog mealLog) {
        return mealFoodItemRepository.findByMealLog(mealLog);
    }

    public List<MealFoodItem> getMealFoodItemsByMealLogId(Long mealLogId) {
        return mealFoodItemRepository.findByMealLogId(mealLogId);
    }

    // NEED A SERVICE METHOD TO GET MEAL LOG BY CUSTOM MEAL
    public List<MealFoodItem> getMealFoodItemsByFoodItem(FoodItem foodItem) {
        return mealFoodItemRepository.findByFoodItem(foodItem);
    }

    public MealFoodItem saveMealFoodItem(MealFoodItem mealFoodItem) {
        return mealFoodItemRepository.save(mealFoodItem);
    }

    public void deleteMealFoodItem(Long id) {
        mealFoodItemRepository.deleteById(id);
    }

}
