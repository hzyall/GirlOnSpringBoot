package com.hzy.girl.model;

import java.math.BigDecimal;

public class GiftModel extends BaseModel{

    private String giftName;

    private BigDecimal giftValue;

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public BigDecimal getGiftValue() {
        return giftValue;
    }

    public void setGiftValue(BigDecimal giftValue) {
        this.giftValue = giftValue;
    }

    @Override
    public String toString() {

        return "GiftModel{" +
                "giftName='" + giftName + '\'' +
                ", giftValue=" + giftValue +
                '}' + super.toString();
    }
}
