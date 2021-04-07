package com.chinasoft.springboot.controller;

import com.chinasoft.springboot.entities.*;
import com.chinasoft.springboot.thread.CusQueueMonitorThread;
import com.chinasoft.springboot.thread.MakeChefThread;
import com.chinasoft.springboot.thread.MakeCustomerThread;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 15075
 * @date 2021/4/6 08:56:32
 * @discription
 */
@RestController
public class HappeyRestaurantController {
    public static void main(String[] args) throws InterruptedException {
        Menu menu = getMenu();

        List<Food> foods = new ArrayList<>();

        List<Chef> chefs = new ArrayList<>();

        //排队中的顾客
        List<Customer> customers = new LinkedList<>();

        //全部的顾客
        List<Customer> allCustomers = new LinkedList<>();

        List<Table> tables = getTables();

        MakeCustomerThread makeCustomer = new MakeCustomerThread(allCustomers,customers,tables);
        Thread makeCustomerThread =new Thread(makeCustomer);
        makeCustomerThread.start();

        MakeChefThread makeChef = new MakeChefThread(chefs);
        Thread makeChefThread =new Thread(makeChef);
        //makeChefThread.start();

        CusQueueMonitorThread cusQueueMonitor = new CusQueueMonitorThread(allCustomers,customers,tables);
        Thread cusQueueMonitorThread =new Thread(cusQueueMonitor);
        cusQueueMonitorThread.start();

        Thread.sleep(5000);

        System.out.println("111"+customers);
    }

    private static List<Table> getTables() {
        Table table1 = new Table();
        table1.setTid(1);
        Chair chai1 = new Chair();
        chai1.setCid(1);
        Chair chai2 = new Chair();
        chai2.setCid(2);

        List<Chair> table1Char = new ArrayList<>() ;
        table1Char.add(chai1);
        table1Char.add(chai2);
        table1.setChairs(table1Char);

        Table table2 = new Table();
        table2.setTid(2);
        Chair chai3 = new Chair();
        chai3.setCid(3);
        Chair chai4 = new Chair();
        chai4.setCid(4);

        List<Chair> table2Char = new ArrayList<>() ;
        table2Char.add(chai3);
        table2Char.add(chai4);
        table2.setChairs(table2Char);

        List<Table> tables = new ArrayList<>();
        tables.add(table1);
        tables.add(table2);

        return  tables;
    }

    private static Menu getMenu() {
        Menu menu = new Menu();
        List<Food> cai = new ArrayList<>();
        Food food1 = new Food();
        food1.setFoodId(1);
        food1.setFoodName("意大利面1");

        Food food2 = new Food();
        food2.setFoodId(2);
        food2.setFoodName("小鸡炖蘑菇2");

        Food food3 = new Food();
        food3.setFoodId(3);
        food3.setFoodName("黄焖鸡3");

        Food food4 = new Food();
        food4.setFoodId(4);
        food4.setFoodName("咖喱土豆4");

        return menu;
    }
}


