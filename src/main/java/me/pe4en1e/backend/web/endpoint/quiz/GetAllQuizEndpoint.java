package me.pe4en1e.backend.web.endpoint.quiz;

import me.pe4en1e.backend.data.entity.Quiz;
import me.pe4en1e.backend.data.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class GetAllQuizEndpoint {

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/api/getAllQuiz")
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

}
