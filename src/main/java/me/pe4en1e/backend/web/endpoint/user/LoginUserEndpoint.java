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
public class LoginUserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @Data
    private static class Request {
        private String email;
        private String password;
    }

    @PostMapping("/api/user/login")
    public StatusSchema loginUser(@RequestBody Request request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return StatusSchema.builder()
                    .status("Error")
                    .message("User not found!")
                    .build();
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return StatusSchema.builder()
                    .status("Error")
                    .message("Password does not match!")
                    .build();
        }

        return StatusSchema.builder()
                .status("OK")
                .build();

    }

}
