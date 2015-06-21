$(document).ready(function(){
	$('#submitbutton').click(function(){
		var username=$('#username').val();
		var password=$('#password').val();
		showUserNamePassword(username,password);
		});
})

function showUserNamePassword(usernamevar,passwordvar){
	//callServer();
	postData();
}

function callServer(){
	$.ajax({url:"http://192.168.0.7:8080/VideoSvc/anurag/postData",data:stringDataToBeSent,type:"POST",error:postError,contentType:"application/json"});
	
}

function ajaxSuccess(result){
 alert("Ajax call was a success");
 var resultOfCall= JSON.parse(result);
 alert("The value of description is"+resultOfCall.description);
}

function ajaxFailure(){
	alert("Ajax call was a failure");
}

function postData(){
	var username=$('#username').val();
	var password=$('#password').val();
	var dataToBeSent={

			"username":username,
			"password":password
	};
	var stringDataToBeSent=JSON.stringify(dataToBeSent);
	$.ajax({url:"http://192.168.0.7:8080/VideoSvc/anurag/postData",data:stringDataToBeSent,type:"POST",error:postError,contentType:"application/json"});
}

function postError(jqXHR,textStatus,errorThrown){
	alert("There was an error in posting data"+errorThrown);
}