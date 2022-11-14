package com.example.FoodApp.controller;

import com.example.FoodApp.model.MealItem;
import com.example.FoodApp.service.MealItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/meals")
@CrossOrigin(origins = {"http://localhost:3000"})
public class MealItemController {

    @Autowired
    MealItemService mealService;

    @PostMapping()
    public ResponseEntity<MealItem> create (@RequestBody MealItem meal){
        MealItem m = new MealItem();

        m.setName(meal.getName());
        m.setDescription(meal.getDescription());
        m.setPrice(meal.getPrice());
//        m.setOrder(meal.getOrder());

        m = mealService.save(m);

        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MealItem> getMeal(@PathVariable Long id){
        MealItem m = mealService.getMeal(id);
        if(m == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MealItem>> getMeals(Pageable page){
        Page<MealItem> meals = mealService.getAllMeals(page);
        List<MealItem> retValue = new ArrayList<>();
        for (MealItem m : meals) {
            retValue.add(new MealItem(m));
        }
        return  new ResponseEntity<>(retValue, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        MealItem meal = mealService.getMeal(id);
        if(meal == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw  new IllegalStateException("Meal doesn't exist");
        } else {
            mealService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping
    public  ResponseEntity<List<MealItem>> deleteAllMeals(Pageable page) {

        Page<MealItem> meals = mealService.getAllMeals(page);
        List<MealItem> retValue = new ArrayList<>();

        for (MealItem m:  meals ) {
            retValue.add(new MealItem(m));
        }

        mealService.removeAll(retValue);

        return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }
}
