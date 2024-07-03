package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.sky.service
 * Description
 * Authot: Lin
 * Creat: 2024/7/3-17:57
 */
public interface CategoryService {
     /**
      * 新增分类
      * @param categoryDTO
      */
     void save(CategoryDTO categoryDTO);

     /**
      * 分类查询
      * @param categoryPageQueryDTO
      * @return
      */
     PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

     /**
      * 删除分类
      * @param id
      */
     void delete(Long id);

     /**
      * 更新分类
      * @param categoryDTO
      */
     void update(CategoryDTO categoryDTO);

     /**
      * 启用停用分类
      * @param status
      * @param id
      */
     void startOrStop(Integer status, Long id);

     /**
      * 根据类型分类查询
      * @param type
      * @return
      */
     List<Category> list(Integer type);
}
