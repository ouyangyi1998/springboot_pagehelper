package com.jerry.springboot_pagehelper.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jerry.springboot_pagehelper.dao.BaseDao;
import com.jerry.springboot_pagehelper.pojo.Student;
import com.jerry.springboot_pagehelper.pojo.User;
import com.jerry.springboot_pagehelper.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class BaseServiceImpl<T> implements BaseService<T>
{
    protected abstract BaseDao<T> getMapper();

    private String getClassName(T t)
    {
        String str="";
        if(t instanceof User)
        {
            str="User";
        }else if(t instanceof Student)
        {
            str="Student";
        }
        return str;
    }
    @Override
    public boolean insert(T entity) {
        boolean flag=false;
        try{
            getMapper().insert(entity);
            flag=true;
        }catch (Exception e)
        {
            log.error("新增"+getClassName(entity)+"失败，原因是："+e);
        }
        return flag;
    }

    @Override
    public boolean update(T entity) {
        boolean flag=false;
        try{
            getMapper().update(entity);
            flag=true;
        }catch (Exception e)
        {
            log.error("更新"+getClassName(entity)+"失败!原因是:",e);
        }
        return flag;
    }

    @Override
    public boolean deleteByPrimaryKey(int id) {
        boolean flag=false;
        try{
            getMapper().deleteByPrimaryKey(id);
            flag=true;
        }catch (Exception e)
        {
            log.error("id:"+id+"删除失败!原因是:",e);
        }
        return flag;
    }

    @Override
    public List<T> findByListEntity(T entity,int num) {
        List<T> list=null;
        try{
            Page<?> page= PageHelper.startPage(num,2);
            System.out.println(getClassName(entity)+"设置第一页两条数据!");
            list=getMapper().findByListEntity(entity);
            System.out.println("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"两条数据!");
        }catch (Exception e)
        {
            log.error("查询"+getClassName(entity)+"失败!原因是:",e);
        }
        return list;
    }

    @Override
    public List<T> findAll() {
       List<T> list=null;
       try{
           list=getMapper().findAll();
       }catch (Exception e)
       {
           log.error("查询失败!原因是:",e);
       }
       return list;
    }

}
