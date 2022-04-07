package com.mbg.exam.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
@Data
@EqualsAndHashCode(callSuper = false)
public class kupojo implements Serializable {

    private List<Choose> chooses;


    private List<Fill> fills;


    private List<FullInput> fullInputs;


    private List<Listen> listens;


    private List<Mingci> mingciss;


    private List<Yue> yues;
}
