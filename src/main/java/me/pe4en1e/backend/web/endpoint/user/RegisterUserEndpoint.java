package me.pe4en1e.backend.web.endpoint.user;

import lombok.Data;
import me.pe4en1e.backend.data.entity.User;
import me.pe4en1e.backend.data.repository.UserRepository;
import me.pe4en1e.backend.web.schema.StatusSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @Data
    private static class Request {
        private String email;
        private String password;
    }

    @PostMapping("/api/user/register")
    public StatusSchema registerUser(@RequestBody Request request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return StatusSchema.builder()
                    .status("Error")
                    .message("Username already taken!")
                    .build();

        }

        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .build()
        );

        return StatusSchema.builder()
                .status("OK")
                .build();

    }

}
