package org.iitb.exam.main.dao;

import java.util.Set;

import org.iitb.exam.main.dto.QuestionBank;

public interface QuestionBankService {
	Set<QuestionBank> fetchRandomQuestions();
}
