package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.EntryData;

@Repository
public interface EntryRepo extends JpaRepository<EntryData, String>{

}
