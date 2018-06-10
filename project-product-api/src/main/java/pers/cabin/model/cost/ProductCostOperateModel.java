package pers.cabin.model.cost;

/**
 * Created by caiping on 2017/12/19.
 */
public interface ProductCostOperateModel {


    /**
     * 获取运维成本
     * @param productId
     * @param startTM 开始时间
     * @param endTM    结束时间
     * @return
     */
    public  double getCostOperate(String productId, String startTM,String endTM);
}
