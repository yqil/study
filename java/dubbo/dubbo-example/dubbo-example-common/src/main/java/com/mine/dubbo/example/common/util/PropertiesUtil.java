package com.mine.dubbo.example.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("properties")
public class PropertiesUtil
{

    @Value("${config.url}")
    private String url;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
