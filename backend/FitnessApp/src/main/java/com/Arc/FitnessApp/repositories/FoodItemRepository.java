package com.Arc.FitnessApp.repositories;

import com.Arc.FitnessApp.models.FoodItem;
import com.Arc.FitnessApp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    //Find all public foods
    List <FoodItem> findByIsPublic(boolean isPublic);

    // Find food items created by the user
    List<FoodItem> findByCreatedBy(Users users);

    List <FoodItem> findByNameContainingIgnoreCase(String foodName);

}
