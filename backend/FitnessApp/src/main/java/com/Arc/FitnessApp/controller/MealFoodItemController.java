package com.Arc.FitnessApp.controller;

import com.Arc.FitnessApp.models.MealFoodItem;
import com.Arc.FitnessApp.models.MealLog;
import com.Arc.FitnessApp.services.MealFoodItemService;
import com.Arc.FitnessApp.services.MealLogService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/meal-food-items")
public class MealFoodItemController {

    private final MealFoodItemService mealFoodItemService;
    private final MealLogService mealLogService;

    public MealFoodItemController(MealFoodItemService mealFoodItemService, MealLogService mealLogService) {
        this.mealFoodItemService = mealFoodItemService;
        this.mealLogService = mealLogService;
    }

    // GET ALL MEAL FOOD ITEMS
    @GetMapping
    public List<MealFoodItem> getAllMealFoodItems() {
        return mealFoodItemService.getAllMealFoodItems();
    }

    // GET MEAL FOOD ITEM BY ID
    @GetMapping("/{id}")
    public ResponseEntity<MealFoodItem> getMealFoodItemById(@PathVariable Long id) {
        Optional<MealFoodItem> mealFoodItem = mealFoodItemService.getMealFoodItemById(id);
        return mealFoodItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //GET BY MEAL-LOG ID
    @GetMapping("/meal-log/{mealLogId}")
    public ResponseEntity<List<MealFoodItem>> getMealFoodItemsByMealLogId(@PathVariable Long mealLogId){
        Optional<MealLog>  mealLog = mealLogService.getMealLogById(mealLogId);
        if (mealLog.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List <MealFoodItem> mealFoodItems = mealFoodItemService.getMealFoodItemsByMealLogId(mealLog.get().getId());
        return ResponseEntity.ok(mealFoodItems);

    }


    // POST Method
    @PostMapping("/meal-log/{mealLogId}")
    public ResponseEntity<MealFoodItem> createMealFoodItem(@PathVariable Long mealLogId,
                                                           @RequestBody MealFoodItem mealFoodItem){
        Optional<MealLog> mealLog = mealLogService.getMealLogById(mealLogId);
        if (mealLog.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        mealFoodItem.setMealLog(mealLog.get());

        MealFoodItem savedItem = mealFoodItemService.saveMealFoodItem(mealFoodItem);
        return ResponseEntity.ok(savedItem);
    }

    //Update Method
    @PutMapping("/{id}")
    public ResponseEntity<MealFoodItem> updateMealFoodItem(@PathVariable Long id, @RequestBody MealFoodItem updatedItem){
        Optional<MealFoodItem> existingItem = mealFoodItemService.getMealFoodItemById(id);
        if (existingItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        MealFoodItem mealFoodItem = existingItem.get();
        mealFoodItem.setServings(updatedItem.getServings());

        if (updatedItem.getFoodItem() != null){
            mealFoodItem.setFoodItem(updatedItem.getFoodItem());
        }

        MealFoodItem savedItem = mealFoodItemService.saveMealFoodItem(mealFoodItem);
        return ResponseEntity.ok(savedItem);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMealFoodItem(@PathVariable Long id){
        Optional <MealFoodItem> existingMealFoodItem = mealFoodItemService.getMealFoodItemById(id);
        if (existingMealFoodItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        mealFoodItemService.deleteMealFoodItem(id);
        return ResponseEntity.noContent().build();
    }


}
