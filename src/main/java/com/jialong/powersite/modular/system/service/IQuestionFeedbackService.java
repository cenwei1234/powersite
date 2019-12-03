package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackDetailReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackListReq;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackAddResp;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackDetailResp;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackListResp;

public interface IQuestionFeedbackService {

    QuestionFeedbackAddResp addQuestionFeedback(QuestionFeedbackAddReq questionFeedbackAddReq, QuestionFeedbackAddResp questionFeedbackAddResp);

    QuestionFeedbackListResp queryQuestionFeedbackList(QuestionFeedbackListReq questionFeedbackListReq, QuestionFeedbackListResp questionFeedbackListResp);

    QuestionFeedbackDetailResp queryQuestionFeedbackById(QuestionFeedbackDetailReq questionFeedbackDetailReq, QuestionFeedbackDetailResp questionFeedbackDetailResp);
}
