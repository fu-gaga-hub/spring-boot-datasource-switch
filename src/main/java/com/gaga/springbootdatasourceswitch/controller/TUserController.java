package com.gaga.springbootdatasourceswitch.controller;

import com.gaga.springbootdatasourceswitch.entity.TUser;
import com.gaga.springbootdatasourceswitch.service.TUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2021-04-22 15:35:59
 */
@RestController
@RequestMapping("tUser")
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(Integer id) {
        TUser user = this.tUserService.queryById(id);
        return user;
    }

    @RequestMapping("selectAllByPage")
    public List<TUser> selectAllByPage(int pageNumber, int pageSize){
        List<TUser> userList = this.tUserService.queryAllByLimit(pageNumber, pageSize);

        return userList;
    }

}