package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlQuestionFeedback;
import com.jialong.powersite.modular.system.model.QuestionListQueryData;
import com.jialong.powersite.modular.system.model.response.data.QuestionFeedbackRespData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionFeedbackMapper {

    Integer addQuestionFeedback(JlQuestionFeedback jlQuestionFeedback);

    List<QuestionFeedbackRespData> queryFeedBackList(QuestionListQueryData questionListQueryData);

    Integer queryFeedBackListCount(QuestionListQueryData questionListQueryData);

    QuestionFeedbackRespData queryFeedBackDetailById(@Param("id") Integer id);
}
