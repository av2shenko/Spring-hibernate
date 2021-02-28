package com.example.MyProject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id", nullable = false)
    private Long responseId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    public Response(String name, String description, Long questionId) {
        this.name = name;
        this.description = description;
        this.questionId = questionId;
    }
}
