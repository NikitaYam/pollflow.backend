package me.pe4en1e.backend.data.repository;

import me.pe4en1e.backend.data.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findById(long id);

}
