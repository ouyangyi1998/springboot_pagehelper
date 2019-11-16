package com.jerry.springboot_pagehelper.service.impl;

import com.jerry.springboot_pagehelper.dao.BaseDao;
import com.jerry.springboot_pagehelper.dao.cluster.StudentDao;
import com.jerry.springboot_pagehelper.pojo.Student;
import com.jerry.springboot_pagehelper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    protected BaseDao<Student> getMapper() {
        return this.studentDao;
    }
}
