package com.example.MyProject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id", nullable = false)
    private Long feedbackId;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "confirmation_code", nullable = false)
    private String confirmationCode;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "comments")
    private String comments;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    public Feedback(String phone, String confirmationCode, Integer score, String comments, Long productId) {
        this.phone = phone;
        this.confirmationCode = confirmationCode;
        this.score = score;
        this.comments = comments;
        this.productId = productId;
    }
}