package pers.cabin.java.design.dm31_InterceptingFilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiping on 2017/3/3.
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}
