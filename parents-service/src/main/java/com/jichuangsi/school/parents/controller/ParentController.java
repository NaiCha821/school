package com.jichuangsi.school.parents.controller;

import com.github.pagehelper.PageInfo;
import com.jichuangsi.microservice.common.model.ResponseModel;
import com.jichuangsi.microservice.common.model.UserInfoForToken;
import com.jichuangsi.school.parents.exception.ParentsException;
import com.jichuangsi.school.parents.model.*;
import com.jichuangsi.school.parents.model.http.HttpTokenModel;
import com.jichuangsi.school.parents.model.http.WxUserInfoModel;
import com.jichuangsi.school.parents.service.IParentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/parent")
@Api("关于家长端的controller")
@CrossOrigin
public class ParentController {

    @Resource
    private IParentService parentService;


    @ApiOperation(value = "发送家长留言", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @PostMapping(value = "/sendParentMessage")
    public ResponseModel sendParentMessage(@ModelAttribute UserInfoForToken userInfo, @RequestBody ParentMessageModel messageModel){
        try {
            parentService.sendParentMessage(userInfo, messageModel);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "查询家长端留言聊天记录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getParentMessage/{teacherId}/{pageIndex}/{pageSize}")
    public ResponseModel<PageInfo<ParentMessageModel>> getParentMessage(@ModelAttribute UserInfoForToken userInfo,@PathVariable String teacherId,@PathVariable int pageIndex,@PathVariable int pageSize){
        try {
            return ResponseModel.sucess("",parentService.getParentMessage(userInfo, teacherId, pageIndex, pageSize));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation(value = "家长端留言板", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @PostMapping(value = "/leaveParentMessageBoard")
    public ResponseModel leaveParentMessageBoard(@ModelAttribute UserInfoForToken userInfo,@RequestBody MessageBoardModel model){
        try {
            parentService.insertMessageBoard(userInfo, model);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "家长绑定学生", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/parentBindStudent/{studentAccount}")
    public ResponseModel parentBindStudent(@ModelAttribute UserInfoForToken userInfo,@PathVariable String studentAccount){
        try {
            parentService.bindStudent(userInfo, studentAccount);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "家长获取最新非删除通知", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/parentGetNewNotices")
    public ResponseModel<List<NoticeModel>> parentGetNewNotices(@ModelAttribute UserInfoForToken userInfo){
        try {
            return ResponseModel.sucess("",parentService.parentGetNewNotices(userInfo));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation(value = "家长删除通知", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @DeleteMapping(value = "/deleteParentNotice/{noticeId}")
    public ResponseModel deleteParentNotice(@ModelAttribute UserInfoForToken userInfo,@PathVariable String noticeId){
        try {
            parentService.deleteParentNotice(userInfo, noticeId);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

/*    @ApiOperation(value = "家长端通过微信openId登录，返回token(请求token为固定token即可)", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/loginParentService/{openId}")
    public ResponseModel<String> loginParentService(@ModelAttribute UserInfoForToken userInfo,@PathVariable String openId){
        try {
            return ResponseModel.sucess("",parentService.loginParentService(userInfo, openId));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }*/

    @ApiOperation(value = "家长端通过微信openId注册登录，返回token(请求token为固定token即可)", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @PostMapping(value = "/loginParentService")
    public ResponseModel<String> registParentService(@RequestBody ParentModel model){
        try {
            return ResponseModel.sucess("",parentService.registParentService(model)) ;
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation(value = "家长端设置账号密码,仅允许一次设置账号", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @PostMapping(value = "/setParentAccount")
    public ResponseModel setParentAccount(@ModelAttribute UserInfoForToken userInfo,@Validated @RequestBody ParentModel model){
        try {
            parentService.setParentAccount(userInfo, model);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "家长端修改密码", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @PostMapping(value = "/setParentNewPwd")
    public ResponseModel setParentNewPwd(@ModelAttribute UserInfoForToken userInfo, @Validated @RequestBody UpdatePwdModel model){
        try {
            parentService.setParentNewPwd(userInfo, model);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "家长端通过账号密码进行登录，返回token(请求token为固定token即可)", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @PostMapping(value = "/loginParentServiceByAccount")
    public ResponseModel loginParentServiceByAccount(@ModelAttribute UserInfoForToken userInfo,@RequestBody ParentModel model){
        try {
            return ResponseModel.sucess("",parentService.loginParentServiceByAccount(userInfo, model));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation(value = "家长端获取wx_token", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getWxToken/{code}")
    public ResponseModel<HttpTokenModel> getWxToken(@PathVariable String code){
        try {
            return ResponseModel.sucess("",parentService.findTokenByCode(code));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

/*    @ApiOperation(value = "家长端获取wx_token", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getWxToken2")
    public ResponseModel<HttpTokenModel> getWxToken2(){
        try {
            return ResponseModel.sucess("",parentService.findTokenByCode2());
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }*/

    @ApiOperation(value = "家长端获取家长端信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getParentInfo/{access_token}/{openid}")
    public ResponseModel<WxUserInfoModel> getParentInfo(@PathVariable String access_token, @PathVariable String openid/*,@PathVariable String code*/){
        try {
            return ResponseModel.sucess("",parentService.findWxUserInfo(access_token, openid/*,code*/));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

 /*   @ApiOperation(value = "家长端获取家长端信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getParentInfo2/{access_token}/{openid}")
    public ResponseModel<WxUserInfoModel> getParentInfo2(@PathVariable String access_token, @PathVariable String openid){
        try {
            return ResponseModel.sucess("",parentService.findWxUserInfo2(access_token, openid));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }*/


    @ApiOperation(value = "家长端绑定学生信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getBindStudentInfo")
    public ResponseModel getBindStudentInfo(@ModelAttribute UserInfoForToken userInfo){
        try {
            parentService.getBindStudentInfo(userInfo);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "家长端根据noticeId获取通知具体信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getNoticeByNoticeId/{noticeId}")
    public ResponseModel<NoticeModel> getNoticeByNoticeId(@ModelAttribute UserInfoForToken userInfo,@PathVariable String noticeId){
        try {
            return ResponseModel.sucess("",parentService.findNoticeDetails(userInfo, noticeId));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation(value = "家长取消绑定学生", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @DeleteMapping(value = "/deleteBindStudent/{studentId}")
    public ResponseModel deleteBindStudent(@ModelAttribute UserInfoForToken userInfo,@PathVariable String studentId){
        try {
            parentService.deleteBindStudent(userInfo, studentId);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

    @ApiOperation(value = "家长获取绑定信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @GetMapping(value = "/getParentBindInfo")
    public ResponseModel<Map<String,Boolean>> getParentBindInfo(@ModelAttribute UserInfoForToken userInfo){
        try {
            return ResponseModel.sucess("",parentService.getParentBindInfo(userInfo));
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
    }

    @ApiOperation(value = "家长绑定手机号，仅验证格式", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", value = "用户token", required = true, dataType = "String")
    })
    @PostMapping(value = "/bindParentPhone")
    public ResponseModel bindParentPhone(@ModelAttribute UserInfoForToken userInfo,@Validated @RequestBody ParentModel model){
        try {
            parentService.bindParentPhone(userInfo, model);
        } catch (ParentsException e) {
            return ResponseModel.fail("",e.getMessage());
        }
        return ResponseModel.sucessWithEmptyData("");
    }

}
