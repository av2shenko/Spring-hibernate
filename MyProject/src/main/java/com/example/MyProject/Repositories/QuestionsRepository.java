package com.example.MyProject.Repositories;

import com.example.MyProject.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface QuestionsRepository extends JpaRepository<Question, Long>, JpaSpecificationExecutor<Question> {

}