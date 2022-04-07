package com.manages.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        // 插入时：创建时间和修改时间
        this.setFieldValByName("createDate",new Date(),metaObject);
        this.setFieldValByName("modifyDate",new Date(),metaObject);


    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate",new Date(),metaObject);
    }
}
