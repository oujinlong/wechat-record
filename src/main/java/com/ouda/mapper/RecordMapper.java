package com.ouda.mapper;

import com.ouda.entity.Record;
import com.ouda.entity.RecordWithBLOBs;
import com.ouda.entity.User;

import java.util.ArrayList;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordWithBLOBs record);

    int insertSelective(RecordWithBLOBs record);

    void insertUser(String name, String avatar, String nickName, String sign, String remark, Integer isGroupChat);

    RecordWithBLOBs selectByPrimaryKey(Integer id);

    ArrayList<RecordWithBLOBs> selectByName(String userA, String userB, Integer limit, Integer offset);

    int updateByPrimaryKeySelective(RecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordWithBLOBs record);

    int updateByPrimaryKey(Record record);

    ArrayList<User> selectUsers ( Integer limit, Integer offset);

    int selectUserCount();
}