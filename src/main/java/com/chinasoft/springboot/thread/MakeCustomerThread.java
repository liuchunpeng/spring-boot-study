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
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Customer customer = new Customer();
            customer.setCusId(allCustomers.size()+1);
            customer.setCusName("顾客"+(allCustomers.size()+1));

            //剩余座位标记 true：有 false：无
            boolean hasEmpty = false;
            outer:
            for (Table table:tables)  {
                for (Chair chair: table.getChairs()) {

                    //椅子上无顾客就放进等待中的顾客
                    if (chair.getCustomer() == null){

                        //无等待的顾客直接入座
                        if (customers.size() == 0){
                            chair.setCustomer(customer);
                            System.out.println(customer.getCusName()+"坐在了"
                                    +table.getTid()+ "号桌的" + chair.getCid()+"号椅子上");
                        }else {

                            //等待的第一个入座
                            chair.setCustomer(customers.get(0));

                            System.out.println(customers.get(0).getCusName()+"坐在了"
                                    +table.getTid()+ "号桌的" + chair.getCid()+"号椅子上");

                            //新客人进入等待
                            customers.remove(0);

                            customers.add(customer);
                            System.out.println(customer.getCusName()+"进如了排队，编号为：" + customers.size());

                        }

                        hasEmpty =true;
                        break outer;
                    }
                }
            }

            if (!hasEmpty){
                customers.add(customer);
                System.out.println(customer.getCusName()+"进如了排队，编号为：" + customers.size());
            }
            allCustomers.add(customer);
        }
    }
}