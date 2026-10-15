package com.exam.demo_db.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 字段自动填充处理器
 *
 * 讲解要点：
 * 1. 实现 MetaObjectHandler 接口并交给 Spring（@Component）。
 * 2. insertFill 在“插入”时触发，给标记了 @TableField(fill = FieldFill.INSERT) 的字段赋值。
 * 3. 这里给 createTime 填当前时间，所以新增学生时前端无需手动传 create_time。
 * 4. strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now())
 *    参数含义：元对象、实体字段名（Java 属性名）、字段类型、填充的值。
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 本示例没有“更新时自动填充”的字段，留空即可
    }
}
