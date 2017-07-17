package io.jjenksi.john.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Created by johnjenkins on 7/17/17.
 * This is a zuul filter that adds a request header to all the api paths
 */
public class AddRequestHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";//return a pre filter see README for details
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;//set to true so it always filters
    }

    @Override
    public Object run() {
        //this adds a location to all the services
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("x-location","USA");
        return null;
    }
}
