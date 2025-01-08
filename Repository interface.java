// src/main/java/com/fitness/tracker/repository/ActivityRepository.java
package com.fitness.tracker.repository;

import com.fitness.tracker.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
