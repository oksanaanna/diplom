package com.example.demo.repositories;

import com.example.demo.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
