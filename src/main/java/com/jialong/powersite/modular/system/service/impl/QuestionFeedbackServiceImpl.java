package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.QuestionFeedbackMapper;
import com.jialong.powersite.modular.system.model.JlQuestionFeedback;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackAddResp;
import com.jialong.powersite.modular.system.service.IQuestionFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionFeedbackServiceImpl implements IQuestionFeedbackService
{

    @Autowired
    private QuestionFeedbackMapper questionFeedbackMapper;

    @Override
    public QuestionFeedbackAddResp addQuestionFeedback(QuestionFeedbackAddReq questionFeedbackAddReq, QuestionFeedbackAddResp questionFeedbackAddResp) {

        JlQuestionFeedback jlQuestionFeedback = new JlQuestionFeedback();
        jlQuestionFeedback.setLevel(questionFeedbackAddReq.getLevel());
        jlQuestionFeedback.setSiteId(questionFeedbackAddReq.getSiteId());
        jlQuestionFeedback.setDescription(questionFeedbackAddReq.getDescription());
        jlQuestionFeedback.setImage(questionFeedbackAddReq.getImage());
        jlQuestionFeedback.setReportor(questionFeedbackAddReq.getReportor());
        this.questionFeedbackMapper.addQuestionFeedback(jlQuestionFeedback);
        return questionFeedbackAddResp;
    }
}
