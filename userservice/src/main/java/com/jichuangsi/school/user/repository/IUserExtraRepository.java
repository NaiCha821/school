package com.jichuangsi.school.user.repository;

import com.jichuangsi.school.user.entity.UserInfo;

import java.util.List;

public interface IUserExtraRepository {

    List<UserInfo> findByRoleInfos(String classId);

    List<UserInfo> findBySchoolId(String schoolId);

    int findByPrimaryClassAndTeacher(String classId);

    List<UserInfo> findByCondition(String schoolId,String pharseId,String gradeId,String classId,String userName,String roleName,String subjectId,int pageIndex,int pageSize);

    int countByCondition(String schoolId,String pharseId,String gradeId,String classId,String userName,String roleName,String subjectId);

}
