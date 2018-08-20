package org.iitb.exam.main.dao;

import java.util.ArrayList;

import org.iitb.exam.main.dto.QuestionBank;

public interface GetQuestionsAdvtandDesgService {
	public ArrayList<QuestionBank> getQuestionsBasedOnAdvtandDesg(int advtId, int desgId);
}
