package com.liv2train.controller;

import com.liv2train.model.TrainingCenter;
import com.liv2train.service.TrainingCenterService;
import com.liv2train.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class TrainingCenterController {
    @Autowired
    private TrainingCenterService trainingCenterService;

    @RequestMapping(method = RequestMethod.GET, value = "/" + Constants.TRAININGCENTER)
    public List<TrainingCenter> getAllTrainingCenter() {
        return trainingCenterService.getAllTrainingCenter();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/" + Constants.TRAININGCENTER)
    public TrainingCenter addTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        return trainingCenterService.addTrainingCenter(trainingCenter);
    }
}
