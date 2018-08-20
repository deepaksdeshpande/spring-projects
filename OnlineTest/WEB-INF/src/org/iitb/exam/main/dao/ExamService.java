package org.iitb.exam.main.dao;

import java.util.ArrayList;

import org.iitb.exam.main.dto.Exam;
import org.iitb.exam.main.wrappers.Question;

public interface ExamService {
	Exam getExamDetails(int advtId,int desgnId);
	ArrayList<Question> getExamQuestions(int examId);
	String getDesignationName(String desgnId);

}
