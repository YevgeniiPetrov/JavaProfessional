package com.itvdn.javaProfessional.petrov.lesson012.homeWork.task001;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class Currency {
    @JsonProperty("cc")
    private String title;
    @JsonProperty("r030")
    private String code;
    private BigDecimal rate;
    @JsonProperty("exchangedate")
    @JsonFormat(pattern="dd.MM.yyyy")
    private Date exchangeDate;
    @JsonProperty("txt")
    private String description;

    public Currency() {
    }

    public Currency(String title, String code, BigDecimal rate, Date exchangeDate, String description) {
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.exchangeDate = exchangeDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", exchangeDate=" + exchangeDate +
                ", description='" + description + '\'' +
                '}';
    }
}
