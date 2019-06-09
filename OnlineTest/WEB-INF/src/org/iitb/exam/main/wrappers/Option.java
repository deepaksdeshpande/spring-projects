package org.iitb.exam.main.wrappers;

public class Option {

	/**
	 * This class is used to set and get the details of option belongs to
	 * particular question
	 * 
	 * @author dipti
	 */
	
	/*
	 * @param OptionID- For storing optionID of option
	 * @param OptionValue - For storing Option text
	 * @param QuestionID -For storing QuestionID to which option belongs
	 * @param CorrectnessAndOrder -For Storing correctness and oder of sequencing question
	 */
	private int OptionID;
	private String OptionValue;
	private int QuestionID;
	private int CorrectnessAndOrder;
	
	/**
	 * @return the optionID
	 */
	public int getOptionID() {
		return OptionID;
	}
	/**
	 * @param optionID the optionID to set
	 */
	public void setOptionID(int optionID) {
		OptionID = optionID;
	}
	/**
	 * @return the optionValue
	 */
	public String getOptionValue() {
		return OptionValue;
	}
	/**
	 * @param optionValue the optionValue to set
	 */
	public void setOptionValue(String optionValue) {
		OptionValue = optionValue;
	}
	/**
	 * @return the questionID
	 */
	public int getQuestionID() {
		return QuestionID;
	}
	/**
	 * @param questionID the questionID to set
	 */
	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}
	/**
	 * @return the correctnessAndOrder
	 */
	public int getCorrectnessAndOrder() {
		return CorrectnessAndOrder;
	}
	/**
	 * @param correctnessAndOrder the correctnessAndOrder to set
	 */
	public void setCorrectnessAndOrder(int correctnessAndOrder) {
		CorrectnessAndOrder = correctnessAndOrder;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Option [OptionID=" + OptionID + ", OptionValue=" + OptionValue
				+ ", QuestionID=" + QuestionID + ", CorrectnessAndOrder="
				+ CorrectnessAndOrder + "]";
	}
	
	
}
