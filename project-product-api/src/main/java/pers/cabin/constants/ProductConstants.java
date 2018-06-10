package pers.cabin.constants;

/**
 * Created by caiping on 2017/12/19.
 */
public class ProductConstants {

    /**
     * 产品生命周期阶段
     */
    public   enum  PLMType{

        R(1,"研究阶段"),
        M(1,"制造阶段"),
        S(1,"销售阶段"),
        O(4,"运维阶段");

        private Integer type;
        private String description;

        PLMType(Integer type, String description) {
            this.type = type;
            this.description = description;
        }
    }


}
