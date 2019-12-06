package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackDetailReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackListReq;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.QuestionFeedbackRespData;
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
    public BaseResp addQuestionFeedback(@RequestBody QuestionFeedbackAddReq questionFeedbackAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return questionFeedbackService.addQuestionFeedback(questionFeedbackAddReq, baseResp);
    }

    @RequestMapping("/list")
    public BaseListResp addQuestionFeedback(@RequestBody QuestionFeedbackListReq questionFeedbackListReq)
    {
        BaseListResp<QuestionFeedbackRespData> baseListResp = new BaseListResp<>();
        return questionFeedbackService.queryQuestionFeedbackList(questionFeedbackListReq, baseListResp);
    }

    @RequestMapping("/detail")
    public BaseBeanResp queryQuestionFeedbackById(@RequestBody QuestionFeedbackDetailReq questionFeedbackDetailReq)
    {
        BaseBeanResp<QuestionFeedbackRespData> baseBeanResp = new BaseBeanResp<>();
        return questionFeedbackService.queryQuestionFeedbackById(questionFeedbackDetailReq, baseBeanResp);
    }
}
