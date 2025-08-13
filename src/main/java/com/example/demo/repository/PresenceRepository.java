package com.example.demo.repository;

import com.example.demo.model.Presence;
import com.example.demo.model.PresenceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenceRepository extends JpaRepository<Presence, PresenceId> {}
