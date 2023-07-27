package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.FeedbackUser;

public interface FeedbackRepo extends JpaRepository<FeedbackUser, Long>{

}