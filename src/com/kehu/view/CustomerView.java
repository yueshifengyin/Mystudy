package com.kehu.view;


import com.kehu.service.CustomerService;

/**
 * 客户信息管理系统：（view层）
 *
 * @author Administrator
 * @version 1.0
 * @time 2019年3月12日  20时44分58秒
 */
public class CustomerView {

    public static void main(String[] args) {
        new CustomerService(10).mainMenu();
    }
}
