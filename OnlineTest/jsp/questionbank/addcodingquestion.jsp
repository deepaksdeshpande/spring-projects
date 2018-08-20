<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="ckeditor" uri="http://ckeditor.com" %>
<!DOCTYPE html>
<script type="text/javascript" src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css" />

<!-- <script type="text/javascript">
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
			

			div.setAttribute("class", "radio")
			div.setAttribute("id", "div"+ctr)
			label.setAttribute("id", "span"+ctr)
			radioButton.setAttribute("type", "radio");
			radioButton.setAttribute("name", "option");
			radioButton.setAttribute("value", ctr);
			radioButton.setAttribute("id", "radio"+ctr);
			
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
			var before=document.getElementById("singleadd");
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
			document.getElementById("radio"+i).checked = document.getElementById("radio"+(i+1)).checked;
		}
		try
		{
		//	alert("Assigning!");
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

</script> -->

	<div class="form-group">
		<label for="qtype" class="col-sm-4 control-label"><spring:message
				code="onlinetest.addquestion.qtext" /></label>
		<div class="col-sm-6">
			<textarea name="qText" id="qTextId" class="form-control" rows="6" cols="50" draggable="false" placeholder="Enter your Single Choice question here..."></textarea>
		</div>
		<ckeditor:replace replace="qText" basePath="./ckeditor/" />
	</div>