package com.ruoyi.framework.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myimg/**").addResourceLocations("file:E:/IdeaProjects/my-server-save-img/");
        //addResoureHandler：指的是对外暴露的访问路径。addResourceLocations：指的是内部文件放置的目录。设置后，在浏览器窗口输入http://localhost:8008/myimg/文件名，就可以访问到本地地址为E:/IdeaProjects/my-server-save-img/文件名 的文件了。
        super.addResourceHandlers(registry);
    }
}
