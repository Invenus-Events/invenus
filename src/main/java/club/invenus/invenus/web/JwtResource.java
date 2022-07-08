package club.invenus.invenus.web;

import club.invenus.invenus.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtResource {

    private final JwtService jwtService;

    @Autowired
    public JwtResource(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/verify")
    public boolean verifyJwt(@RequestBody String jwt) {
        return jwtService.checkJwtToken(jwt);
    }

}
