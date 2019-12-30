package com.ouda.dto;

import com.ouda.entity.RecordWithBLOBs;
import com.ouda.entity.User;

public class RecordDTO {
    private RecordWithBLOBs record;
    private User UserA;
    private User UserB;

    public void setRecord(RecordWithBLOBs record) {
        this.record = record;
    }

    public RecordWithBLOBs getRecord() {
        return record;
    }

    public void setUserA(User userA) {
        UserA = userA;
    }

    public User getUserA() {
        return UserA;
    }

    public void setUserB(User userB) {
        UserB = userB;
    }

    public User getUserB() {
        return UserB;
    }
}
