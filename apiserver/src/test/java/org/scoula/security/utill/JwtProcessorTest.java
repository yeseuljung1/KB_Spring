package org.scoula.security.utill;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class, SecurityConfig.class })
@Log4j
class JwtProcessorTest {
    @Autowired
    JwtProcessor jwtProcessor;
    @Test
    void generateToken() {
        String username = "user0";
        String token = jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }
    @Test
    void getUsername() {
        String token =
                " eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDIyNDkxOSwiZXhwIjoxNzI0MjI1MjE5fQ.fCjPjvEo9uuTEy1h9V9Wly11pbNjOofoXV2NtIsbonLeo20hl4dCvuq_h1alXSXCo7kVGrYoIRLNLEFFdYIoVA";
        String username = jwtProcessor.getUsername(token);
        log.info(username);
        assertNotNull(username);
    }
    @Test
    void validateToken() {
// 5분 경과 후 테스트
        String token =
                " eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTcyNDIyNDkxOSwiZXhwIjoxNzI0MjI1MjE5fQ.fCjPjvEo9uuTEy1h9V9Wly11pbNjOofoXV2NtIsbonLeo20hl4dCvuq_h1alXSXCo7kVGrYoIRLNLEFFdYIoVA";
        boolean isValid = jwtProcessor.validateToken(token); // 5분 경과 후면 예외 발생
        log.info(isValid);
        assertTrue(isValid); // 5분전이면 true
    }
}
