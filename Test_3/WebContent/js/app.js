//获取省份名
 function showMessage(str)
  {
  var xmlhttp;  
 
 
  if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
    }
  else
    {// code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  
  xmlhttp.onreadystatechange=function(){
    if (xmlhttp.readyState==4 && xmlhttp.status==200){
    	document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    	}
    
    }
  //var str = $('#pid').attr('provId');
  //$(this).attr("provId",str);
  xmlhttp.open("Get","getmessage.action?username="+str);
  xmlhttp.send(null);
  }