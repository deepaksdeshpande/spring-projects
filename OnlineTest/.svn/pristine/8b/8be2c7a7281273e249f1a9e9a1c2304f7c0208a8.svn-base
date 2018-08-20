function validateCreateExamForm() {
	var result = true;
	var examName = document.createexamForm.examName.value;
	var examDate = document.createexamForm.examDate.value;
	var examDuration = document.createexamForm.examDuration.value;
	var totalQuestion = document.createexamForm.totalQuestion.value;
	if (!isStringInRange(examName, 5, 30) && !isExamAlphabet(examName)) {
		document.createexamForm.examNameWrong.style.display = "block";
		document.createexamForm.examNameCorrect.style.display = "none";
		result = false;
	} else {
		document.createexamForm.examNameCorrect.style.display = "block";
		document.createexamForm.examNameWrong.style.display = "none";
		result = true;
	}
	return false;
}

/* to check white space and remove */
function alltrim(str) {
	return str.replace(/^\s+|\s+$/g, '');
}

function isExamAlphabet(str) {
	var result = false;
	var alphaExp = /^[a-zA-Z ][a-zA-Z\_ ]+$/;
	if (str.match(alphaExp)) {
		result = true;
	}
	return result;
}

function isStringInRange(str, minLength, maxLength) {
	var result = false;
	if (str.length >= minLength && str.length <= maxLength) {
		result = true;
	}
	return result;
}