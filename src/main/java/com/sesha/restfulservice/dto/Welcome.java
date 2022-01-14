package com.sesha.restfulservice.dto;

public class Welcome {
    private final long id;
    private final String text;
    private final String appName;

    public Welcome(long id, String text, String appName) {
        this.id = id;
        this.text = text;
        this.appName = appName;
    }

    public long getId() { return this.id; }

    public String getText() { return text; }

    public String getAppName() {
        return appName;
    }
}
