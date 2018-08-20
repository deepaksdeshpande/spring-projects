package org.iitb.exam.main.dao;

import java.util.Set;

import org.iitb.exam.main.dto.Exam;

public interface CreateExamService {
	void createExam(Exam exam, Set<String> selectedQuestionIds, int desgId, int advtId);
//	void createExam(Exam exam);
	void createExamAndAdvtExamMapping(Exam exam, Set<String> selectedQuestionIds);
}
