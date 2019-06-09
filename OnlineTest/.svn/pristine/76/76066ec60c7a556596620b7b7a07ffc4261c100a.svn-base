<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="ckeditor" uri="http://ckeditor.com" %>
<!DOCTYPE html>
<script type="text/javascript" src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css" />
<script type="text/javascript">

var ctr = 4;
function addOption()
{
	if(ctr<6)
		{
		try
		{
			ctr++;
			var div = document.createElement("div");
			var label = document.createElement("span");
			var radioButton = document.createElement("input");
			var textbox = document.createElement("input");
			var removeButton = document.createElement("a");
			

			div.setAttribute("class", "checkbox")
			div.setAttribute("id", "div"+ctr)
			label.setAttribute("id", "span"+ctr)
			radioButton.setAttribute("type", "checkbox");
			radioButton.setAttribute("name", String.fromCharCode(64+ctr));
			radioButton.setAttribute("value", ctr);
			radioButton.setAttribute("id", "checkbox"+ctr);
			
			textbox.setAttribute("name", ""+ctr);
			textbox.setAttribute("type", "text");
			textbox.setAttribute("id","txt"+ctr);
			textbox.setAttribute("class", "form-control");
			textbox.setAttribute("placeholder", "Enter option "+ctr)
			
			
			
			
		}
		catch(err)
		{
			alert(err.message);
		}
		try
		{
	
			removeButton.setAttribute("href", "javascript:removeOption("+(ctr)+")");
			removeButton.setAttribute("id","remove"+(ctr));
			removeButton.setAttribute("class","glyphicon glyphicon-minus-sign");
			removeButton.setAttribute("style","width:20px;");
		}
		catch(err)
		{
			alert(err.message);
		}
		
		try
		{
			var before=document.getElementById("multipleadd");
			var par=before.parentNode;
			div.appendChild(label);
			div.appendChild(radioButton);
			div.appendChild(textbox);
			div.appendChild(removeButton);
			par.insertBefore(div,before);
			label.innerHTML=(String.fromCharCode(64+ctr));
			document.getElementById("count").value=ctr;
		}
		catch(err)
		{
			alert(err.message);
		}
	}
	else
	{
		alert("Options not more than 6!");
	}
}
function removeOption(opt)
{
	var i=0;
	//alert(ctr);
	if(ctr>4)
	{
		for(i=opt;i<ctr;i++)
		{	
			document.getElementById("txt"+i).value=document.getElementById("txt"+(i+1)).value;
			document.getElementById("checkbox"+i).checked = document.getElementById("checkbox"+(i+1)).checked;
		}
		try
		{
			//alert("Assigning!");
			var child1=document.getElementById("div"+ctr);
			var parent=document.getElementById("parent");
			parent.removeChild(child1);
			
				
		}
		catch(err)
		{
			alert("here---"+err.message);
		}

		ctr--;
		
		document.getElementById("count").value=ctr;
	}
	else
	{
		alert("Options must be more than 4!");
	}
}

</script>

<!-- <form name="multipleChoiceQuestionForm" method="post"> -->
	<div class="form-group">
		<label for="qtype" class="col-sm-4 control-label"><spring:message
				code="onlinetest.addquestion.qtext" /></label>
		<div class="col-sm-6">
			<textarea name="qText" id="qTextId" class="form-control" rows="4" cols="50" draggable="false" placeholder="Enter your Single Choice question here..."></textarea>
		</div>
		<ckeditor:replace replace="qText" basePath="./ckeditor/" />
	</div>
	
	<div class="form-group">
		<label for="options" class="col-sm-4 control-label"><spring:message
				code="onlinetest.addquestion.qoption" />
		</label><br />
		<div id="parent" class="col-sm-6">
			<div id="div1" class="checkbox">
				<span id="span1">A</span><input type="checkbox" name="A" id="checkbox1" value="A">
				 <input class="form-control" type="text" name="1" id="txt1" placeholder="Enter option 1"/>
				 <a  style="width:20px "class ="glyphicon glyphicon-minus-sign" id = "remove1" href="javascript:removeOption(1)"></a>
			</div>
			
			<div id="div2" class="checkbox">
				<span id="span2">B</span><input type="checkbox" name="B" id="checkbox2" value="B">
				 <input class="form-control" type="text" name="2" id="txt2" placeholder="Enter option 2" />
				 <a  style="width:20px "class ="glyphicon glyphicon-minus-sign" id = "remove2" href="javascript:removeOption(2)"></a>
			</div>
			
			<div id="div3" class="checkbox">
				<span id="span3">C</span><input type="checkbox" name="C" id="checkbox3" value="C">
				 <input class="form-control" type="text" name="3" id="txt3" placeholder="Enter option 3" />
				<a  style="width:20px "class ="glyphicon glyphicon-minus-sign" id = "remove3" href="javascript:removeOption(3)"></a>
			</div>
			
			<div id="div4" class="checkbox">
				<span id="span4">D</span><input type="checkbox" name="D" id="checkbox4" value="D">
				 <input class="form-control" type="text" name="4" id="txt4" placeholder="Enter option 4" />
				 <a style="width:20px "class ="glyphicon glyphicon-minus-sign" id = "remove4" href="javascript:removeOption(4)"></a>
			</div>
		
			<input type="hidden" id="count" name="count" value="4"/><br />
			
			<div  id= "multipleadd" class="form-group">
				<button class="btn btn-success" type="button" onclick = "addOption( );">
					<span class="glyphicon glyphicon-plus-sign"></span> Add Option
				</button>
			</div>
			
		</div>
	</div>
<!-- </form> -->