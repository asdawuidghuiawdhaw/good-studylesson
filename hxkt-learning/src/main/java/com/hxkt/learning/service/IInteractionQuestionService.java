package com.hxkt.learning.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxkt.common.domain.dto.PageDTO;
import com.hxkt.learning.domain.dto.QuestionFormDTO;
import com.hxkt.learning.domain.po.InteractionQuestion;
import com.hxkt.learning.domain.query.QuestionAdminPageQuery;
import com.hxkt.learning.domain.query.QuestionPageQuery;
import com.hxkt.learning.domain.vo.QuestionAdminVO;
import com.hxkt.learning.domain.vo.QuestionVO;

/**
 * <p>
 * 互动提问的问题表 服务类
 * </p>
 *
 * @author 虎哥
 */
public interface IInteractionQuestionService extends IService<InteractionQuestion> {

    void saveQuestion(QuestionFormDTO questionDTO);

    PageDTO<QuestionVO> queryQuestionPage(QuestionPageQuery query);

    QuestionVO queryQuestionById(Long id);

    PageDTO<QuestionAdminVO> queryQuestionPageAdmin(QuestionAdminPageQuery query);

    QuestionAdminVO queryQuestionByIdAdmin(Long id);

    void hiddenQuestion(Long id, Boolean hidden);

    void updateQuestion(Long id, QuestionFormDTO questionDTO);

    void deleteById(Long id);
}
