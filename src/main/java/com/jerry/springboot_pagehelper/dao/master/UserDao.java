package com.jerry.springboot_pagehelper.dao.master;

import com.jerry.springboot_pagehelper.dao.BaseDao;
import com.jerry.springboot_pagehelper.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao extends BaseDao<User> {
}
