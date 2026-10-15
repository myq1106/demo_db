package com.exam.demo_db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.demo_db.entity.Student;

/**
 * 学生 Service 接口
 *
 * 讲解要点：
 * 继承 IService<Student>，在 Mapper 基础上进一步封装了 save / getById / updateById / removeById 等
 * 更贴合业务语义的方法（内部仍是调用 Mapper），Controller 层直接面向 Service 编程。
 */
public interface StudentService extends IService<Student> {
}
