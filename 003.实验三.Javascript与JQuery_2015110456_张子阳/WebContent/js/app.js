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
	   $("#main1 td").mouseover(function() {     //当鼠标移过#nav li元素时
	        $(this).addClass("heightlight");        //为鼠标所在li元素添加样式
	   });
	   $("#main1 td").mouseout(function() {       //当鼠标移出#nav li元素时
	    $(this).removeClass();   //移除鼠标所在li元素的全部样式
	});
	});

$(document).ready(function() {
	   $("#main2 td").mouseover(function() {     //当鼠标移过#nav li元素时
	        $(this).addClass("heightlight");        //为鼠标所在li元素添加样式
	   });
	   $("#main2 td").mouseout(function() {       //当鼠标移出#nav li元素时
	    $(this).removeClass();   //移除鼠标所在li元素的全部样式
	});
	});

$(document).ready(function() {
	   $("#main3 td").mouseover(function() {     //当鼠标移过#nav li元素时
	        $(this).addClass("heightlight");        //为鼠标所在li元素添加样式
	   });
	   $("#main3 td").mouseout(function() {       //当鼠标移出#nav li元素时
	    $(this).removeClass();   //移除鼠标所在li元素的全部样式
	});
	});

$(document).ready(function() {
	   $("#main4 td").mouseover(function() {     //当鼠标移过#nav li元素时
	        $(this).addClass("heightlight");        //为鼠标所在li元素添加样式
	   });
	   $("#main4 td").mouseout(function() {       //当鼠标移出#nav li元素时
	    $(this).removeClass();   //移除鼠标所在li元素的全部样式
	});
	});

$(document).ready(function() {
	   $("#main5 td").mouseover(function() {     //当鼠标移过#nav li元素时
	        $(this).addClass("heightlight");        //为鼠标所在li元素添加样式
	   });
	   $("#main5 td").mouseout(function() {       //当鼠标移出#nav li元素时
	    $(this).removeClass();   //移除鼠标所在li元素的全部样式
	});
	});

$(document).ready(function() {
	   $("#main6 td").mouseover(function() {     //当鼠标移过#nav li元素时
	        $(this).addClass("heightlight");        //为鼠标所在li元素添加样式
	   });
	   $("#main6 td").mouseout(function() {       //当鼠标移出#nav li元素时
	    $(this).removeClass();   //移除鼠标所在li元素的全部样式
	});
	});


