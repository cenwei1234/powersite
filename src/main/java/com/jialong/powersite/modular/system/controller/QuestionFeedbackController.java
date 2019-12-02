package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackAddResp;
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
}
