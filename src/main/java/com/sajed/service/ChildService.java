package com.sajed.service;

import com.sajed.models.Child;
import com.sajed.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {

    @Autowired
    ChildRepository childRepository;

    public List<Child> findByIsDeletedFalse(){
        return childRepository.findByIsDeletedFalse();
    }

    public Child save( Child child){
        return childRepository.save( child );
    }
}
