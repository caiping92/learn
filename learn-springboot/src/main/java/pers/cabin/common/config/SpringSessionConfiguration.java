package pers.cabin.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(prefix = "cabin", name = "spring-session-open", havingValue = "true")
public class SpringSessionConfiguration {

}
