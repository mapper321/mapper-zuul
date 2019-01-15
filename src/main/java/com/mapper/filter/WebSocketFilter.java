package com.mapper.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class WebSocketFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String upgradeHeader = request.getHeader("Upgrade");
		if (null == upgradeHeader) {
			upgradeHeader = request.getHeader("upgrade");
		}
		if (null != upgradeHeader && "websocket".equalsIgnoreCase(upgradeHeader)) {
			context.addZuulRequestHeader("connection", "Upgrade");
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
