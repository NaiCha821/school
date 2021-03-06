package com.jichuangsi.school.user.service;

import com.github.pagehelper.PageInfo;
import com.jichuangsi.microservice.common.model.UserInfoForToken;
import com.jichuangsi.school.user.exception.SchoolServiceException;
import com.jichuangsi.school.user.model.org.ClassModel;
import com.jichuangsi.school.user.model.school.GradeModel;
import com.jichuangsi.school.user.model.school.PhraseModel;
import com.jichuangsi.school.user.model.school.SchoolModel;
import com.jichuangsi.school.user.model.school.SubjectModel;

import java.util.List;

public interface ISchoolService {

    void insertSchool(UserInfoForToken userInfo,SchoolModel model) throws SchoolServiceException;

    void updateSchool(UserInfoForToken userInfo,SchoolModel model) throws SchoolServiceException;

    void insertGrade(UserInfoForToken userInfo,GradeModel model) throws SchoolServiceException;

    void updateGrade(UserInfoForToken userInfo,GradeModel model) throws  SchoolServiceException;

    List<SchoolModel> getSchools() throws SchoolServiceException;

    PageInfo<SchoolModel> getSchoolsInPage(int pageIndex, int pageSize) throws SchoolServiceException;

    List<GradeModel> getGrades(String schoolId) throws SchoolServiceException;

    void deleteSchool(UserInfoForToken userInfo, String schoolId) throws SchoolServiceException;

    void deleteGrade(UserInfoForToken userInfo, String gradeId) throws  SchoolServiceException;

    void insertSubject(UserInfoForToken userInfo, SubjectModel model) throws SchoolServiceException;

    List<SubjectModel> getSubjects(UserInfoForToken userInfo);

    void insertPhrase(UserInfoForToken userInfo, PhraseModel model) throws SchoolServiceException;

    List<PhraseModel> getPhraseBySchool(String schoolId) throws SchoolServiceException;

    List<GradeModel> getGradeByPhrase(String phrase) throws SchoolServiceException;

    void deleteSubject(UserInfoForToken userInfo ,String subjectId) throws SchoolServiceException;

    void deletePhrase(UserInfoForToken userInfo,String phrase) throws SchoolServiceException;

    void updateSubject(UserInfoForToken userInfo,SubjectModel model) throws SchoolServiceException;

    void updatePhrase(UserInfoForToken userInfo,PhraseModel model) throws SchoolServiceException;

    SchoolModel getSchoolById(UserInfoForToken userInfo,String schoolId) throws SchoolServiceException;

    PageInfo<GradeModel> findPastGrades(UserInfoForToken userInfo, String pharseId, String graduationTime, int pageIndex, int pageSize) throws SchoolServiceException;

    PageInfo<ClassModel> findPastClass(UserInfoForToken userInfo, String gradeId, String graduationTime, int pageIndex, int pageSize) throws SchoolServiceException;

    void coldStudentInGraduation(UserInfoForToken userInfo,String classId,String schoolId) throws SchoolServiceException;

    void graduationGrade(UserInfoForToken userInfo,String gradeId) throws SchoolServiceException;
}
