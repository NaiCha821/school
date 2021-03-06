package com.jichuangsi.school.user.service;

import com.github.pagehelper.PageInfo;
import com.jichuangsi.microservice.common.model.UserInfoForToken;
import com.jichuangsi.school.user.exception.ClassServiceException;
import com.jichuangsi.school.user.exception.SchoolServiceException;
import com.jichuangsi.school.user.feign.model.ClassDetailModel;
import com.jichuangsi.school.user.model.org.ClassModel;
import com.jichuangsi.school.user.model.school.SchoolModel;
import com.jichuangsi.school.user.model.school.TeacherInsertModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISchoolClassService {

    @Transactional(rollbackFor = Exception.class)
    void saveOrUpClass(String schoolId, String gradeId, ClassModel classModel) throws ClassServiceException;

    @Transactional(rollbackFor = Exception.class)
    void deleteClass( String gradeId, String classId) throws ClassServiceException;

    ClassModel getClassInfo(String schoolId, String gradeId, String classId) throws ClassServiceException;

    ClassDetailModel getClassDetail(String classId) throws ClassServiceException;

    List<ClassModel> getClassesByGradeId(String gradeId) throws SchoolServiceException;

    PageInfo<ClassModel> getClassesByGradeIdInPage(String gradeId, int pageIndex, int pageSize) throws SchoolServiceException;

    SchoolModel getSchoolBySchoolId(String schoolId) throws SchoolServiceException;

    List<SchoolModel> getBackSchools() throws SchoolServiceException;

    @Transactional(rollbackFor = Exception.class)
    void classRemoveTeacher(UserInfoForToken userInfo , String classId ,String teacher) throws SchoolServiceException;

    @Transactional(rollbackFor = Exception.class)
    void classInsertTeacher(UserInfoForToken userInfo , TeacherInsertModel model,String teacherId) throws SchoolServiceException;

    void updateClassInsertSubject(UserInfoForToken userInfo,String subjectId,String classId) throws SchoolServiceException;

    void updateClassDelSubject(UserInfoForToken userInfo,String subjectId,String classId) throws SchoolServiceException;
}
