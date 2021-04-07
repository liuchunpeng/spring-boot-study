package com.chinasoft.springboot.entities;

import lombok.Data;

import java.util.List;

/**
 * @author 15075
 * @date 2021/4/6 09:36:29
 * @discription 厨师
 */
@Data
public class Chef {

    private Integer chefId;

    private String chefName;

    private void zuoCai(List<Food> foods) throws InterruptedException {
        Food food = foods.get(0);
        foods.remove(0);
        System.out.println("菜品"+food.getFoodName()+"从点菜单中被移除");
        System.out.println("厨师"+chefName+"开始做"+food.getFoodName());
        Thread.sleep(5000);
        System.out.println("厨师"+chefName+"做好了"+food.getFoodName());
    }
}
