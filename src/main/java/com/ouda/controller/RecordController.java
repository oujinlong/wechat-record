package com.ouda.controller;

import com.ouda.dto.LoginDTO;
import com.ouda.dto.RecordDTO;
import com.ouda.entity.BaseResponse;
import com.ouda.entity.RecordWithBLOBs;
import com.ouda.entity.User;
import com.ouda.service.RecordService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class RecordController {
    @Resource
    private RecordService recordService;

    @PostMapping("/login")
    @ApiOperation(value= "登录", notes = "登录请求")
    public  String login (@RequestBody LoginDTO loginDto) {
        return loginDto.getUserName() + " - " + loginDto.getPassword();
    }

    @GetMapping("/get/record")
    @ApiOperation(value = "获取聊天记录", notes = "获取聊天记录请求")
    @ApiImplicitParams(value = {
        @ApiImplicitParam( name =  "id", value = "记录 id")
    })
    public BaseResponse getRecord (@RequestParam String id) {
        Integer recordId = Integer.parseInt(id);
        return recordService.queryRecord(recordId);
    }

    @GetMapping("/get/recordForUsers")
    @ApiOperation(value = "获取某人的聊天记录")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userA", value = "某个人名称"),
            @ApiImplicitParam(name = "userB", value = "对方名称"),
            @ApiImplicitParam(name = "pageNo", value = "当前页"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数")
    })
    public BaseResponse getRecordForUser (@RequestParam String userA , @RequestParam String userB, @RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return recordService.queryRecordByName(userA, userB, pageNo, pageSize);
    }

    @PostMapping("/add/record")
    @ApiOperation(value = "添加聊天记录")
    public void addRecord (@RequestBody RecordDTO recordDTO) {
        recordService.insertRecord(recordDTO);
    }

    @GetMapping("/get/users")
    @ApiOperation(value = "获取所有用户")
    public BaseResponse getUsers (@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return recordService.getUsers(pageNo, pageSize);
    }

    @GetMapping("/myRecord")
    @ApiOperation(value = "获取本人聊天记录")
    public BaseResponse getMyRecord () {
        return recordService.getMyRecord();
    }

}
