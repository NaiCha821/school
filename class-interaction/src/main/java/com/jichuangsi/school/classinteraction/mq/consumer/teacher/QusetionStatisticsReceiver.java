/**
 * 接收题目统计变更消息
 */
package com.jichuangsi.school.classinteraction.mq.consumer.teacher;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.jichuangsi.school.classinteraction.mq.consumer.AbstractReceiver;
import com.jichuangsi.school.classinteraction.websocket.model.QuestionStatistics;
import com.jichuangsi.school.classinteraction.websocket.service.ISendToTeacherService;

/**
 * @author huangjiajun
 *
 */
@Component
public class QusetionStatisticsReceiver extends AbstractReceiver {
	@Resource
	private ISendToTeacherService sendToTeacherService;

	@Override
	public void process(String jsonData) {
		QuestionStatistics info = JSONObject.parseObject(jsonData, QuestionStatistics.class);
		sendToTeacherService.sendQuestionStatisticsInfo(info);
	}

	@Override
	@RabbitListener(queuesToDeclare = {
			@Queue(value = "${custom.mq.consumer.queue-name.question-statistics}") })
	public void processWithLog(String jsonData) {
		super.processWithLog(jsonData);
	}
}
