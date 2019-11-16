package com.jerry.springboot_pagehelper.dao.cluster;

import com.jerry.springboot_pagehelper.dao.BaseDao;
import com.jerry.springboot_pagehelper.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentDao extends BaseDao<Student> {
}
