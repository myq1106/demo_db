package com.exam.demo_db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.demo_db.entity.Student;

/**
 * 学生 Mapper 接口
 *
 * 讲解要点：
 * 继承 BaseMapper<Student> 后，无需写任何 SQL 和 XML，
 * 即可获得 insert / deleteById / updateById / selectById / selectList 等通用 CRUD 方法。
 * 接口由启动类上的 @MapperScan 扫描并生成代理对象，因此这里不需要 @Mapper 注解。
 */
public interface StudentMapper extends BaseMapper<Student> {
}
