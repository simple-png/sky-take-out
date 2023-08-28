package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应套餐id
     *
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 添加套餐对应内容
     *
     * @param setmealDishes
     */
    void add(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id查询对应内容
     *
     * @param SetmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id=#{SetmealId}")
    List<SetmealDish> getSetmealIdsBySetmealId(Long SetmealId);


    /**
     * 根据套餐id删除对应内容
     *
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id=#{setmealId}")
    void delete(Long setmealId);
}
