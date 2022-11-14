package com.example.FoodApp.service;

import com.example.FoodApp.model.MealItem;
import com.example.FoodApp.repository.MealItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealItemService {

    @Autowired
    MealItemRepository mealRepository;

    public MealItem save(MealItem m) {
        return mealRepository.save(m);
    }

    public MealItem getMeal(Long id) {
        return mealRepository.findById(id).get();
    }

    public Page<MealItem> getAllMeals(Pageable page) {
        return mealRepository.findAll(page);
    }

    public void remove(Long id) {
        mealRepository.deleteById(id);
    }


    public void removeAll(List<MealItem> retValue) {
        mealRepository.deleteAll();
    }
}
