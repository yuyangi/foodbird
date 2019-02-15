package com.foodbird.common.enums;

public enum FBWordType {

    n("名词", "n"),
    v("动词", "v"),
    adj("形容词", "adj"),
    adv("副词", "adv"),
    num("数词", "num"),
    pl("复数", "pl"),
    ;

    private String cn;
    private String en;

    FBWordType(String cn, String en) {
        this.cn = cn;
        this.en = en;
    }

    public String getCn() {
        return cn;
    }

    public String getEn() {
        return en;
    }
}
