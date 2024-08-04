package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: DishServiceImpl
 * Package: com.sky.service.impl
 * Description
 * Authot: Lin
 * Creat: 2024/8/3-22:05
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    @Autowired
    private DishMapper dishMapper;
    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    @Transactional
    @Override
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);


        //像菜品表插入一条数据
        dishMapper.insert(dish);

        //获取insert生成的主键值
        Long dishId = dish.getId();

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && flavors.size() >0){
            flavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(dishId);
            });
            //口味表插入多条数据
            dishFlavorMapper.insertBatch(flavors);
        }


    }
}
