package com.liv2train.repository;

import com.liv2train.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, UUID> {
}
