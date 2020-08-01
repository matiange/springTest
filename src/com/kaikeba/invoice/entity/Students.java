package com.kaikeba.invoice.entity;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/18 11:38
 */
public class Students {
    private String num;
    private String name;
    private Double sum;
    private String sexy;
    private String mobilePhoneNum;
    private String bankNum;

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getMobilePhoneNum() {
        return mobilePhoneNum;
    }

    public void setMobilePhoneNum(String mobilePhoneNum) {
        this.mobilePhoneNum = mobilePhoneNum;
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Students{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
