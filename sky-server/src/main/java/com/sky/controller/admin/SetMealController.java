package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.dto.DishPageQueryDTO;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import com.sky.service.SetMealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/setmeal")
@Api(tags = "套餐接口")
public class SetMealController {
    @Autowired
    private SetMealService setMealService;

    @ApiOperation("新增套餐")
    @PostMapping
    public Result add(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐:{}", setmealDTO);
        setMealService.add(setmealDTO);
        return Result.success();
    }

    @ApiOperation("根据id查询套餐")
    @GetMapping("/{id}")
    public Result<SetmealDTO> getById(@PathVariable Long id) {
        SetmealDTO setmealDTO = setMealService.getById(id);
        return Result.success(setmealDTO);
    }

    /**
     * 套餐分页查询
     *
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("套餐分页查询{}", setmealPageQueryDTO);
        PageResult pageResult = setMealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping()
    @ApiOperation("批量删除套餐")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("批量删除套餐id:{}", ids);
        setMealService.delete(ids);
        return Result.success();
    }
    @PutMapping
    @ApiOperation("修改套餐")
    public Result update(@RequestBody SetmealDTO setmealDTO){
        log.info("批量修改{}",setmealDTO);
        setMealService.update(setmealDTO);
        return Result.success();
    }

    @PostMapping("status/{status}")
    @ApiOperation("套餐起售、停售")
    public Result setStatus(@PathVariable Integer status,@RequestParam Long id){
        log.info("设置套餐{}状态为{}",id,status);
        setMealService.setStatus(status,id);
        return Result.success();
    }

}
