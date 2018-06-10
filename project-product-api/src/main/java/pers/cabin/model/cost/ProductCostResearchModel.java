package pers.cabin.model.cost;

/**
 * Created by caiping on 2017/12/19.
 */
public interface ProductCostResearchModel {
    /**
     * 获取单个产品总研发成本
     *
     * @Param productId     产品编号
     * @return
     */
    public  double getCostResearch(String productId,String startTM,String endTM);

    /**
     * 获取产品总的研发成本
     * * @Param productId     产品编号
     */
    public  double getCostReseaerchTotal(String productId,String startTM,String endTM);

    /**
     * 获取间间接成本
     * @param productId
     * @return
     */
    public  double getCostResearchDirect(String productId,String startTM,String endTM);

    /**
     * 获取研发成本直接成本
     * @param productId
     * @return
     */
    public  double getCostResearchInDirect(String productId,String startTM,String endTM);
}
