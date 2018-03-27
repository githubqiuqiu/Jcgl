<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<!-- 引入JQuery -->
 <script type="text/javascript" src="jquery-easyui-1.5.2/jquery.min.js"></script>
 <!-- 引入EasyUI -->
 <script type="text/javascript" src="jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
 <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
 <script type="text/javascript" src="jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
 <!-- 引入EasyUI的样式文件-->
 <link rel="stylesheet" href="jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"/>
 <!-- 引入EasyUI的图标样式文件-->
 <link rel="stylesheet" href="jquery-easyui-1.5.2/themes/icon.css" type="text/css"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
	<script type="text/javascript">
	$(function(){
		$('#calendar').calendar({
		    current:new Date(),
		    weeks:['星期天','星期一','星期二','星期三','星期四','星期五','星期六'],
		    months:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
		});
	    $('#tabs').tabs({
	    	tools:[
	    	{
	    		iconCls:'icon-add',
	    		handler:function(){
	    			addTab("首 页", '#');
	    		}
	    	},{
	    		iconCls:'icon-reload',
	    		handler:function(){
    		       var index = $("#tabs").tabs('getTabIndex', $("#tabs").tabs('getSelected'));
    		       var tab = $("#tabs").tabs('getTab', index);
    		       var options = tab.panel('options');
    		       if (options.content) {
    		    	   $("#tabs").tabs('update', {
    		               tab: tab,
    		               options: {
    		                   content: options.content
    		               }
    		           });
    		       } else {
    		           tab.panel('refresh', options.href);
    		       }
	    		}
	    	},{
	    		iconCls:'icon-remove',
	    		handler:function(){
	    		    var tab = $('#tabs').tabs('getSelected');
	    		    var index = $('#tabs').tabs('getTabIndex',tab);
	    		    if(index!=0){
	    		    	$('#tabs').tabs('close',index);
	    		    }
	    		}
	    	}
	    	
	    	]
	    });
	});
    function addTab(title, url){
    	if ($('#tabs').tabs('exists', title)){
    		$('#tabs').tabs('select', title);
    	} else {
    		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
    		$('#tabs').tabs('add',{
    			title:title,
    			content:content,
    			closable:true,
    		});
    	}
    }
    //修改密码
    function editUserPwd(){
    	var id=$("#uid").val();
    	$('#winupdate').window('open');
    	$('#winupdate').window('refresh','ht/updatepwd.jsp?id='+id);
    }
	</script>
	
	<style type="text/css">
a{
	text-decoration: none;
}
	
</style>
	
</head>
<body class="easyui-layout">
	<div data-options="region:'north'"
		style="height: 62px">
	<input type="hidden" name="uid" id="uid" value="${user.id }"> 		
	 <table height="60px">
		<tr>
		<td width="800px"><img alt="" src="upload/htbg1.png"></td>
		<td valign="bottom">
				
		<div>
                <span style="float: right; padding-right: 20px; margin-top: 15px; color: #333">
                 
          	       欢迎您:<b> ${user.loginname }</b>&nbsp;&nbsp; 
                    <a href="javascript:void(0)" onclick="editUserPwd('+${user.id}+')" class="easyui-linkbutton" plain="true" icon="icon-lock" >修改密码</a>
                    &nbsp;&nbsp;
                    <a href="removeuser" id="removeuser" class="easyui-linkbutton" plain="true" icon="icon-no">安全退出</a>
                    <a href="index.action" class="easyui-linkbutton" plain="true" icon="icon-no">回到首页</a>
                </span>
                <span class="header"></span>
            </div>
		
		</td>
		</tr>
	</table> 	
		
	
		
			
		</div>
		
		
	<div data-options="region:'west',title:'菜单'"
		style="width: 150px" >
		<ul id="tt" class="easyui-tree" animate="true" dnd="false" lines="true">
			<li data-options="state:'closed'"><span>权限管理</span>
				<ul>
					<!-- ht/role.jsp -->
					<li><a href="#" onclick="addTab('角色管理','hasrolejur?jid=1')">角色管理</a></li>
					<!-- ht/usermanagement.jsp -->
					<li><a href="#" onclick="addTab('用户管理','hasuserjur?jid=2')">用户管理</a></li>
					<!-- ht/department.jsp -->
					<li><a href="#" onclick="addTab('部门管理','hasdepjur?jid=3')">部门管理</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>报名管理</span>
				<ul >
				<!-- ht/adultapply.jsp -->
					<li><a href="#" onclick="addTab('成考报名','hasadultjur?jid=4')">成考报名</a></li>
					
					<li><a href="#" onclick="addTab('会计报名','hasaccjur?jid=5')">会计报名</a></li>
					<!-- ht/stateapply.jsp -->
					<li><a href="#" onclick="addTab('国家开放报名','hasstatejur?jid=6')">国家开放报名</a></li>
					<!-- ht/distanceapply.jsp -->
					<li><a href="#" onclick="addTab('远程报名','hasdisjur?jid=7')">远程报名</a></li>
					<li><a href="#" onclick="addTab('艺考报名','hasartjur?jid=8')">艺考报名</a></li>
					<li><a href="#" onclick="addTab('职业资格报名','hasprojur?jid=9')">职业资格报名</a></li>
					<li><a href="#" onclick="addTab('文件上传/下载','hasfilejur?jid=10')">文件上传/下载</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>专业管理</span>
				<ul >
					<li><a href="#" onclick="addTab('专业管理','hasmajor?jid=11')">专业管理</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>热门专业</span>
				<ul >
					<li><a href="#" onclick="addTab('热门专业','hashotmajor?jid=12')">热门专业</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>招生简章</span>
				<ul >
					<li><a href="#" onclick="addTab('招生简章','haseguidejur?jid=13')">招生简章</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>日志监控</span>
				<ul >
					<li><a href="#" onclick="addTab('登陆日志','hasloginlogjur?jid=14')">登陆日志</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>系统设置</span>
				<ul >
					<li><a href="#" onclick="addTab('共享管理','hassharejur?jid=15')">共享管理</a></li>
					<li><a href="#" onclick="addTab('联系方式','hasrelationjur?jid=16')">联系方式</a></li>
					<li><a href="#" onclick="addTab('公告管理','hasnoticejur?jid=17')">公告管理</a></li>
					<li><a href="#" onclick="addTab('首页内容','hashomecontentjur?jid=18')">首页内容</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>工作助手</span>
				<ul>
				<!-- selsche  -->
					<li><a href="#" onclick="addTab('工作提醒','hasschedulejur?jid=19')">工作提醒</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>财务管理</span>
				<ul>
					<!-- ht/adultfinance.jsp -->
					<li><a href="#" onclick="addTab('成考缴费','hasadultfinancejur?jid=20')">成考缴费</a></li>
					<!-- ht/accountantfinance.jsp -->
					<li><a href="#" onclick="addTab('会计缴费','hasaccfinancejur?jid=21')">会计缴费</a></li>
					<!-- ht/statefinance.jsp -->
					<li><a href="#" onclick="addTab('国家开放缴费','hasstatefinancejur?jid=22')">国家开放缴费</a></li>
					<!-- ht/distancefinance.jsp -->
					<li><a href="#" onclick="addTab('远程缴费','hasdisfinancejur?jid=23')">远程缴费</a></li>
					<!-- ht/artfinance.jsp -->
					<li><a href="#" onclick="addTab('艺考缴费','hasartfinancejur?jid=24')">艺考缴费</a></li>
					<!-- ht/professionfinance.jsp -->
					<li><a href="#" onclick="addTab('职业资格缴费','hasprofinancejur?jid=25')">职业资格缴费</a></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>报表管理</span>
				<ul>
					<li><a href="#" onclick="addTab('报名统计报表','hasreportjur?jid=26')">报名统计报表</a></li>
					<li><a href="#" onclick="addTab('财务报表','hasfinancereportjur?jid=27')">财务报表</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs"  fit="true" style="background-color: #eee;">
			<div title="首 页" style="padding: 20px; display: none;">
			<table>
			<tr>
			<td><div id="calendar" style="width:450px;height:450px;"></div></td>
			<td><div style="width:100px;height:450px;"></div></td>
			<td valign="top">
			
					<font size="4"><p><b>今日工作安排:</b></p></font>
					<s:if test="listschedule!=null  ">
					<s:iterator value="listschedule">
					
					<p><font size="3">${stitle}、 ${scontent }</font></p>
					
					</s:iterator>
					</s:if>
					
					<s:if test="listschedule.size()==0">
					<p><font size="3">暂无工作安排</font></p>
					</s:if>
					
			</td>
			</tr>
			
			</table>
			
			
			
				
			
			</div>
		</div>
	</div>
	
	<!-- 修改密码窗口 -->
    	<div id="winupdate" class="easyui-window" 
		title="修改密码" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:350px;height:200px;padding:5px;">
		</div>
	
</body>
</html>