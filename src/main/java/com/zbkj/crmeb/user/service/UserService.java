package com.zbkj.crmeb.user.service;

import com.common.PageParamRequest;
import com.zbkj.crmeb.user.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbkj.crmeb.user.request.UserSearchRequest;

import java.util.List;

/**
* @author Mr.Zhang
* @description UserService 接口
* @date 2020-05-21
*/
public interface UserService extends IService<User> {

    List<User> getList(UserSearchRequest request, PageParamRequest pageParamRequest);
}