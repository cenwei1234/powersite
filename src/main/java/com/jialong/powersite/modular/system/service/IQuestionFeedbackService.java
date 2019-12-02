package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackAddResp;

public interface IQuestionFeedbackService {

    QuestionFeedbackAddResp addQuestionFeedback(QuestionFeedbackAddReq questionFeedbackAddReq, QuestionFeedbackAddResp questionFeedbackAddResp);
}
