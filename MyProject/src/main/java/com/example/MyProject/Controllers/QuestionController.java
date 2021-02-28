package com.example.MyProject.Controllers;

import com.example.MyProject.Models.Question;
import com.example.MyProject.Repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionsRepository questionsRepository;

    @PostMapping
    public String QuestionCreate(@RequestParam(name = "name", defaultValue = "anonymous") String name,
                                 @RequestParam(name = "email", defaultValue = "anonymous") String email,
                                 @RequestParam String description, Long productId) {
        questionsRepository.save(new Question(name, email, description, productId));
        return "saved ";
    }

    @GetMapping
    public List<Question> CategoryRead() {
        return (List<Question>) questionsRepository.findAll();
    }

    @PutMapping("/{id}")
    public String QuestionUpdate(@PathVariable(value = "id") Long id,
                                 @RequestParam(name = "name", defaultValue = "anonymous") String name,
                                 @RequestParam(name = "email", defaultValue = "anonymous") String email,
                                 @RequestParam String description, Long productId) {
        Question questionObject = questionsRepository.findById(id).orElseThrow();
        questionObject.setName(name);
        questionObject.setEmail(email);
        questionObject.setDescription(description);
        questionObject.setProductId(productId);
        questionsRepository.save(questionObject);
        return "updated: " + questionsRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String QuestionDelete(@PathVariable(value = "id") Long id) {
        Question questionObject = questionsRepository.findById(id).orElseThrow();
        questionsRepository.delete(questionObject);
        return "deleted id: " + id;
    }

    @GetMapping("/{id}")
    public Question QuestionGetId(@PathVariable(value = "id") Long id) {
        Question questionObject = questionsRepository.findById(id).orElseThrow();
        return questionObject;
    }

}