package com.sajed.service;

import com.sajed.models.Adult;
import com.sajed.repository.AdultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdultService {
    @Autowired
    private AdultRepository adultRepository;

    public Adult findByAdultIdAndIsDeletedFalse(Integer adultId) {
        return adultRepository.findByAdultIdAndIsDeletedFalse( adultId );
    }

    public List<Adult> findByIsDeletedFalse() {
        return adultRepository.findByIsDeletedFalse();
    }

    public Adult save(Adult adult) {
        return adultRepository.save(adult);
    }
}
