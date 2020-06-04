package com.example.demo.entity;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Show {
    private Integer showId;
    private String showName;
    private String showType;
    private String showSite;
    private String showTime;
    private String showIntroduction;
    private Integer total;
    private Integer forSell;
    private Integer price;
    private String imgUrl;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getShowSite() {
        return showSite;
    }

    public void setShowSite(String showSite) {
        this.showSite = showSite;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getShowIntroduction() {
        return showIntroduction;
    }

    public void setShowIntroduction(String showIntroduction) {
        this.showIntroduction = showIntroduction;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getForSell() {
        return forSell;
    }

    public void setForSell(Integer forSell) {
        this.forSell = forSell;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
