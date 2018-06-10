package pers.caiping.learn.model.strategy;

import pers.caiping.learn.model.strategy.dto.DataParam;
import pers.caiping.learn.result.StoreResult;

/**
 * 存储r入口
 */
public class StoreConext {

    private StoreStrategy storeStrategy;

    public StoreConext(StoreStrategy storeStrategy) {
        this.storeStrategy = storeStrategy;
    }

    public StoreResult store(DataParam dataParam) {
        return storeStrategy.store(dataParam);
    }
}
