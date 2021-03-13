package com.kehu.service;

import com.kehu.pojo.Customer;

import java.util.Scanner;


/**
 * 客户信息管理系统：（service层）
 *
 * @author Administrator
 * @version 1.0
 * @time 2019年3月12日  19时04分28秒
 */
public class CustomerService {
    private Customer[] customers;
    Customer customer = null;
    private int size = 0;
    private Scanner scanner = new Scanner(System.in);
    char key = ' ';
    boolean flag = true;

    public CustomerService(int initialSize) {
        customers = new Customer[initialSize];
    }

    public void mainMenu() {
        int id = 0;
        do {
            System.out.println("----------------客户信息管理软件----------------------");
            System.out.println("                1 添 加 客 户");
            System.out.println("                2 修 改 客 户");
            System.out.println("                3 删 除 客 户");
            System.out.println("                4 客 户 列 表");
            System.out.println("                5 查 询 客 户");
            System.out.println("                6 退           出");
            System.out.print("             请选择(1-6)：");
            key = scanner.next().charAt(0);
            switch (key) {
                case '1':
                    add();
                    break;
                case '2':
                    System.out.print("请输入你要修改的Id:");
                    id = scanner.nextInt();
                    modifyById(id);
                    break;
                case '3':
                    System.out.print("请输入你要删除的Id:");
                    id = scanner.nextInt();
                    if (delete(id)) {
                        System.out.println("-----------删除成功------------");
                    } else {
                        System.out.println("删除失败。你要删除的id不存在！");
                    }
                    break;
                case '4':
                    list();
                    break;
                case '5':
                    System.out.print("请输入你要查询的Id:");
                    id = scanner.nextInt();
                    customer = findById(id);
                    if (customer != null) {
                        display(customer);
                    }
                    break;
                case '6':
                    exit();
                    break;
                default:
                    break;
            }
        } while (flag);
    }

    public boolean add() {
        if (this.size > 10) {
            System.out.println("数组容量已满，无法再添加客户");
            return false;
        }
        Customer customer = new Customer();
        customer.setNo(++size);
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        customer.setName(scanner.next());
        System.out.print("性别：");
        customer.setGender(scanner.next().charAt(0));
        System.out.print("年龄：");
        customer.setAge(scanner.nextInt());
        System.out.print("电话：");
        customer.setPhone(scanner.next());
        System.out.print("邮箱：");
        customer.setEmail(scanner.next());
        customers[size - 1] = customer;
        System.out.println("---------------------添加完成---------------------");
        return true;
    }

    public void list() {
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
        for (int i = 0; i < size; i++) {
            System.out.println(customers[i].getNo() + "\t" + customers[i].getName() + "\t" +
                    customers[i].getGender() + "\t" + customers[i].getAge() + "\t" +
                    customers[i].getPhone() + "\t\t" + customers[i].getEmail());
        }
        System.out.println("---------------------------客户列表完成---------------------------");
    }

    public Customer findById(int id) {
        for (int i = 0; i < size; i++) {
            if (customers[i].getNo() == id) {
                return customers[i];
            }
        }
        return null;
    }

    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (customers[i].getNo() == id) {
                return i;
            }
        }
        return index;
    }

    public void display(Customer customer) {
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
        System.out.println(customer.getNo() + "\t" + customer.getName() + "\t" +
                customer.getGender() + "\t" + customer.getAge() + "\t" +
                customer.getPhone() + "\t\t" + customer.getEmail());
    }

    public boolean modifyById(int id) {
        Customer customer = findById(id);
        if (customer == null) {
            System.out.println("你要修改的id不存在！");
            return false;
        }
        System.out.println("---------------------修改客户---------------------");
        System.out.print("姓名：");
        customer.setName(scanner.next());
        System.out.print("性别：");
        customer.setGender(scanner.next().charAt(0));
        System.out.print("年龄：");
        customer.setAge(scanner.nextInt());
        System.out.print("电话：");
        customer.setPhone(scanner.next());
        System.out.print("邮箱：");
        customer.setEmail(scanner.next());
        System.out.println("---------------------修改完成---------------------");
        return true;
    }

    public boolean delete(int id) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            customers[i] = customers[i + 1];
        }
        customers[size - 1] = null;
        this.size--;
        return true;
    }

    public void exit() {
        System.out.print("确认是否退出(Y/N)：");
        do {
            key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Y' || key == 'N') {
                break;
            }
            System.out.print("选择错误，请重新输入：");
        } while (true);
        if (key == 'Y') {
            flag = false;
            System.out.println("您已退出客户信息管理系统，欢迎下次使用...");
            return;
        }
    }
}