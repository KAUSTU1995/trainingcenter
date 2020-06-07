package com.liv2train.controller;

import com.liv2train.model.TrainingCenter;
import com.liv2train.service.TrainingCenterService;
import com.liv2train.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TrainingCenterController {
    @Autowired
    private TrainingCenterService trainingCenterService;

    @RequestMapping("/" + Constants.TRAININGCENTER)
    public List<TrainingCenter> getAllTrainingCenter() {
        return trainingCenterService.getAllTrainingCenter();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/" + Constants.TRAININGCENTER)
    public TrainingCenter addCourse(@Valid @RequestBody TrainingCenter trainingCenter) {
        return trainingCenterService.addTrainingCenter(trainingCenter);
    }
}
