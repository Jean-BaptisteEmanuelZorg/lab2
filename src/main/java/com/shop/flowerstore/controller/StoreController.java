package com.shop.flowerstore.controller;


import com.shop.flowerstore.model.*;
import com.shop.flowerstore.service.ItemManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    private final ItemManager manager;
    @Autowired
    public StoreController(ItemManager manager) {
        this.manager = manager;
    }

    @GetMapping("/flowers")
    public List<Item> getFlowers() {
        return manager.getItems();
    }

    @GetMapping("/flowers/{id}")
    public CustomResponseEntity<Item> getFlowerById(@PathVariable Integer id){
        return CustomResponseEntity.ok(manager.getItemById(id));
    }

    @PostMapping("/flowers/addFlower")
    public BouquetFlower addFlower(@RequestBody @Valid BouquetFlower flower){
        manager.addItem(flower);
        return flower;
    }

    @PutMapping("/flowers/{id}/changePrice")
    public Item changePrice(@PathVariable int id, @RequestBody @Valid int price){
        manager.getItemById(id).setPrice(price);
        return manager.getItemById(id);
    }

    @PutMapping("/flowers/{id}/changeDescription")
    public Item changeDescription(@PathVariable int id, @RequestBody @Valid String description){
        manager.getItemById(id).setDescription(description);
        return manager.getItemById(id);
    }

    @DeleteMapping("/flowers/{id}/delete")
    public void deleteFlower(@PathVariable int id){
        manager.removeItemById(id);
    }

    @GetMapping("/flowers/compileBouquet")
    public List<BouquetFlower> compileBouquet(@RequestBody BouquetConfiguration bouquetConfiguration) {
        return manager.compileBouquet(bouquetConfiguration, manager.getItems());
    }

    @PostMapping("/populate-data")
    public void addFlowers(){
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 55, "special", "blue"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.ROSE, 50, "great", "pink"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 155, "fine", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 155, "fine", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.TULIP, 155, "fine", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "white"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.DAISY, 44, "average", "red"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.IRIS, 62, "great", "purple"));
        manager.addItem(new BouquetFlower(BouquetFlowerType.PEONY, 70, "perfect", "pink"));
        manager.addItem(new HousePlant("plant", 55, "description", 5, true, HousePlantType.CITRUS));
        manager.addItem(new Pot("vase", 45, "some vase", 20, 40, 99, "glass"));
        manager.addItem(new Soil("dirt", 78, "some soil", 4.5, "1,2,3", 5, 5, SoilType.UNIVERSAL));
    }

}
