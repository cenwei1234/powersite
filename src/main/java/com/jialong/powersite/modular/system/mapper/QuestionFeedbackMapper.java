package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlQuestionFeedback;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionFeedbackMapper {

    Integer addQuestionFeedback(JlQuestionFeedback jlQuestionFeedback);
}
