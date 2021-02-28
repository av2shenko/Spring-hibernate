package com.example.MyProject.Repositories;

import com.example.MyProject.Models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FeedbacksRepository extends JpaRepository<Feedback, Long>, JpaSpecificationExecutor<Feedback> {

}