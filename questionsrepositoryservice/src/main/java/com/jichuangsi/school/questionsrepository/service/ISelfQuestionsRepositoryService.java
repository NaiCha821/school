package com.jichuangsi.school.questionsrepository.service;

import com.jichuangsi.microservice.common.model.UserInfoForToken;
import com.jichuangsi.school.questionsrepository.entity.SelfQuestions;
import com.jichuangsi.school.questionsrepository.exception.QuestionRepositoryServiceException;
import com.jichuangsi.school.questionsrepository.model.PageHolder;
import com.jichuangsi.school.questionsrepository.model.common.DeleteQueryModel;
import com.jichuangsi.school.questionsrepository.model.common.QuestionFile;
import com.jichuangsi.school.questionsrepository.model.common.SearchQuestionModel;
import com.jichuangsi.school.questionsrepository.model.common.SendCodePic;
import com.jichuangsi.school.questionsrepository.model.self.SelfQuestion;
import com.jichuangsi.school.questionsrepository.model.translate.PicContent;

public interface ISelfQuestionsRepositoryService {

    //上传问题图片
    void uploadQuestionPic(QuestionFile questionFile, SendCodePic sendCodePic) throws QuestionRepositoryServiceException;

    //下载问题图片
    QuestionFile downQuestionPic(UserInfoForToken userInfo, String fileName) throws QuestionRepositoryServiceException;

    //删除问题图片
    void deleteQuestionPic(UserInfoForToken userInfo, String fileName) throws QuestionRepositoryServiceException;

    //添加自定义
    void addSelfQuestion(UserInfoForToken userInfoForToken,SelfQuestion selfQuestion) throws QuestionRepositoryServiceException;

    //分页排序显示
    PageHolder<SelfQuestion> getSelfQuestionSortList(UserInfoForToken userInfoForToken, SearchQuestionModel searchQuestionModel);

    //获取指定自定义题目
    SelfQuestion getSelfQuestionById(UserInfoForToken userInfoForToken, String questionId) throws QuestionRepositoryServiceException;

    //根据id获取selfQuestions
    SelfQuestions getSelfQuestionsById(String id);

    //删除自定义
    void deleteSelfQuestion(UserInfoForToken userInfoForToken, SelfQuestions selfQuestions) throws QuestionRepositoryServiceException;

    //删除自定义
    void deleteSelfQuestions(UserInfoForToken userInfo,DeleteQueryModel deleteQueryModel) throws  QuestionRepositoryServiceException;

    PicContent transQuestionPic(SendCodePic sendCodePic) throws QuestionRepositoryServiceException;

    QuestionFile viewQuestionPic(SendCodePic sendCodePic) throws QuestionRepositoryServiceException;
}
