package pers.cabin.model.cost;

/**
 * Created by caiping on 2017/12/19.
 */
public interface ProductCostMadModel {


    /**
     * 获取产品生命周期中的总成本
     * @param productId
     * @return
     */
    public  float getProcutCountAtPLM(String productId,String startTM,String endTM);

    /**
     * 获取产品的制造总成本
     * @param productId
     * @return
     */
    public  double getCostMade(String productId,String startTM,String endTM);

    /**
     * 获取产品制造 批量为N时的制造成本
     * @param n  批量
     * @param productId 产品编号
     * @return
     */
    public  double getCostMadeN(String productId,float n,String startTM,String endTM);

    /**
     * 获取产品的购买成本
     * @param startTM   购买时间
     * @param productId 产品编号
     * @return
     */
    public  double getCostMadeBuyParts(String productId,String startTM,String endTM);

}
