package com.androjava.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.androjava.entity.UserQuestions;

public interface UserQuestionRepository extends JpaRepository<UserQuestions, Long> {

}
