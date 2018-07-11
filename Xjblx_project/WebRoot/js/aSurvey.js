$(document).ready( function(){
	var que_num = 5;
	var que_index;
	
	for(que_index = 1;que_index < que_num;que_index++){
		var text = que_index + "weqr"
		
		var html_que = "<span>" + text + "<span/> <ul class='que' id='que" + que_index + "'></ul>"
		document.getElementById("showSurvey").innerHTML += html_que;
		
		var result = "kjsdhajksd;dsfsdfasd;gffd;sddsf;asdsad;asdasdas。";//问题答案
	
		var answer_index = 0;
		var choice = '';
		var choice_index = 1;

		var type = "radio";
		
		var name = answer_index+type;
		while(result[answer_index] != '。') {
			if(result[answer_index] == ';') {
				var newNode = "<li><label><input type='" + type + "' name='" + name + "' />" + choice + "</label></li>";
				document.getElementById("que"+que_index).innerHTML += newNode;
				choice = '';
				choice_index++;
				answer_index++;
			}
			choice += result[answer_index];
			answer_index++;
		}
		var newNode = "<li><label><input type='" + type + "' name='" + name+ "' />" + choice + "</label></li>";
		document.getElementById("que"+que_index).innerHTML += newNode;
		choice = '';
		choice_index++;
		answer_index++;
		
	}
})