// src/main/java/com/fitness/tracker/service/ActivityService.java
package com.fitness.tracker.service;

import com.fitness.tracker.model.Activity;
import com.fitness.tracker.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}
