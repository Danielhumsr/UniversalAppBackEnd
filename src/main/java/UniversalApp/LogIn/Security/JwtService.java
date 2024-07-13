package UniversalApp.LogIn.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {
    private static final String SECRET_KEY = "UnaClaveSirveParaMantenerLosDatosSegurosDelMal";

    public String getToken(UserDetails userDetails) {
        return getToken(new HashMap<>(), userDetails);
    }

    private String getToken(HashMap<String, Object> extraclaims, UserDetails user) {
        return Jwts.builder()
                .setClaims(extraclaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*3))
                .signWith(getkey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getkey() {
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
