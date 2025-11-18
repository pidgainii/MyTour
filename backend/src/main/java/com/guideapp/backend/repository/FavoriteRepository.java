package com.guideapp.backend.repository;

import com.guideapp.backend.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {
    List<Favorite> findByUserId(UUID userId);

    @Query("SELECT f FROM Favorite f JOIN FETCH f.tour WHERE f.user.id = :userId")
    List<Favorite> findByUserIdWithTour(@Param("userId") UUID userId);
}
