package com.jerry.springboot_pagehelper.controller;

import com.jerry.springboot_pagehelper.pojo.Student;
import com.jerry.springboot_pagehelper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public boolean addStudent(@RequestBody Student student)
    {
        System.out.println("开始新增...");
        return studentService.insert(student);
    }
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public boolean updateStudent(@RequestBody Student student)
    {
        System.out.println("开始更新...");
        return studentService.update(student);
    }
    @RequestMapping(value = "/student", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam int id) {
        System.out.println("开始删除...");
        return studentService.deleteByPrimaryKey(id);
    }
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> findByStudent(Student student,@RequestParam int num) {
        System.out.println("开始查询...");
        return studentService.findByListEntity(student,num);
    }
    @RequestMapping(value = "/allStudent")
    public List<Student> findAll()
    {
        System.out.println("开始查询所有学生...");
        return studentService.findAll();
    }
}
