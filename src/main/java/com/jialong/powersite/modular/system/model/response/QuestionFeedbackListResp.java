package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.QuestionFeedbackRespData;

import java.util.List;

public class QuestionFeedbackListResp extends BaseResp{

    private List<QuestionFeedbackRespData> data;

    public List<QuestionFeedbackRespData> getData() {
        return data;
    }

    public void setData(List<QuestionFeedbackRespData> data) {
        this.data = data;
    }
}
