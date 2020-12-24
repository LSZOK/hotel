package com.ruoyi.project.system.domain;

import java.io.Serializable;

public class SubscribeTemplateData  {
    private  String value;

    public SubscribeTemplateData(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
