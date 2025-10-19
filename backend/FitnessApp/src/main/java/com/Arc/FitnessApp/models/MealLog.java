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
    @JoinColumn(name = "DailyLoggedFood_id")
    private DailyLoggedFood dailyLoggedFood;

    private String mealType;



}
