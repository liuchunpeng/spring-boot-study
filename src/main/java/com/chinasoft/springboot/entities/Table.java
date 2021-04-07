package com.chinasoft.springboot.entities;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author 15075
 * @date 2021/4/6 09:03:20
 * @discription 桌子
 */
@Data
public class Table {

    /**桌子编号*/
    private Integer Tid;

    /**椅子*/
    private List<Chair> chairs;
}
