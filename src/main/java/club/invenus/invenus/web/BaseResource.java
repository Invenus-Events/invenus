package club.invenus.invenus.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseResource {

    @GetMapping("/")
    public String base() {
        return "Invenus/0.0.1";
    }

}
