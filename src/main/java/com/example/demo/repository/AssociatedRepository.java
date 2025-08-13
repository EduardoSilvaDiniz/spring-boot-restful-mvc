package com.example.demo.repository;

import com.example.demo.model.Associated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociatedRepository extends JpaRepository<Associated, Long> {}
