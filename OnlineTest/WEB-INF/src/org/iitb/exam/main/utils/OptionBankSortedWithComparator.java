/**
 * 
 */
package org.iitb.exam.main.utils;

import java.util.Comparator;

import org.iitb.exam.main.dto.OptionBank;

/**
 * @author deepak
 *
 */
public class OptionBankSortedWithComparator implements Comparator<OptionBank> {

	private int optionid;

	private int optionCorrectness;

	private String optionText;

	/**
	 * 
	 */
	public OptionBankSortedWithComparator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the optionid
	 */
	public int getOptionid() {
		return optionid;
	}

	/**
	 * @param optionid the optionid to set
	 */
	public void setOptionid(int optionid) {
		this.optionid = optionid;
	}

	/**
	 * @return the optionCorrectness
	 */
	public int getOptionCorrectness() {
		return optionCorrectness;
	}

	/**
	 * @param optionCorrectness the optionCorrectness to set
	 */
	public void setOptionCorrectness(int optionCorrectness) {
		this.optionCorrectness = optionCorrectness;
	}

	/**
	 * @return the optionText
	 */
	public String getOptionText() {
		return optionText;
	}

	/**
	 * @param optionText the optionText to set
	 */
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	@Override
	public int compare(OptionBank o1, OptionBank o2) {
		// TODO Auto-generated method stub
		return o1.getOptionId() - o2.getOptionId();
	}

}
