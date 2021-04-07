package com.chinasoft.springboot.thread;

import com.chinasoft.springboot.entities.Chef;

import java.util.List;

/**
 * @author 15075
 * @date 2021/4/6 16:27:15
 * @discription
 */

public class MakeChefThread implements Runnable{
    private List<Chef> chefs;

    public MakeChefThread(List<Chef> chefs){
        this.chefs = chefs;
    }

    @Override
    public void run() {
        while (4 > chefs.size()){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Chef chef = new Chef();
            chef.setChefId(chefs.size()+1);
            chef.setChefName("厨师"+(chefs.size()+1));

            chefs.add(chef);

            System.out.println(chef.getChefName());
        }

    }
}