package com.exam.demo_db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.demo_db.entity.Student;
import com.exam.demo_db.mapper.StudentMapper;
import com.exam.demo_db.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * 学生 Service 实现类
 *
 * 讲解要点：
 * ServiceImpl<StudentMapper, Student> 已经实现了 IService 的全部通用方法，
 * 这里只需继承它并实现自定义接口即可，无需重复写 CRUD 代码。
 * @Service 交给 Spring 管理，Controller 通过构造器注入使用。
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
