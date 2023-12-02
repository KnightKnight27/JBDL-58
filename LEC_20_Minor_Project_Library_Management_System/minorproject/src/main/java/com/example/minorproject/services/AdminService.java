package com.example.minorproject.services;

import com.example.minorproject.models.Admin;
import com.example.minorproject.models.Student;
import com.example.minorproject.repositories.AdminRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRespository adminRespository;

    public Admin find(Integer id){
        Optional<Admin> admin = adminRespository.findById(id);
        if(admin.isPresent()){
            return admin.get();
        }
        // THROW SOME EXCEPTIONS
        return null;
    }
}
