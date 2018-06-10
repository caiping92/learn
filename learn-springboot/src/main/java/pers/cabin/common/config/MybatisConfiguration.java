package pers.cabin.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by caiping on 2017/9/21.
 */
@Configuration
@MapperScan("pers.cabin.*.dao")
public class MybatisConfiguration {
}
