package com.exam.demo_db.controller;

import com.exam.demo_db.entity.Student;
import com.exam.demo_db.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生 REST 接口
 *
 * 讲解要点：
 * 1. @RestController = @Controller + @ResponseBody，返回的对象会被自动序列化成 JSON。
 * 2. @RequestMapping("/student") 统一了本类所有接口的前缀。
 * 3. 四个方法分别对应：新增(POST)、查询(GET)、修改(PUT)、逻辑删除(DELETE)。
 *    演示建议顺序：先用 POST 新增，再用 GET 查询，观察 id 和 create_time 是否被自动填充；
 *    最后 DELETE，再到数据库确认 deleted 字段由 0 变成 1（数据还在，属于逻辑删除）。
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    // 构造器注入（推荐方式，字段用 final 更安全）
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /** 新增：POST /student，body 传 JSON，
     * 如 {"name":"测试","gender":"男","major":"软件工程","score":88} */
    @PostMapping
    public Student add(@RequestBody Student student) {
        studentService.save(student);
        // save 之后 id 已被回填、createTime 已被自动填充，直接返回给前端看效果
        return student;
    }

    /** 查询单个：GET /student/{id}，如 GET /student/1 */
    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.getById(id);
    }

    /** 修改：PUT /student，body 传 JSON，id 必填，只更新传入的非 null 字段 */
    @PutMapping
    public boolean update(@RequestBody Student student) {
        return studentService.updateById(student);
    }

    /** 删除：DELETE /student/{id}，是逻辑删除（deleted 由 0 改为 1） */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return studentService.removeById(id);
    }
}
