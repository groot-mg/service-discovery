package com.generoso.ft.sd.client;

import com.generoso.ft.sd.client.model.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("serviceRequest")
public class GetAppsRequestTemplate extends RequestTemplate {

    @Autowired
    public GetAppsRequestTemplate(@Value("${service.host}") String host,
                                  @Value("${service.context-path:}") String contextPath) {
        super(host, contextPath);
    }

    @Override
    public Endpoint getEndpoint() {
        return Endpoint.GET_APPS;
    }


}
