package com.jichuangsi.school.statistics.feign.impl;

import com.jichuangsi.microservice.common.model.ResponseModel;
import com.jichuangsi.school.statistics.feign.IUserFeignService;
import com.jichuangsi.school.statistics.feign.model.ClassDetailModel;
import com.jichuangsi.school.statistics.feign.model.TransferStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFallBackFeignServiceImpl implements IUserFeignService {

    @Override
    public ResponseModel<ClassDetailModel> getClassDetail(String classId) {
        return ResponseModel.fail("");
    }

    @Override
    public ResponseModel<List<String>> getTeachClassIds(String teacherId) {
        return ResponseModel.fail("");
    }

    @Override
    public ResponseModel<List<ClassDetailModel>> getClassDetailByIds(List<String> classIds) {
        return ResponseModel.fail("");
    }

    @Override
    public ResponseModel<List<TransferStudent>> getStudentsForClass(String classId) {
        return ResponseModel.fail("");
    }
}
