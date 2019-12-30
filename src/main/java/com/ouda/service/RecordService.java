package com.ouda.service;
import com.ouda.dto.RecordDTO;
import com.ouda.entity.BaseResponse;
import com.ouda.entity.RecordWithBLOBs;
import com.ouda.entity.User;
import com.ouda.mapper.RecordMapper;
import com.ouda.util.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class RecordService {
    @Resource
    private RecordMapper recordMapper;

    public BaseResponse queryRecord (Integer id) {
        return Response.addResult(recordMapper.selectByPrimaryKey(id));
    }

    public void insertRecord (RecordDTO recordDTO) {
        User userA = recordDTO.getUserA();
        User userB = recordDTO.getUserB();
        RecordWithBLOBs record = recordDTO.getRecord();
        if (userA != null && userB != null && userA.getName() != null && userB.getName() != null) {
            recordMapper.insertUser(userA.getName(), userA.getAvatar(), userA.getNickName(), userA.getSign(), userA.getRemark(), userA.getIsGroupChat());
            recordMapper.insertUser(userB.getName(), userB.getAvatar(), userB.getNickName(), userB.getSign(), userB.getRemark(), userB.getIsGroupChat());
        }
        if (record != null) {
            recordMapper.insertSelective(record);
        }
    }

    public BaseResponse queryRecordByName (String userA, String userB, Integer pageNo, Integer pageSize) {
        Integer limit = pageSize;
        Integer offset = pageSize * (pageNo - 1);
        Float total = Float.parseFloat(recordMapper.selectUserCount() + "");
        Integer totalPage = (int)Math.ceil(total / pageSize);
        ArrayList<RecordWithBLOBs> records = recordMapper.selectByName(userA, userB, limit, offset);

        return Response.addResult(records, totalPage);
    }

    public BaseResponse getUsers (Integer pageNo, Integer pageSize) {
        Integer limit = pageSize;
        Integer offset = pageSize * (pageNo - 1);
        ArrayList<User> users =recordMapper.selectUsers(limit, offset);
        Float total = Float.parseFloat(recordMapper.selectUserCount() + "");
        Integer totalPage = (int)Math.ceil(total / pageSize);
        return  Response.addResult(users, totalPage);
    }

    public BaseResponse getMyRecord () {
        Integer pageSize = 300;
        Integer pageNo = 1;
        Integer limit = pageSize;
        Integer offset = pageSize * (pageNo - 1);
        return Response.addResult(recordMapper.selectByName("fairytaleou", "ying9091", limit, offset));
    }
}
