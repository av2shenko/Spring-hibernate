package com.example.MyProject.Controllers;

import com.example.MyProject.Models.Response;
import com.example.MyProject.Repositories.ResponsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponsesRepository responsesRepository;

    @PostMapping
    public String ResponseCreate(@RequestParam String name, String description, Long questionId) {
        responsesRepository.save(new Response(name, description, questionId));
        return "saved ";
    }

    @GetMapping
    public List<Response> ResponseRead() {
        return (List<Response>) responsesRepository.findAll();
    }

    @PutMapping("/{id}")
    public String ResponseUpdate(@PathVariable(value = "id") Long id, @RequestParam String name, String description, Long questionId) {
        Response responseObject = responsesRepository.findById(id).orElseThrow();
        responseObject.setName(name);
        responseObject.setDescription(description);
        responseObject.setQuestionId(questionId);
        responsesRepository.save(responseObject);
        return " updated: " + responsesRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String ResponseDelete(@PathVariable(value = "id") Long id) {
        Response responseObject = responsesRepository.findById(id).orElseThrow();
        responsesRepository.delete(responseObject);
        return "deleted id: " + id;
    }

    @GetMapping("/{id}")
    public Response ResponseGetId(@PathVariable(value = "id") Long id) {
        Response responseObject = responsesRepository.findById(id).orElseThrow();
        return responseObject;
    }

}