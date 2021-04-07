package com.chinasoft.springboot.entities;

import lombok.Data;

/**
 * @author 15075
 * @date 2021/4/6 09:06:08
 * @discription 椅子
 */
@Data
public class Chair {
    /**椅子编号*/
    private Integer Cid;

    /**
     * 顾客
     */
    private Customer customer;
}
