package com.spring.boot.mybatisplusreview.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 19:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;

}
