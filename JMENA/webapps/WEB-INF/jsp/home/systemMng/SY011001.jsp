<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/resource/css/jquery-ui.css" />
	<link rel="stylesheet" href="/resource/css/ui.jqgrid.css" />

	<script type="text/javascript">
		$(document).ready(function(){
			f_selectSysMst();
			f_selectSysDtl();
		});
	
		function f_selectSysMst() {
			$('#leftList').jqGrid("GridUnload");	//새로운 값으로 변경할 때 사용
			
			$('#leftList').jqGrid({
				//caption: '시스템 및 메뉴관리' ,
				url:"/home/selectListSysMst.do" ,
				datatype:"json" ,
				mtype: 'POST',
				loadtext: '로딩중...',
				loadError:function(){alert("Error~!!");} ,
				colNames:['시스템코드', '시스템 명', '정렬순서'] ,
				colModel:[
					{name:"SYSID",			index:'SYSID',		width:60,		align:'center', sortable:false}
					,{name:"SYSNAME",		index:'SYSNAME',	width:60,		align:'center', sortable:false}
					,{name:"SORTKEY",		index:'SORTKEY',	width:60,		align:'center', sortable:false}
					] ,
				rowNum:10 ,
				autowidth: true ,
				rowList:[10,20,30] ,
				//pager: $('#leftNav') ,
				sortname: 'SORTKEY' ,
				viewrecords: true ,
				sortorder:'asc' ,
				width: "96%" ,
				jsonReader: {
					repeatitems: false
				},
				//height: '100%' ,
				onSelectRow: function(ids){
					var selRowData = $(this).jqGrid('getRowData', ids);
			        
					$("#SYSID").val(selRowData.SYSID);
					$("#SYSNAME").val(selRowData.SYSNAME);
					$("#SORTKEY").val(selRowData.SORTKEY);
					
					f_selectSysDtl(selRowData.SYSID);
				} ,
				hidegrid: false ,
			});
		}
		
		function f_selectSysDtl(sysId) {
			$(function() {
				$('#rightList').jqGrid("GridUnload");	//새로운 값으로 변경할 때 사용
				
				$('#rightList').jqGrid({
					//caption: '시스템 및 메뉴관리' ,
					url:"/home/selectListSysDtl.do" ,
					postData : {
						SYSID : sysId
					},
					datatype:"json" ,
					mtype: 'POST',
					loadtext: '로딩중...',
					loadError:function(){alert("Error~!!");} ,
					colNames:['메뉴코드', '메뉴명', '사용여부', '비고', '정렬순서'] ,
					colModel:[
						{name:"MENUID",			index:'MENUID',		width:60,		align:'center', sortable:false}
						, {name:"MENUNAME",		index:'MENUNAME',	width:60,		align:'center', sortable:false}
						, {name:"USEYN",		index:'USEYN',		width:60,		align:'center', sortable:false}
						, {name:"REMARK",		index:'REMARK',		width:60,		align:'center', sortable:false}
						, {name:"SORTKEY",		index:'SORTKEY',	width:60,		align:'center', sortable:false}
						] ,
					rowNum:10 ,
					autowidth: true ,
					rowList:[10,20,30] ,
					//pager: $('#rightNav') ,
					sortname: 'SORTKEY' ,
					viewrecords: true ,
					sortorder:'asc' ,
					width: "96%" ,
					jsonReader: {
						repeatitems: false
					},
					//height: '100%' ,
					onSelectRow: function(id){
						//alert($(this).attr("SYSID"));
					} ,
					hidegrid: false
				});
			})
		}
		
		$(function() {
			$("#sysSearchButton").click(function(){
				var sysId = $("#SYSID").val();
				
				var ids = jQuery("#leftList").jqGrid('getDataIDs');
				
				ids.some(function(currentValue, index, array){
					var cellData = $("#leftList").jqGrid('getCell', ids[index], 'SYSID');
					if (cellData == sysId) {
		        		$("#leftList").jqGrid('setSelection', ids[index]);
		    			return true;
		        	}	        
				});
			});
		})
	</script>
</head>
<body>
	<div id="contents" style="width:1200px;" align="center">
		<div id="leftDiv" style="width:48%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table id="leftList"></table>
			<div id="leftNav"></div>
		</div>
		<div id="rightDiv" style="width:48%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table class="blueone">
				<tr>
					<td>시스템코드</td>
					<td><input type="text" id="SYSID" name="SYSID" />&nbsp;<a class="ui-button ui-widget ui-corner-all" id="sysSearchButton" name="sysSearchButton">=></a></td>
				</tr>
				<tr>
					<td>시스템 명</td>
					<td><input type="text" id="SYSNAME" name="SYSNAME" /></td>
				</tr>
				<tr>
					<td>정렬순서</td>
					<td><input type="text" id="SORTKEY" name="SORTKEY" /></td>
				</tr>
			</table>
			<table id="rightList"></table>
			<div id="rightNav"></div>
		</div>
	</div>
</body>
</html>