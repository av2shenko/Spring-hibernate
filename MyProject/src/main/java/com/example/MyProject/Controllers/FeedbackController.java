package com.example.MyProject.Controllers;

import com.example.MyProject.Models.Feedback;
import com.example.MyProject.Repositories.FeedbacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbacksRepository feedbacksRepository;

    @PostMapping
    public String FeedbackCreate(@RequestParam String phone, String confirmationCode, Integer score,  String comments, Long productId) {
        feedbacksRepository.save(new Feedback(phone, confirmationCode, score, comments, productId));
        return "saved ";
    }

    @GetMapping
    public List<Feedback> FeedbackRead() {
        return (List<Feedback>) feedbacksRepository.findAll();
    }

    @PutMapping("/{id}")
    public String FeedbackUpdate(@PathVariable(value = "id") Long id, @RequestParam String phone, String confirmationCode, Integer score, String comments, Long productId) {
        Feedback feedbackObject = feedbacksRepository.findById(id).orElseThrow();
        feedbackObject.setPhone(phone);
        feedbackObject.setConfirmationCode(confirmationCode);
        feedbackObject.setScore(score);
        feedbackObject.setComments(comments);
        feedbackObject.setProductId(productId);
        feedbacksRepository.save(feedbackObject);
        return "updated: " + feedbacksRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String FeedbackDelete(@PathVariable(value = "id") Long id) {
        Feedback feedbackObject = feedbacksRepository.findById(id).orElseThrow();
        feedbacksRepository.delete(feedbackObject);
        return "deleted id: " + id;
    }

    @GetMapping("/{id}")
    public Feedback FeedbackGetId(@PathVariable(value = "id") Long id) {
        Feedback feedbackObject = feedbacksRepository.findById(id).orElseThrow();
        return feedbackObject;
    }

}