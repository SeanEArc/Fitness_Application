package com.Arc.FitnessApp.controller;

import com.Arc.FitnessApp.models.FoodItem;
import com.Arc.FitnessApp.models.Users;
import com.Arc.FitnessApp.services.FoodItemService;
import com.Arc.FitnessApp.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/food-item")
public class FoodItemController {

    private final FoodItemService foodItemService;
    private final UsersService usersService;

    public FoodItemController (FoodItemService foodItemService, UsersService usersService) {
        this.foodItemService = foodItemService;
        this.usersService = usersService;
    }

    // Get all Food Items List
    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    // Get Food Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        return foodItemService.getFoodItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Get List of Public Food Items
    @GetMapping("/public")
    public List<FoodItem> getPublicFoodItems() {
        return foodItemService.getAllPublicFoodItems();
    }

    // Get List of Food Items by food name
    @GetMapping("/food-name/{name}")
    public List<FoodItem> getFoodItemsByName(@PathVariable String name){
        return foodItemService.getFoodItemsByName(name);
    }

    // Get Food Items By User
    @GetMapping("user/{userId}")
    public ResponseEntity<List<FoodItem>> searchCreatedFoodByUser(@PathVariable Long id){
        Optional<Users> user = usersService.getUserById(id);
        if (user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<FoodItem> foodItems = foodItemService.searchFoodItemsByUser(user.get());
        return ResponseEntity.ok(foodItems);
    }

    // Create a Food Item
    @PostMapping("create")
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
        FoodItem savedItem = foodItemService.saveFoodItem(foodItem);
        return ResponseEntity.ok(savedItem);
    }

    // Update Food Item
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem updatedFoodItem){
        Optional<FoodItem> existingFoodItem = foodItemService.getFoodItemById(id);

        if(existingFoodItem.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        FoodItem foodItem = existingFoodItem.get();

        foodItem.setName(updatedFoodItem.getName());
        foodItem.setCalories(updatedFoodItem.getCalories());
        foodItem.setProtein(updatedFoodItem.getProtein());
        foodItem.setCarbs(updatedFoodItem.getCarbs());
        foodItem.setFats(updatedFoodItem.getFats());
        foodItem.setServing_size(updatedFoodItem.getServing_size());
        foodItem.setPublic(updatedFoodItem.isPublic());
        foodItem.setCreatedBy(updatedFoodItem.getCreatedBy());

        FoodItem savedItem = foodItemService.saveFoodItem(foodItem);
        return ResponseEntity.ok(savedItem);


    }

    // Delete Food Item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        Optional <FoodItem> existingFoodItem = foodItemService.getFoodItemById(id);
        if (existingFoodItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        foodItemService.deleteFoodItem(id);
        return ResponseEntity.noContent().build();

    }

}
