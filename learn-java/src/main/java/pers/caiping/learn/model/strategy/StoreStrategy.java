package pers.caiping.learn.model.strategy;

import pers.caiping.learn.model.strategy.dto.DataParam;
import pers.caiping.learn.result.CommonReslut;
import pers.caiping.learn.result.StoreResult;

public interface StoreStrategy {
    StoreResult store(DataParam dataParam);
}
