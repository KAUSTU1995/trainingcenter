package com.liv2train.service;

import com.liv2train.model.TrainingCenter;
import com.liv2train.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public List<TrainingCenter> getAllTrainingCenter() {
        List<TrainingCenter> centers = new ArrayList<>();
        trainingCenterRepository.findAll().forEach(centers::add);
        return centers;
    }

    public TrainingCenter addTrainingCenter(TrainingCenter trainingCenter) {
        trainingCenter.setUuid();
        trainingCenter.setCreatedOn();
        trainingCenterRepository.save(trainingCenter);
        return trainingCenterRepository.findById(trainingCenter.getUuid()).get();
    }
}
