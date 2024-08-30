package org.scoula.mapper;

import lombok.extern.log4j.Log4j;
import org.scoula.config.RootConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes ={RootConfig.class})
@Log4j
class TimeMapperTest {
@Autowired
    private TimeMapper timeMapper;

@Test
    @DisplayName("TimeMapper의 getTime()")
    public void getTime() {
    log.info(timeMapper.getClass().getName()); //TimeMapper의 실제 클래스 이름
    log.info(timeMapper.getTime()); //TimeMapper의 getTime() 메소드 호출
}
@Test
    @DisplayName("TimeMapper의 getTime2()")
    public void getTime2() {
    log.info("getTime2");
    log.info(timeMapper.getTime2());
}
}