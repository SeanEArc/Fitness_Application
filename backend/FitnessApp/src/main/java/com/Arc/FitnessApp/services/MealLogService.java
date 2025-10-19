package com.Arc.FitnessApp.services;

import com.Arc.FitnessApp.models.DailyLoggedFood;
import com.Arc.FitnessApp.models.MealLog;
import com.Arc.FitnessApp.models.Users;
import com.Arc.FitnessApp.repositories.MealLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealLogService {

    private final MealLogRepository mealLogRepository;

    public MealLogService(MealLogRepository mealLogRepository) {
        this.mealLogRepository = mealLogRepository;
    }

    public List<MealLog> getAllMealLogs() {
        return mealLogRepository.findAll();
    }

    public Optional<MealLog> getMealLogById(long id) {
        return mealLogRepository.findById(id);
    }

    public List<MealLog> getMealLogsByDailyLog(DailyLoggedFood dailyLoggedFood) {
        return mealLogRepository.findByDailyLoggedFood(dailyLoggedFood);
    }



    public List<MealLog> getMealLogsByMealType(String mealType) {
        return mealLogRepository.findByMealType(mealType);
    }

    public MealLog saveMealLog(MealLog mealLog) {
        return mealLogRepository.save(mealLog);
    }

    public void deleteMealLog(Long id) {
        mealLogRepository.deleteById(id);
    }

}
