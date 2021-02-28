package com.example.MyProject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    public Question(String name, String email, String description, Long productId) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.productId = productId;
    }
}
