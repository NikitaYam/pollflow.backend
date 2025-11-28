package me.pe4en1e.backend.web.endpoint.quiz;

import lombok.Data;
import me.pe4en1e.backend.data.entity.Quiz;
import me.pe4en1e.backend.data.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class GetQuizByIdEndpoint {

    @Autowired
    private QuizRepository quizRepository;

    @Data
    private static class RequestDto {
        private long quizId;
    }

    @PostMapping("/api/getQuizById")
    public Quiz getQuizById(@RequestBody RequestDto request) {
        return quizRepository.findById(request.quizId);
    }

}
