package com.jichuangsi.school.testservice.service;

import com.jichuangsi.microservice.common.model.UserInfoForToken;
import com.jichuangsi.school.testservice.exception.StudentTestServiceException;
import com.jichuangsi.school.testservice.model.AnswerModelForStudent;
import com.jichuangsi.school.testservice.model.TestModelForStudent;
import com.jichuangsi.school.testservice.model.SearchTestModel;
import com.jichuangsi.school.testservice.model.common.PageHolder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IStudentTestService {

    @Transactional
    List<TestModelForStudent> getTestsList(UserInfoForToken userInfo) throws StudentTestServiceException;

    @Transactional
    PageHolder<TestModelForStudent> getHistoryTestsList(UserInfoForToken userInfo, SearchTestModel searchTestModel) throws StudentTestServiceException;

    @Transactional
    TestModelForStudent getParticularTest(UserInfoForToken userInfo, String testId) throws StudentTestServiceException;

    @Transactional
    void saveStudentAnswer(UserInfoForToken userInfo, String testId, String questionId, AnswerModelForStudent answer) throws StudentTestServiceException;

    @Transactional
    void submitParticularTest(UserInfoForToken userInfo, String testId) throws StudentTestServiceException;
}
