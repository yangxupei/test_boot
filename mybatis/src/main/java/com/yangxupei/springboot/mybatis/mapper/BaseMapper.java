package com.yangxupei.springboot.mybatis.mapper;

import java.util.List;

/**
 * Author: Yang xp
 * Date: 2016/10/18
 * Time: 3:33
 * Desc：
 */
public interface BaseMapper<T> {

    /**
     * 创建
     */
    int create(T t);

    /**
     *修改
     */
    int update(T t);

    /**
     * 删除根据id
     */
    int delete(String id);

    /**
     * 根据model查询
     */
    List<T> selectByModel(T t);

    /**
     * 根据主键查询
     */
    T selectByKey(String key);

    /**
     * 批量插入报表
     */
    int batchInsert(List<T> list);

    int deleteByModel(T model);
}
