package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.QuestionFeedbackMapper;
import com.jialong.powersite.modular.system.model.JlQuestionFeedback;
import com.jialong.powersite.modular.system.model.QuestionListQueryData;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackDetailReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackListReq;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackAddResp;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackDetailResp;
import com.jialong.powersite.modular.system.model.response.QuestionFeedbackListResp;
import com.jialong.powersite.modular.system.model.response.data.QuestionFeedbackRespData;
import com.jialong.powersite.modular.system.service.IQuestionFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public QuestionFeedbackListResp queryQuestionFeedbackList(QuestionFeedbackListReq questionFeedbackListReq, QuestionFeedbackListResp questionFeedbackListResp) {

        QuestionListQueryData questionListQueryData = new QuestionListQueryData();
        questionListQueryData.setLevel(questionFeedbackListReq.getLevel());
        questionListQueryData.setSiteId(questionFeedbackListReq.getSiteId());
        questionListQueryData.setReportor(questionFeedbackListReq.getReportor());
        questionListQueryData.setReportStartTime(questionFeedbackListReq.getReportStartTime());
        questionListQueryData.setReportEndTime(questionFeedbackListReq.getReportEndTime());
        questionListQueryData.setStart(questionFeedbackListReq.getStart(questionFeedbackListReq.getPageNo()));
        questionListQueryData.setPageSize(questionFeedbackListReq.getPageSize());

        List<QuestionFeedbackRespData> questionFeedbackListRespData = this.questionFeedbackMapper.queryFeedBackList(questionListQueryData);

        Integer totalCount = this.questionFeedbackMapper.queryFeedBackListCount(questionListQueryData);

        questionFeedbackListResp.setTotalCount(totalCount);
        questionFeedbackListResp.setData(questionFeedbackListRespData);
        return questionFeedbackListResp;
    }

    @Override
    public QuestionFeedbackDetailResp queryQuestionFeedbackById(QuestionFeedbackDetailReq questionFeedbackDetailReq, QuestionFeedbackDetailResp questionFeedbackDetailResp) {
        QuestionFeedbackRespData questionFeedbackListRespData = questionFeedbackMapper.queryFeedBackDetailById(questionFeedbackDetailReq.getId());
        questionFeedbackDetailResp.setData(questionFeedbackListRespData);
        return questionFeedbackDetailResp;
    }
}
