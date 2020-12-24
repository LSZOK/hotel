package com.ruoyi.project.system.domain;

import java.util.Map;

public class SingleSubscribeMessage {
    private String touser;
    private String template_id;
    private String page;
    private String miniprogram_state;

    private Map<String,SubscribeTemplateData> data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getMiniprogram_state() {
        return miniprogram_state;
    }

    public void setMiniprogram_state(String miniprogram_state) {
        this.miniprogram_state = miniprogram_state;
    }

    public Map<String, SubscribeTemplateData> getData() {
        return data;
    }

    public void setData(Map<String, SubscribeTemplateData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SingleSubscribeMessage{" +
                "touser='" + touser + '\'' +
                ", template_id='" + template_id + '\'' +
                ", page='" + page + '\'' +
                ", miniprogram_state='" + miniprogram_state + '\'' +
                ", data=" + data +
                '}';
    }
}
