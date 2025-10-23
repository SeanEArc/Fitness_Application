package com.Arc.FitnessApp.models;
/*
 Table meal_food_item {
  id integer [primary key, increment]
  meal_log_id integer [not null, ref: > meal_log.id]
  food_item_id integer [ref: > food_item.id]
  custom_meal_id integer [ref: > custom_meal.id]
  servings float [not null, default: 1]

  Note: 'Either food_item_id OR custom_meal_id is used per record.'

  Indexes {
    (meal_log_id)
    (food_item_id)
    (custom_meal_id)
  }
}*/

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEAL_FOOD_ITEMS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealFoodItem {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_log_id", nullable = false)
    @JsonBackReference
    private MealLog mealLog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

// GOING TO FINISH THIS ONCE I COMPLETE CUSTOM MEAL

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "custom_meal_id")
//    private CustomMeal customMeal

    @Column(nullable = false)
    @Builder.Default
    private float servings = 1f;

//    public boolean isCustomMeal() {
//        return customMeal != null;
//    }


}
