package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration : 설정
@Configuration
@ComponentScan(basePackages = {"org.scoula.controller"})
public class RootConfig {
}
