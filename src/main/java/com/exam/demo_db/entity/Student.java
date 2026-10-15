package com.exam.demo_db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 学生实体类，对应数据库表 student
 *
 * 讲解要点：
 * 1. @TableName("student")：把实体类与数据库表绑定。
 *    当类名和表名满足“驼峰转下划线”规则时可省略，这里显式写出便于讲解。
 * 2. @TableId(type = IdType.AUTO)：声明 id 为主键，且主键由数据库自增生成。
 *    插入后 MyBatis-Plus 会把数据库生成的自增 id 回填到实体对象里。
 * 3. @TableLogic：逻辑删除标记。执行 delete 时不会真正 DELETE 数据，
 *    而是自动把 deleted 从 0 改成 1（UPDATE），查询时自动拼接 deleted = 0 过滤已删除数据。
 * 4. @TableField(fill = FieldFill.INSERT)：插入时自动填充 create_time，
 *    具体填充逻辑在 config/MyMetaObjectHandler 里实现。
 * 5. @Data（Lombok）：编译期自动生成 getter/setter/toString/equals/hashCode。
 */
@Data
@TableName("student")
public class Student {

    /** 主键，数据库自增 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 姓名 */
    private String name;

    /** 性别 */
    private String gender;

    /** 专业 */
    private String major;

    /** 分数 */
    private Integer score;

    /** 创建时间，插入时由 MetaObjectHandler 自动填充 */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /** 逻辑删除标记：0 未删除，1 已删除 */
    @TableLogic
    private Integer deleted;
}
