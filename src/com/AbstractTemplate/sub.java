package com.AbstractTemplate;

public class sub extends Template {
    @Override
    public void code() {
        String str = "hello";
        for (int i = 0;i < 10000;i++){
            str += "jack" + i;
        }
    }
}
