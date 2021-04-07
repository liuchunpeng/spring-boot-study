package com.chinasoft.springboot.thread;

import com.chinasoft.springboot.entities.Chair;
import com.chinasoft.springboot.entities.Customer;
import com.chinasoft.springboot.entities.Table;

import java.util.List;

/**
 * @author 15075
 * @date 2021/4/6 16:28:42
 * @discription
 */

public class MakeCustomerThread implements Runnable{
    private List<Customer> customers;

    private List<Customer> allCustomers;

    private List<Table> tables;

    public MakeCustomerThread (List<Customer> allCustomers,List<Customer> customers,
                        List<Table> tables){
        this.customers = customers;
        this.tables = tables;
        this.allCustomers = allCustomers;
    }

    @Override
    public void run() {
        //招揽顾客
        while (true){
            try {
                //平均每5秒招揽一位顾客
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Customer customer = new Customer();
            customer.setCusId(allCustomers.size()+1);
            customer.setCusName("顾客"+(allCustomers.size()+1));

            customers.add(customer);
            allCustomers.add(customer);

            System.out.println(customer.getCusName() + "光顾了本店");
        }
    }
}