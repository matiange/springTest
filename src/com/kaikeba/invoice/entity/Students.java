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
