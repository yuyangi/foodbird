package com.sub.gen.codes.metas;

import com.sub.gen.codes.IMeta;

public enum Charactor implements IMeta {

    SPACE(" "),
    SPACE4("    "),
    TAB("   "),
    SEMICOLON(";"),
    COMMA(","),
    POINT(".")
    ;
    private String code;

    Charactor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toCode() {
        return code;
    }
}
