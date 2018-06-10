package pers.caiping.learn.model.strategy;

import lombok.extern.log4j.Log4j;
import pers.caiping.learn.model.strategy.dto.DataParam;
import pers.caiping.learn.result.StoreResult;

@Log4j
public class MybatisStore implements StoreStrategy {
    @Override
    public StoreResult store(DataParam dataParam) {
        log.info("正在向 Mybatis 中存储数据……");

        return null;
    }
}
