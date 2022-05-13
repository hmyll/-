package com.aynu.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TbDoc {

    @TableId(type = IdType.INPUT)
    private Integer id;
    private Integer pid;
    private String name;
    private Integer type;


}
