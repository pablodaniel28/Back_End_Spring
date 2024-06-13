package com.phegondev.usersmanagementsystem.repository;

import com.phegondev.usersmanagementsystem.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<OurUsers, Integer> {
}
