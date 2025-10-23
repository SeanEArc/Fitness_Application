package com.Arc.FitnessApp.controller;


import com.Arc.FitnessApp.models.DailyLoggedFood;
import com.Arc.FitnessApp.models.MealLog;
import com.Arc.FitnessApp.services.DailyLoggedFoodService;
import com.Arc.FitnessApp.services.MealLogService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/meal-logs")
public class MealLogController {

    private final MealLogService mealLogService;
    private final DailyLoggedFoodService dailyLoggedFoodService;

    public MealLogController(MealLogService mealLogService, DailyLoggedFoodService dailyLoggedFoodService) {
        this.mealLogService = mealLogService;
        this.dailyLoggedFoodService = dailyLoggedFoodService;
    }

    @GetMapping
    public List<MealLog> getAllMealLogs() {
        return mealLogService.getAllMealLogs();
    }

    // Get meal logs by meal type
    @GetMapping("/daily-log/{dailyLogId}")
    public ResponseEntity<List<MealLog>> getMealLogsByDailyFoodLog(@PathVariable Long dailyLogId) {
        Optional<DailyLoggedFood> dailyLog = dailyLoggedFoodService.getLogById(dailyLogId);
        if (dailyLog.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<MealLog> logs =mealLogService.getMealLogsByDailyLog(dailyLog.get());
        return ResponseEntity.ok(logs);
    }


    @GetMapping("/meal-types/{mealType}")
    public List<MealLog> getMealLogsByMealType(@PathVariable String mealType) {
        return mealLogService.getMealLogsByMealType(mealType);
    }

    // Create new meal log for a specific daily log
    @PostMapping("/daily-log/{dailyLogId}")
    public ResponseEntity<MealLog> createMealLog(@PathVariable Long dailyLogId, @RequestBody MealLog mealLog){

        Optional<DailyLoggedFood> dailyLog = dailyLoggedFoodService.getLogById(dailyLogId);
        if (dailyLog.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        mealLog.setDailyLoggedFood(dailyLog.get());
        MealLog savedMealLog = mealLogService.saveMealLog(mealLog);
        return ResponseEntity.ok(savedMealLog);

    }

    @PutMapping("update-meal-log/id/{id}")
    public ResponseEntity<MealLog> updateMealLog(@PathVariable long id, @RequestBody MealLog updatedMealLog) {
        Optional<MealLog> existingMealLogOpt  = mealLogService.getMealLogById(id);


        if(existingMealLogOpt .isEmpty()){
            return ResponseEntity.notFound().build();
        }

        MealLog existingMealLog = existingMealLogOpt.get();

        if (updatedMealLog.getMealType() != null) {
            existingMealLog.setMealType(updatedMealLog.getMealType());
        }

        if (updatedMealLog.getDailyLoggedFood() != null) {
            existingMealLog.setDailyLoggedFood(updatedMealLog.getDailyLoggedFood());
        }

        MealLog savedMealLog = mealLogService.saveMealLog(existingMealLog);
        return ResponseEntity.ok(savedMealLog);
    }



    @DeleteMapping("/{id}")
    public void deleteMealLog(@PathVariable Long id) {
        mealLogService.deleteMealLog(id);
    }



}
