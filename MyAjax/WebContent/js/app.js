//获取省份名
 function showCustomer(str)
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
  xmlhttp.open("Get","listcity.asp?provName="+str);
  xmlhttp.send(null);
  }
//获取城市名
 function showCustomer2(str)
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
    	document.getElementById("txtHint2").innerHTML=xmlhttp.responseText;
    	}
    
    }
  //var str = $('#pid').attr('provId');
  //$(this).attr("provId",str);
  xmlhttp.open("Get","listdistrict.asp?cityName="+str);
  xmlhttp.send(null);
  }
 
 //获得区域名
 function showCustomer3(str)
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
 

 //var str = $('#pid').attr('provId');
 //$(this).attr("provId",str);
 xmlhttp.open("Get","getDistNameServlet.action?distName="+str);
 xmlhttp.send(null);
 }

