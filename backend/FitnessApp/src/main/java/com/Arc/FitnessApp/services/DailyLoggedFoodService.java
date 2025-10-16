package com.Arc.FitnessApp.services;

import com.Arc.FitnessApp.models.DailyLoggedFood;
import com.Arc.FitnessApp.models.Users;
import com.Arc.FitnessApp.repositories.DailyLoggedFoodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DailyLoggedFoodService {

    private final DailyLoggedFoodRepository dailyLoggedFoodRepository;

    public DailyLoggedFoodService (DailyLoggedFoodRepository dailyLoggedFoodRepository) {
        this.dailyLoggedFoodRepository = dailyLoggedFoodRepository;
    }

    public List<DailyLoggedFood> getAllDailyLogs() {
        return dailyLoggedFoodRepository.findAll();
    }

    public List<DailyLoggedFood> getLogsByUser(Users user) {
        return dailyLoggedFoodRepository.findByUser(user);
    }

    public Optional <DailyLoggedFood> getLogByUserAndDate(Users user, LocalDate date){
        return dailyLoggedFoodRepository.findByUserAndLogDate(user, date);
    }

    public DailyLoggedFood saveLog(DailyLoggedFood log) {
        return dailyLoggedFoodRepository.save(log);
    }

    public void deleteLog(Long id) {
        dailyLoggedFoodRepository.deleteById(id);
    }

}
