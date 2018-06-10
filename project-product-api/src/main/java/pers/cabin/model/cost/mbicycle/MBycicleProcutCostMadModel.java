package pers.cabin.model.cost.mbicycle;

import pers.cabin.model.cost.ProductCostMadModel;

/**
 * Created by caiping on 2017/12/19.
 */
public class MBycicleProcutCostMadModel implements ProductCostMadModel {
    @Override
    public float getProcutCountAtPLM(String productId, String startTM, String endTM) {
        return 0;
    }

    @Override
    public double getCostMade(String productId, String startTM, String endTM) {
        return 0;
    }

    @Override
    public double getCostMadeN(String productId, float n, String startTM, String endTM) {
        return 0;
    }

    @Override
    public double getCostMadeBuyParts(String productId, String startTM, String endTM) {
        return 0;
    }
}
