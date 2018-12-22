package pers.cabin.java.design.dm31_InterceptingFilterPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class Client {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }
}
