package com.jerry.springboot_pagehelper.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
public interface BaseDao<T> {
    void insert(T entity) throws Exception;

    void update(T entity) throws Exception;

    void deleteByPrimaryKey(int id) throws Exception;

    List<T> findByListEntity(T entity);

    List<T> findAll();

}
