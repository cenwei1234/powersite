package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.QuestionFeedbackMapper;
import com.jialong.powersite.modular.system.model.JlQuestionFeedback;
import com.jialong.powersite.modular.system.model.QuestionListQueryData;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackAddReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackDetailReq;
import com.jialong.powersite.modular.system.model.request.QuestionFeedbackListReq;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
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
    public BaseResp addQuestionFeedback(QuestionFeedbackAddReq questionFeedbackAddReq, BaseResp baseResp) {

        JlQuestionFeedback jlQuestionFeedback = new JlQuestionFeedback();
        jlQuestionFeedback.setLevel(questionFeedbackAddReq.getLevel());
        jlQuestionFeedback.setSiteId(questionFeedbackAddReq.getSiteId());
        jlQuestionFeedback.setDescription(questionFeedbackAddReq.getDescription());
        jlQuestionFeedback.setImage(questionFeedbackAddReq.getImage());
        jlQuestionFeedback.setReportor(questionFeedbackAddReq.getReportor());
        this.questionFeedbackMapper.addQuestionFeedback(jlQuestionFeedback);
        return baseResp;
    }

    @Override
    public BaseListResp queryQuestionFeedbackList(QuestionFeedbackListReq questionFeedbackListReq, BaseListResp<QuestionFeedbackRespData> baseListResp) {

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

        baseListResp.setTotalCount(totalCount);
        baseListResp.setData(questionFeedbackListRespData);
        return baseListResp;
    }

    @Override
    public BaseBeanResp queryQuestionFeedbackById(QuestionFeedbackDetailReq questionFeedbackDetailReq, BaseBeanResp<QuestionFeedbackRespData> baseBeanResp) {
        QuestionFeedbackRespData questionFeedbackListRespData = questionFeedbackMapper.queryFeedBackDetailById(questionFeedbackDetailReq.getId());
        baseBeanResp.setData(questionFeedbackListRespData);
        return baseBeanResp;
    }
}
