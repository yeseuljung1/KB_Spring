package org.scoula;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
//Spring Context를 가져올 설정 클래스 지정
@ContextConfiguration(classes = {RootConfig.class})
@Log4j //log4j.xml을 사용해서 log 기능 가져오기


class RestaurantTest {

    @Autowired
    private Restaurant restaurant;

    @Test
    void getChef() {
//        restaurant객체가 null이 아님을 확인하는 메소드
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("------------------------------");
        log.info(restaurant.getChef());

    }
}
