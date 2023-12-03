package com.allinone.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allinone.demo.data.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    // NO additional methods required by now
}

