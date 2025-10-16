package me.pe4en1e.backend.web.endpoint;

import me.pe4en1e.backend.web.schema.StatusSchema;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RootEndpoint {

    public StatusSchema root() {
        return StatusSchema.builder()
                .status("OK")
                .build();
    }

}
