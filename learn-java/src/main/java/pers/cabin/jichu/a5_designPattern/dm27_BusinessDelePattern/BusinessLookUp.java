package pers.cabin.jichu.a5_designPattern.dm27_BusinessDelePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
