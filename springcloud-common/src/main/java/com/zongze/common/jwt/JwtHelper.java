package com.zongze.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.*;


public class JwtHelper {

    private static final String BASE64SECRET = Base64Utils.encodeToString("jwt-token".getBytes());


    public static String generateJWT(Map<String, String> params) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();
        map.put("typ", "JWT");
        map.put("alg", "HS256");
        //签发时间
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Date expireDate = calendar.getTime();

        //构建jwt
        JWTCreator.Builder builder = JWT.create().withHeader(map);
        if (params.size() > 0) {
            Set<Map.Entry<String, String>> entries = params.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                builder.withClaim(entry.getKey(), entry.getValue());
            }
        }
        return builder.withIssuedAt(date).withExpiresAt(expireDate).sign(Algorithm.HMAC256(BASE64SECRET));
    }

    public static Map<String, Claim> parseJWT(String jwt) throws UnsupportedEncodingException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(BASE64SECRET)).build();
        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = jwtVerifier.verify(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("jwt token过期");
        }
        return decodedJWT.getClaims();
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<>();
        params.put("name", "toms");
        params.put("age", "18");
        String jwtToken = generateJWT(params);
        System.out.println(jwtToken);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String, Claim> stringClaimMap = parseJWT(jwtToken);
        stringClaimMap.keySet().stream().forEach(key -> {
            System.out.println(key + "=" + stringClaimMap.get(key).asString());
        });


    }


}
