package com.jayce.alicloud.umsserver.common.base;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseServiceInterFace<M extends Mapper<T>, T>{

    public T selectById(Object id);

    public List<T> selectList(T entity);

    public List<T> selectListAll();

    public Long selectCount(T entity);

    public void insert(T entity);

    public void insertSelective(T entity);

    public void delete(T entity);

    public void deleteById(Object id);

    public int deleteByExample(Object example);

    public void updateById(T entity);

    public void updateSelectiveById(T entity);

    public List<T> selectByExample(Object example);

    public int selectCountByExample(Object example);

}
