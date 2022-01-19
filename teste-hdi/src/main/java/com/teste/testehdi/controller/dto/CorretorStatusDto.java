package com.teste.testehdi.controller.dto;

import java.util.Objects;

public class CorretorStatusDto {

    
    private boolean active;
    private String code;
    private Double commissionRate;
    private String name;
    private String document;
    private String createDate;

    public CorretorStatusDto() {
    }

    public CorretorStatusDto(boolean active, String code, Double commissionRate, String name, String document,
                             String createDate) {
        this.active = active;
        this.code = code;
        this.commissionRate = commissionRate;
        this.name = name;
        this.document = document;
        this.createDate = createDate;
    }


    @Override
    public int hashCode() {
        return Objects.hash(active, code, commissionRate, createDate, document, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CorretorStatusDto other = (CorretorStatusDto) obj;
        return active == other.active && Objects.equals(code, other.code)
                && Objects.equals(commissionRate, other.commissionRate) && Objects.equals(createDate, other.createDate)
                && Objects.equals(document, other.document) && Objects.equals(name, other.name);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}
