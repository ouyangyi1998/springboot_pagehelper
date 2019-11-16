package com.jerry.springboot_pagehelper.service;

import java.util.List;

public interface BaseService<T> {
    boolean insert(T entity);

    boolean update(T entity);

    boolean deleteByPrimaryKey(int id);

    List<T> findByListEntity(T entity,int num);

    List<T> findAll();


}
