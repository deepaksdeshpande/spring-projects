//
//	jQuery Validate example script
//
//	Prepared by David Cochran
//
//	Free for your use -- No warranties, no guarantees!
//

$(document).ready(
		function() {

			// Validate
			// http://bassistance.de/jquery-plugins/jquery-plugin-validation/
			// http://docs.jquery.com/Plugins/Validation/
			// http://docs.jquery.com/Plugins/Validation/validate#toptions

			$('#addquestionform').validate(
					{
						rules : {
							examName : {
								minlength : 2,
								maxlength : 50,
								required : true
							},
							email : {
								required : true,
								email : true
							},
							subject : {
								minlength : 2,
								required : true
							},
							message : {
								minlength : 2,
								required : true
							},
							duration : {
								digits : true,
								minlength : 2,
								required : true
							},
							addQuestionCategoryId : {
								minlength : 2,
								maxlength : 100,
								required : true
							},
							qpoolforadvtid : {
								required : true
							},
							lodid : {
								required : true
							},
							qtypeid : {
								required : true
							},
							qTextId : {
								required : true
							},
							txt1 : {
								minlength : 100,
								required : true
							},
							txt2 : {
								minlength : 100,
								required : true
							},
							txt3 : {
								minlength : 100,
								required : true
							},
							txt4 : {
								minlength : 100,
								required : true
							},
							txt5 : {
								minlength : 100
							},
							txt6 : {
								minlength : 100
							}
						},
						highlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'success').addClass('error');
						},
						success : function(element) {
							element.text('OK!').addClass('valid').closest(
									'.form-group').removeClass('error')
									.addClass('success');
						}
					});

			
			$('#addQuesForm').validate(
					{
						rules : {
							addQuestionTag : {
								minlength : 2,
								maxlength : 50,
								required : true
							}
//							duration : {
//								digits : true,
//								minlength : 2,
//								required : true
//							}
						},
						highlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'success').addClass('error');
						},
						success : function(element) {
							element.text('OK!').addClass('valid').closest(
									'.form-group').removeClass('error')
									.addClass('success');
						}
					});

		
		}); // end document.ready
