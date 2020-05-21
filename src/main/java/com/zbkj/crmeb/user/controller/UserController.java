package com.zbkj.crmeb.user.controller;

import com.common.CommonPage;
import com.common.CommonResult;
import com.common.PageParamRequest;
import com.zbkj.crmeb.user.request.UserRequest;
import com.zbkj.crmeb.user.request.UserSearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import com.zbkj.crmeb.user.service.UserService;
import com.zbkj.crmeb.user.model.User;


/**
 * 用户表 前端控制器
 */
@Slf4j
@RestController
@RequestMapping("api/admin/user")
@Api(tags = "用户表") //配合swagger使用

public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页显示用户表
     * @param request 搜索条件
     * @param pageParamRequest 分页参数
     * @author Mr.Zhang
     * @since 2020-05-21
     */
    @ApiOperation(value = "分页列表") //配合swagger使用
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<User>>  getList(@Validated UserSearchRequest request, @Validated PageParamRequest pageParamRequest){
        CommonPage<User> userCommonPage = CommonPage.restPage(userService.getList(request, pageParamRequest));
        return CommonResult.success(userCommonPage);
    }

    /**
     * 新增用户表
     * @param userRequest 新增参数
     * @author Mr.Zhang
     * @since 2020-05-21
     */
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult<String> save(@Validated UserRequest userRequest){
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);

        if(userService.save(user)){
            return CommonResult.success();
        }else{
            return CommonResult.failed();
        }
    }

    /**
     * 删除用户表
     * @param id Integer
     * @author Mr.Zhang
     * @since 2020-05-21
     */
    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public CommonResult<String> delete(@RequestParam(value = "id") Integer id){
        if(userService.removeById(id)){
            return CommonResult.success();
        }else{
            return CommonResult.failed();
        }
    }

    /**
     * 修改用户表
     * @param id integer id
     * @param userRequest 修改参数
     * @author Mr.Zhang
     * @since 2020-05-21
     */
    @ApiOperation(value = "修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult<String> update(@RequestParam Integer id, @Validated UserRequest userRequest){
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
//        user.setId(id);

        if(userService.updateById(user)){
            return CommonResult.success();
        }else{
            return CommonResult.failed();
        }
    }

    /**
     * 查询用户表信息
     * @param id Integer
     * @author Mr.Zhang
     * @since 2020-05-21
     */
    @ApiOperation(value = "详情")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult<User> info(@RequestParam(value = "id") Integer id){
        User user = userService.getById(id);
        return CommonResult.success(user);
   }
}



