package com.chinasoft.springboot.entities;

import lombok.Data;
import org.thymeleaf.util.ObjectUtils;

import java.util.List;

/**
 * @author 15075
 * @date 2021/4/6 09:07:27
 * @discription 顾客
 */
@Data
public class Customer {

    private Integer cusId;
    private String cusName;

    private void dianCai(List<Food> foods, Menu menu){
        Integer menuSize = menu.getMenu().size();

        int i = (int) (Math.random() * menuSize );

        Food food = menu.getMenu().get(i);

        System.out.println("顾客"+cusName+"点了菜品：" + food.getFoodName());
        foods.add(food);
        System.out.println("菜品"+food.getFoodName()+"加入到点菜单中。");
    }

    private void chiFan(List<Customer> customers,Customer customer, Food food) throws InterruptedException {
        if (food != null){
            Thread.sleep(3000);
            customers.remove(customers.indexOf(customer));
            System.out.println("顾客"+cusName+"吃完了" + food.getFoodName()+",并离开");
        }
    }
}
