package com.cnsdhh.ssmmaven.pojo;

import java.util.Date;

public class Log {
    private Integer id;
    private String username;
    private Date time;
    private String url;
    private long cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", url='" + url + '\'' +
                ", cost=" + cost +
                '}';
    }
}
