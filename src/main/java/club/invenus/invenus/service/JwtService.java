package club.invenus.invenus.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Service
public class JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier verifier;

    public JwtService(@Value("${jwt.secret}") String secret) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algorithm).build();
    }

    public String createJwt(@NotNull Map<String, Object> content) {
        return JWT.create()
                .withPayload(content)
                .sign(algorithm);
    }

    public boolean checkJwtToken(@NotNull String jwt) {
        try {
            verifier.verify(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
