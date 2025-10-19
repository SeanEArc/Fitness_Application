package com.Arc.FitnessApp.models;

/*
Table meal_log {
  id integer [primary key, increment]
  daily_logged_food_id integer [not null, ref: > daily_logged_food.id]
  meal_type varchar(50) [not null, note: 'e.g., breakfast, lunch, dinner, snack']

  Indexes {
    (daily_logged_food_id)
    (meal_type)
  }
}
*/

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEAL_LOG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealLog {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "daily_logged_food_id", nullable = false)
    private DailyLoggedFood dailyLoggedFood;

    @Column(name = "meal_type", nullable = false)
    private String mealType;



}
