package com.lucasnscr.kubernetesprometheus.repository;

import com.lucasnscr.kubernetesprometheus.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
