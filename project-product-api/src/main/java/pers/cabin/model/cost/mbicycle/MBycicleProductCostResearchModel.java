package pers.cabin.model.cost.mbicycle;

import pers.cabin.model.cost.ProductCostResearchModel;

/**
 * Created by caiping on 2017/12/19.
 */
public class MBycicleProductCostResearchModel implements ProductCostResearchModel{
    @Override
    public double getCostResearch(String productId, String startTM, String endTM) {
        return 0;
    }

    @Override
    public double getCostReseaerchTotal(String productId, String startTM, String endTM) {
        return 0;
    }

    @Override
    public double getCostResearchDirect(String productId, String startTM, String endTM) {
        return 0;
    }

    @Override
    public double getCostResearchInDirect(String productId, String startTM, String endTM) {
        return 0;
    }
}
