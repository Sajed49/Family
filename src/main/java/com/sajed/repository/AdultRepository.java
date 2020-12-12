package com.sajed.repository;

import com.sajed.models.Adult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdultRepository extends JpaRepository<Adult, Long> {

    List<Adult> findByIsDeletedFalse();

    Adult findByAdultIdAndIsDeletedFalse(Integer adultId);
}
