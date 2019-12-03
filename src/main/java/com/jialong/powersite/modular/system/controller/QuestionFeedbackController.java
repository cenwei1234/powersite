package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackDetailReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackListReq;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackAddResp;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackDetailResp;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackListResp;
import com.jialong.powersite.modular.system.service.IQuestionFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/question")
public class QuestionFeedbackController {

    @Autowired
    private IQuestionFeedbackService questionFeedbackService;

    @RequestMapping("/add")
    public QuestionFeedbackAddResp addQuestionFeedback(@RequestBody QuestionFeedbackAddReq questionFeedbackAddReq)
    {
        QuestionFeedbackAddResp questionFeedbackAddResp = new QuestionFeedbackAddResp();
        return questionFeedbackService.addQuestionFeedback(questionFeedbackAddReq, questionFeedbackAddResp);
    }

    @RequestMapping("/list")
    public QuestionFeedbackListResp addQuestionFeedback(@RequestBody QuestionFeedbackListReq questionFeedbackListReq)
    {
        QuestionFeedbackListResp questionFeedbackListResp = new QuestionFeedbackListResp();
        return questionFeedbackService.queryQuestionFeedbackList(questionFeedbackListReq, questionFeedbackListResp);
    }

    @RequestMapping("/detail")
    public QuestionFeedbackDetailResp queryQuestionFeedbackById(@RequestBody QuestionFeedbackDetailReq questionFeedbackDetailReq)
    {
        QuestionFeedbackDetailResp questionFeedbackDetailResp = new QuestionFeedbackDetailResp();
        return questionFeedbackService.queryQuestionFeedbackById(questionFeedbackDetailReq, questionFeedbackDetailResp);
    }
}
