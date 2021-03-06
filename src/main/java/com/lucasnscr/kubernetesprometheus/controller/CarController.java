package com.lucasnscr.kubernetesprometheus.controller;

import com.lucasnscr.kubernetesprometheus.model.Car;
import com.lucasnscr.kubernetesprometheus.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public ResponseEntity<Iterable<Car>> findAllCars(){
        return ResponseEntity.ok().body(carRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable("id") String id){
        return ResponseEntity.ok().body(carRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.CREATED);
    }

    @DeleteMapping
    public void deleteCar(@PathVariable("id") String id){carRepository.deleteById(UUID.fromString(id));}
}
