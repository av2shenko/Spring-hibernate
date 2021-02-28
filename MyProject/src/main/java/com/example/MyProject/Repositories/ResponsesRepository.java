package com.example.MyProject.Repositories;

import com.example.MyProject.Models.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResponsesRepository extends JpaRepository<Response, Long>, JpaSpecificationExecutor<Response> {

}