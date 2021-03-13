package com.AbstractTemplate;

abstract class Template {
    abstract public void code();
    public void caletime(){
        //得到当前时间,毫秒
        long nowtime = System.currentTimeMillis();
        code();
        //得到执行执行厚的时间
        long endtime = System.currentTimeMillis();
        System.out.println("代码执行时间为" + (endtime-nowtime));
    }
}
