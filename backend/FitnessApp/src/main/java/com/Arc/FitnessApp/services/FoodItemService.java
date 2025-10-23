package com.Arc.FitnessApp.services;

import com.Arc.FitnessApp.models.FoodItem;
import com.Arc.FitnessApp.models.Users;
import com.Arc.FitnessApp.repositories.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService (FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    // Get All Foods
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    //Get All Public Food Items
    public List<FoodItem> getAllPublicFoodItems() {
        return foodItemRepository.findByIsPublic(true);
    }

    //Find by ID
    public Optional<FoodItem> getFoodItemById(long id) {
        return foodItemRepository.findById(id);
    }

    //Search Food by Name (Not Case Sensitive)
    public List <FoodItem> getFoodItemsByName(String foodName) {
        return foodItemRepository.findByNameContainingIgnoreCase(foodName);
    }

    //Search Food Items By User
    public List<FoodItem> searchFoodItemsByUser(Users user) {
        return foodItemRepository.findByCreatedBy(user);
    }

    // Save Food Item
    public FoodItem saveFoodItem(FoodItem foodItem){
        return foodItemRepository.save(foodItem);
    }

    // Delete Food Item
    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }

}
