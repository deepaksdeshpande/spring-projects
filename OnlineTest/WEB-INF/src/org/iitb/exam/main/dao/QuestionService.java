/**
 * 
 */
package org.iitb.exam.main.dao;

import java.util.List;

import org.iitb.exam.main.dto.OptionBank;
import org.iitb.exam.main.dto.QuestionBank;

/**
 * @author deepak
 *
 */
public interface QuestionService {
	void addQuestion(QuestionBank questionBank, List<OptionBank> optionBank);
	List<QuestionBank> displayAllAddedQuestions();

	QuestionBank fetchSingleChoiceQuestionForEdit(int questionId);
	
	void updateSingleChoiceQuestionById(int questionId, 
			int levelOfDifficulty, int shuffle, int archived,
			String questionText, int optionId,
			int optionCorrectness, String OptionText);
}
