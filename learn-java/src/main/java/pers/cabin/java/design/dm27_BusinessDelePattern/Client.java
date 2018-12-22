package pers.cabin.java.design.dm27_BusinessDelePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    public void doTask() {
        businessService.doTask();
    }
}
