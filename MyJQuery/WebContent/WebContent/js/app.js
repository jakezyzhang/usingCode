$(document).ready(function() {
	$("#btnSubmit").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit").html());
	});
});

$(document).ready(function() {
	$("#btnSubmit2").bind("click", function() { //检测按钮事件
		sys_Alert("添加笔记");
	});
});

$(document).ready(function() {
	$("#btnSubmit3").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit3").html());
	});
});

$(document).ready(function() {
	$("#btnSubmit4").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit4").html());
	});
});

$(document).ready(function() {
	$("#btnSubmit5").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit5").html());
	});
});

$(document).ready(function() {
	$("#btnSubmit6").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit6").html());
	});
});

$(document).ready(function() {
	$("#btnSubmit7").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit7").html());
	});
});

$(document).ready(function() {
	$("#btnSubmit8").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit8").html());
	});
});

$(document).ready(function() {
	$("#btnSubmit9").bind("click", function() { //检测按钮事件
		sys_Alert($("#btnSubmit9").html());
	});
});

function sys_Alert(content) { //弹出提示信息窗口
	        $("#dialog-non-modal").dialog({
	            height: 140,
	            modal: false,
	            title: '系统提示',
	            hide: 'slide',
	            buttons: {
	                '确定': function() {
	                   
	                    $(this).dialog("close");
	                },
	                '取消': function() {
	                    $(this).dialog("close");
	                }
	            },
	            open: function(event, ui) {
	                $(this).html("");
	                $(this).append(content);
	            }
	        });
	    }

$(document).ready(function() {
	   $("#main1 td").mouseover(function() {     //当鼠标移过#main1 td元素时
	        $(this).addClass("heightlight");        //为鼠标所在td元素添加样式
	   });
	   $("#main1 td").mouseout(function() {       //当鼠标移出#main1 td元素时
	    $(this).removeClass();   //移除鼠标所在td元素的全部样式
	});
	});

$(document).ready(function() {
	   $("#main2 td").mouseover(function() {     
	        $(this).addClass("heightlight");       
	   });
	   $("#main2 td").mouseout(function() {       
	    $(this).removeClass();   
	});
	});

$(document).ready(function() {
	   $("#main3 td").mouseover(function() {     
	        $(this).addClass("heightlight");       
	   });
	   $("#main3 td").mouseout(function() {       
	    $(this).removeClass();   
	});
	});

$(document).ready(function() {
	   $("#main4 td").mouseover(function() {    
	        $(this).addClass("heightlight");        
	   });
	   $("#main4 td").mouseout(function() {       
	    $(this).removeClass();   
	});
	});

$(document).ready(function() {
	   $("#main5 td").mouseover(function() {    
	        $(this).addClass("heightlight");        
	   });
	   $("#main5 td").mouseout(function() {       
	    $(this).removeClass();   
	});
	});

$(document).ready(function() {
	   $("#main6 td").mouseover(function() {     
	        $(this).addClass("heightlight");        
	   });
	   $("#main6 td").mouseout(function() {      
	    $(this).removeClass();   
	});
	});


//定义数据保存图片路径
var arrImg = new Array("img/jdk.jpg","img/Tomcat.jpg","img/MySQL.jpg","img/xampp.jpg","img/eclipse.jpg","img/eclipse web.jpg");
$(function() {
    //遍历所有列表选项
    $(".spanL").each(function(index) {
        //增加title属性
         $(this).attr("title", "<img src='" + arrImg[index] + "'></img>");
        $(this).tooltip({ 
	position: { my: "left+100"} 
});
    });
});

//全选功能
$(document).ready(function() {
	 $("#allget").click(function(){
		  $("td").css("background-color","#09F");//改变含有td属性背景颜色
		 // $("input:checkbox").attr("checked",true);
		
	 });
});
//取消功能
$(document).ready(function() {
	 $("#allout").click(function(){
		  $("td").css("background-color","");//改变含有td属性背景颜色
		//  $("input:checkbox").attr("checked",false);
		
	 });
}); 
//$(document).ready(function () {
//    $("#allget").click(function () {
//    $(":checkbox").attr("checked",true);
//    })
//    $("#allout").click(function () {
//        $(":checkbox").attr("checked",false);
//    })
//})
