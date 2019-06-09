$(document)
		.ready(
				function() {
					$("#registrationFormId")
							.validate(
									{
										rules : {
											name : {
												required : true,
												minlength : 3,
												maxlength : 20,
												regexName : /^[a-zA-Z][a-zA-Z\. ]+[a-zA-Z]+$/
											},
											age : {
												required : true,
												minlength : 2,
												maxlength : 2
											},
											email : {
												required : true,
												email : true
											},
											username : {
												required : true,
												minlength : 3,
												maxlength : 15,
												regUsrName : /^(?!.*__.*)[_a-zA-Z]+$/
											},
											password : {
												required : true,
												minlength : 6
											},
											confirmpassword : {
												required : true,
												minlength : 6,
												equalTo : "#password"
											}
										},
										messages : {
											name : {
												required : "Please enter your name",
												minlength : "Your name should be of atleast 3 characters",
												maxlength : "Your name should be of atmost 20 characters",
												regexName : "Only aphabets are allowed"
											},
											age : {
												required : "Please enter your age",
												minlength : "Your age should be of 2 digits",
												maxlength : "Your age should be of 2 digits",
//												regage : "Enter valid age value."
											},
											email : "Please enter a valid email address",
											username : {
												required : "Please enter a username",
												minlength : "Your username must consist of at least contains 3-10 characters",
												maxlength : "Your name should be of atmost 10 characters",
												regUsrName : "Invalid username"
											},
											password : {
												required : "Please provide a password",
												minlength : "Your password must be at least 6 characters long"
											},
											confirmpassword : {
												required : "Please re-enter your password",
												minlength : "Your password must be at least 6 characters long",
												equalTo : "Please enter the same password as above"
											}
										},
										highlight : function(element) {
											$(element).closest('.form-group')
													.removeClass('has-success')
													.addClass('has-error');
										},
										unhighlight : function(element) {
											$(element).closest('.form-group')
													.removeClass('has-error')
													.addClass('has-success');
										}
									});
					$.validator.addMethod("regexName", function(value, element,
							regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					});
					$.validator.addMethod("regUsrName", function(value,
							element, regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					});
					$.validator.addMethod("regage", function(value,
							element, regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					});
				});