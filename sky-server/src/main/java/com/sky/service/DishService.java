package com.sky.service;

import com.sky.dto.DishDTO;
import org.springframework.stereotype.Service;

/**
 * ClassName: DishService
 * Package: com.sky.service
 * Description
 * Authot: Lin
 * Creat: 2024/8/3-21:53
 */
public interface DishService {
    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
