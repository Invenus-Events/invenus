package club.invenus.invenus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String base() {
        return "Invenus/0.0.1";
    }

}
