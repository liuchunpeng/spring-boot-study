package com.chinasoft.springboot.thread;

import com.chinasoft.springboot.entities.Chair;
import com.chinasoft.springboot.entities.Customer;
import com.chinasoft.springboot.entities.Table;

import java.util.List;

/**
 * @author 15075
 * @date 2021/4/6 17:17:17
 * @discription
 */
public class CusQueueMonitorThread implements Runnable{
    private List<Customer> customers;

    private List<Customer> allCustomers;

    private List<Table> tables;

    public CusQueueMonitorThread (List<Customer> allCustomers,List<Customer> customers,
                               List<Table> tables){
        this.customers = customers;
        this.tables = tables;
        this.allCustomers = allCustomers;
    }
    @Override
    public void run() {
        while (true){
            if (customers.size()>0){
                System.out.println(customers);
                outer:
                for (Table table:tables)  {
                    for (Chair chair: table.getChairs()) {

                        //椅子上无顾客就放进等待中的顾客
                        if (chair.getCustomer() == null){

                            //等待的第一个入座
                            chair.setCustomer(customers.get(0));

                            System.out.println(customers.get(0).getCusName()+"坐在了"
                                    +table.getTid()+ "号桌的" + chair.getCid()+"号椅子上");

                            //客人从等待队列中移除
                            customers.remove(0);

                            System.out.println("剩余等待客人：" + customers);
                        }

                        break outer;
                    }
                }

            }
        }
    }
}
