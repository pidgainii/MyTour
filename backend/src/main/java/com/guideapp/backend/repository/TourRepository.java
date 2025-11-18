package com.guideapp.backend.repository;

import com.guideapp.backend.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TourRepository extends JpaRepository<Tour, UUID> {
    List<Tour> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String query1, String query2);
    List<Tour> findByGuideId(UUID id);

}
