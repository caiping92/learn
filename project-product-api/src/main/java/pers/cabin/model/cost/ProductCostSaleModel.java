package pers.cabin.model.cost;

/**
 * Created by caiping on 2017/12/19.
 */
public interface ProductCostSaleModel {

    /**
     * 销售某种产品的成本
     * @param productId
     * @param startTM
     * @param endTM
     * @return
     */
    public  double getCostSale(String productId, String startTM,String endTM);
}
