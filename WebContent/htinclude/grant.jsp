<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="link.jsp"></s:include>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
// 处理全选  
document.getElementById('checkall').onclick=function(){  
    // 获取所有的复选框  
    var checkElements=document.getElementsByName('jid');  
    
    for(var i=0;i<checkElements.length;i++){  
    	 
        var checkElement=checkElements[i];  
        // 方法一  
       //checkElement.setAttribute('checked',' checked');  
        // 方法二  
       checkElement.checked="checked";  
    }  
}

// 处理全不选  
document.getElementById('checkNo').onclick=function(){  

    // 获取所有的复选框  
    var checkElements=document.getElementsByName('jid');  
  
    for(var i=0;i<checkElements.length;i++){  
        var checkElement=checkElements[i];  
        // 方法一火狐不支持  
       	 	//checkElement.setAttribute('checked',null);  
        // 方法二 火狐和ie都支持  
       checkElement.checked=null;  
    }  
}  


</script>

</head>
<body class="easyui-layout">

这是授权页面
${param.rid } 

<form action="grant.action" method="post"> 
<input type="hidden" name="rid" value="${param.rid }">
<input type="hidden" name="xid" value="${id[0] }">
<input type="hidden" name="xid" value="${id[1] }">
<input type="hidden" name="xid" value="${id[2] }">
<input type="hidden" name="xid" value="${id[3] }">
<input type="hidden" name="xid" value="${id[4] }">
<input type="hidden" name="xid" value="${id[5] }">
<input type="hidden" name="xid" value="${id[6] }">
<input type="hidden" name="xid" value="${id[7] }">
<input type="hidden" name="xid" value="${id[8] }">
<input type="hidden" name="xid" value="${id[9] }">
<input type="hidden" name="xid" value="${id[10] }">
<input type="hidden" name="xid" value="${id[11] }">
<input type="hidden" name="xid" value="${id[12] }">
<input type="hidden" name="xid" value="${id[13] }">
<input type="hidden" name="xid" value="${id[14] }">
<input type="hidden" name="xid" value="${id[15] }">
<input type="hidden" name="xid" value="${id[16] }">
<input type="hidden" name="xid" value="${id[17] }">
<input type="hidden" name="xid" value="${id[18] }">
<input type="hidden" name="xid" value="${id[19] }">
<input type="hidden" name="xid" value="${id[20] }">
<input type="hidden" name="xid" value="${id[21] }">
<input type="hidden" name="xid" value="${id[22] }">
<input type="hidden" name="xid" value="${id[23] }">
<input type="hidden" name="xid" value="${id[24] }">
<input type="hidden" name="xid" value="${id[25] }">
<input type="hidden" name="xid" value="${id[26] }">
<div data-options="region:'west',title:'权限设置'"
		style="width: 150px" >
<ul id="tt" class="easyui-tree" animate="true" dnd="true" lines="true">
	<li data-options="state:'closed'"><span>权限管理</span>
		<ul>

			<li><input type="checkbox" id="items" name="jid" value="${id[0] }" ${flag[0]==0?'checked':'' }>	<a href="#" onclick="addTab('角色管理','')">角色管理</a></li>
			
			<li><input type="checkbox" id="items" name="jid" value="${id[1] }" ${flag[1]==0?'checked':''}><a href="#" onclick="addTab('用户管理','')">用户管理</a></li>

			<li><input type="checkbox" id="items" name="jid" value="${id[2] }" ${flag[2]==0?'checked':''}><a href="#" onclick="addTab('部门管理','')">部门管理</a></li>
		</ul>
	</li>
		
	<li data-options="state:'closed'"><span>报名管理</span>
		<ul >
		
			<li><input type="checkbox" id="items" name="jid" value="${id[3] }" ${flag[3]==0?'checked':''}><a href="#" onclick="addTab('成考报名','')">成考报名</a></li>
			
			<li><input type="checkbox" id="items" name="jid" value="${id[4] }" ${flag[4]==0?'checked':''}><a href="#" onclick="addTab('会计报名','')">会计报名</a></li>
	
			<li><input type="checkbox" id="items" name="jid" value="${id[5] }" ${flag[5]==0?'checked':''}><a href="#" onclick="addTab('国家开放报名','')">国家开放报名</a></li>

			<li><input type="checkbox" id="items" name="jid" value="${id[6] }" ${flag[6]==0?'checked':''}><a href="#" onclick="addTab('远程报名','')">远程报名</a></li>
			<li><input type="checkbox" id="items" name="jid" value="${id[7] }" ${flag[7]==0?'checked':''}><a href="#" onclick="addTab('艺考报名','')">艺考报名</a></li>
			<li><input type="checkbox" id="items" name="jid" value="${id[8] }" ${flag[8]==0?'checked':''}><a href="#" onclick="addTab('职业资格报名','')">职业资格报名</a></li>
			<li><input type="checkbox" id="items" name="jid" value="${id[9] }" ${flag[9]==0?'checked':''}><a href="#" onclick="addTab('文件上传','')">文件上传</a></li>
		</ul>
	</li>
	
	<li data-options="state:'closed'"><span>专业管理</span>
		<ul >
			<li><input type="checkbox" id="items" name="jid" value="${id[10] }" ${flag[10]==0?'checked':''}><a href="#" onclick="addTab('专业管理','')">专业管理</a></li>
		</ul>
	</li>		
			
	<li data-options="state:'closed'" ><span>热门专业</span>
		<ul >
			<li><input type="checkbox" id="items" name="jid" value="${id[11] }" ${flag[11]==0?'checked':''}><a href="#" onclick="addTab('热门专业','')">热门专业</a></li>
		</ul>
	</li>
	
	<li data-options="state:'closed'"><span>招生简章</span>
		<ul >
			<li><input type="checkbox" id="items" name="jid" value="${id[12] }" ${flag[12]==0?'checked':''}><a href="#" onclick="addTab('招生简章','')">招生简章</a></li>
		</ul>
	</li>
	
	<li data-options="state:'closed'"><span>日志监控</span>
		<ul >
			<li><input type="checkbox" id="items" name="jid" value="${id[13] }" ${flag[13]==0?'checked':''}><a href="#" onclick="addTab('登陆日志','')">登陆日志</a></li>
		</ul>
	</li>		
	
	<li data-options="state:'closed'"><span>系统设置</span>
		<ul >
			<li><input type="checkbox" id="items" name="jid" value="${id[14] }" ${flag[14]==0?'checked':''}><a href="#" onclick="addTab('共享管理','')">共享管理</a></li>
			<li><input type="checkbox" id="items" name="jid" value="${id[15] }" ${flag[15]==0?'checked':''}><a href="#" onclick="addTab('联系方式','')">联系方式</a></li>
			<li><input type="checkbox" id="items" name="jid" value="${id[16] }" ${flag[16]==0?'checked':''}><a href="#" onclick="addTab('公告管理','')">公告管理</a></li>
			<li><input type="checkbox" id="items" name="jid" value="${id[17] }" ${flag[17]==0?'checked':''}><a href="#" onclick="addTab('首页内容','')">首页内容</a></li>
		</ul>
	</li>
	
	<li data-options="state:'closed'"><span>工作助手</span>
		<ul>
		<!-- selsche  -->
			<li><input type="checkbox" id="items" name="jid" value="${id[18] }" ${flag[18]==0?'checked':''}><a href="#" onclick="addTab('工作提醒','')">工作提醒</a></li>
		</ul>
	</li>
	
	<li data-options="state:'closed'"><span>财务管理</span>
		<ul>
		
			<li><input type="checkbox" id="items" name="jid" value="${id[19] }" ${flag[19]==0?'checked':''}><a href="#" onclick="addTab('成考缴费','')">成考缴费</a></li>
	
			<li><input type="checkbox" id="items" name="jid" value="${id[20] }" ${flag[20]==0?'checked':''}><a href="#" onclick="addTab('会计缴费','')">会计缴费</a></li>
		
			<li><input type="checkbox" id="items" name="jid" value="${id[21] }" ${flag[21]==0?'checked':''}><a href="#" onclick="addTab('国家开放缴费','')">国家开放缴费</a></li>
		
			<li><input type="checkbox" id="items" name="jid" value="${id[22] }" ${flag[22]==0?'checked':''}><a href="#" onclick="addTab('远程缴费','')">远程缴费</a></li>
		
			<li><input type="checkbox" id="items" name="jid" value="${id[23] }" ${flag[23]==0?'checked':''}><a href="#" onclick="addTab('艺考缴费','')">艺考缴费</a></li>
	
			<li><input type="checkbox" id="items" name="jid" value="${id[24] }" ${flag[24]==0?'checked':''}><a href="#" onclick="addTab('职业资格缴费','')">职业资格缴费</a></li>
		</ul>
	</li>
	
	<li data-options="state:'closed'"><span>报表管理</span>
		<ul>
			<li><input type="checkbox" id="items" name="jid" value="${id[25] }" ${flag[25]==0?'checked':''}><a href="#" onclick="addTab('报名统计报表','')">报名统计报表</a></li>
			<li><input type="checkbox" id="items" name="jid" value="${id[26] }" ${flag[26]==0?'checked':''}><a href="#" onclick="addTab('财务报表','')">财务报表</a></li>
		</ul>
	</li>		
</ul>
</div>

<div data-options="region:'center'">
  <input type="button" name="checkall" id="checkall" value="全选">  
    <input type="button" name="checkall" id="checkNo" value="全不选"> 
<input type="submit"  value="提交"><br/>

</div>
</form>

	

</body>
</html>