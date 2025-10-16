package com.Arc.FitnessApp.controller;


import com.Arc.FitnessApp.models.DailyLoggedFood;
import com.Arc.FitnessApp.models.Users;
import com.Arc.FitnessApp.services.DailyLoggedFoodService;
import com.Arc.FitnessApp.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/daily-logs")
public class DailyLoggedFoodsController {

    private final DailyLoggedFoodService dailyLoggedFoodService;
    private final UsersService usersService;

    public DailyLoggedFoodsController(DailyLoggedFoodService dailyLoggedFoodService, UsersService usersService) {
        this.dailyLoggedFoodService = dailyLoggedFoodService;
        this.usersService = usersService;
    }


    @GetMapping
    public List<DailyLoggedFood> getAllLogs() {
        return dailyLoggedFoodService.getAllDailyLogs();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<DailyLoggedFood>> getLogsByUser(@PathVariable String username) {
        Users user = usersService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<DailyLoggedFood> logs = dailyLoggedFoodService.getLogsByUser(user);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/user/{username}/date/{date}")
    public ResponseEntity<DailyLoggedFood> getLogsByUserAndDate(@PathVariable String username, @PathVariable String date) {
        Users user = usersService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        LocalDate logDate = LocalDate.parse(date);
        Optional<DailyLoggedFood> log =dailyLoggedFoodService.getLogByUserAndDate(user, logDate);
        return log.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("user/{username}")
    public ResponseEntity<DailyLoggedFood> createDailyLog(@PathVariable String username, @RequestBody DailyLoggedFood dailyLoggedFood) {

        Users user = usersService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        dailyLoggedFood.setUser(user);
        DailyLoggedFood savedLog = dailyLoggedFoodService.saveLog(dailyLoggedFood);
        return ResponseEntity.ok(savedLog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDailyLog(@PathVariable Long id) {
        dailyLoggedFoodService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }



}
