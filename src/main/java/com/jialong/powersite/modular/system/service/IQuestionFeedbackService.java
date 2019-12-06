package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackDetailReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackListReq;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.QuestionFeedbackRespData;

public interface IQuestionFeedbackService {

    BaseResp addQuestionFeedback(QuestionFeedbackAddReq questionFeedbackAddReq, BaseResp baseResp);

    BaseListResp queryQuestionFeedbackList(QuestionFeedbackListReq questionFeedbackListReq, BaseListResp<QuestionFeedbackRespData> baseListResp);

    BaseBeanResp queryQuestionFeedbackById(QuestionFeedbackDetailReq questionFeedbackDetailReq, BaseBeanResp<QuestionFeedbackRespData> baseBeanResp);
}
