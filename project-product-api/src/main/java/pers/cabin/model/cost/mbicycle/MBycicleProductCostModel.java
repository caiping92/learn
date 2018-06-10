package pers.cabin.model.cost.mbicycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pers.cabin.model.cost.*;

/**
 * Created by caiping on 2017/12/19.
 */
public class MBycicleProductCostModel implements ProductCostModel {

    /**
     * M单车 研发成本模型
     */
    @Autowired
    @Qualifier("mBycicleProductCostResearchModel")
    ProductCostResearchModel productCostResearchModel;

    /**
     * M单车制造成本模型
     */
    @Autowired
    @Qualifier("mBycicleProductCostMadModel")
    ProductCostMadModel productCostMadModel;

    /**
     * M单车销售成本模型
     */
    @Autowired
    @Qualifier("mBycicleProductCostSaleModel")
    ProductCostSaleModel productCostSaleModel;

    /**
     * M单车运维成本模型
     */
    @Autowired
    @Qualifier("mBycicleProductCostOperateModel")
    ProductCostOperateModel productCostOperateModel;

    @Override
    public Double getSingleProductCost(String productId, String startTM, String endTM) {

        //1.获取单个产品编号为ProductId的研发成本,如果为null 或者为0，则表示产品编号为ProductId 没有投入研发成本
        Double costResearch = productCostResearchModel.getCostResearch(productId, startTM, endTM);
        //2.获取单个产品编号为ProductId的制造成本，如果为null 或者为0，则表示产品编号为ProductId 没有此阶段的成本
        Double costMade = productCostMadModel.getCostMade(productId, startTM, endTM);
        //3.获取单个产品编号为ProductId的销售成本，如果为null 或者为0，则表示产品编号为ProductId 没有此阶段的成本
        Double costSale = productCostSaleModel.getCostSale(productId, startTM, endTM);
        //4.获取单个产品编号为ProductId的运维成本，如果为null 或者为0，则表示产品编号为ProductId 没有此阶段的成本
        Double costOperate = productCostOperateModel.getCostOperate(productId, startTM, endTM);

        double sum = 0;
        if (costResearch != null && costResearch != 0) {
            sum += costResearch;
        }
        if (costMade != null && costMade != 0) {
            sum += costMade;
        }
        if (costSale != null && costSale != 0) {
            sum += costSale;
        }
        if (costOperate != null && costOperate != 0) {
            sum += costOperate;
        }
        return sum;
    }
}
