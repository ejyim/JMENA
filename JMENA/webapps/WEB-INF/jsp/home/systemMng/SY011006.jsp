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
		var v_rightLastSel = 0;
	
		$(document).ready(function(){
			$("#S_FLAG").val("U");
			
			f_selectBankMst();
		});
		
		function f_selectBankMst() {
			$('#leftList').jqGrid("GridUnload");	//새로운 값으로 변경할 때 사용
			
			$('#leftList').jqGrid({
				url:"/home/selectListBankMst.do",
				postData : {
					BANKNAME:$("#S_BANKNAME").val()
				},
				datatype:"json" ,
				mtype: 'POST',
				loadtext: '로딩중...',
				loadError:function(){alert("Error~!!");} ,
				colNames:['기관코드', '금융기관명', '사용여부', '확장코드'] ,
				colModel:[
					{name:"BANKCODE",		index:'BANKCODE',	width:60,	align:'center', sortable:false, editable:true}
					, {name:"BANKNAME",		index:'BANKNAME',	width:60,	align:'center', sortable:false, editable:true}
					, {name:"USEYN",		index:'USEYN',		width:60,	align:'center', sortable:false, editable:true, edittype:'select', editoptions:{value: "Y:Y;N:N"}}
					, {name:"AUXCODE",		index:'AUXCODE',	width:60,	align:'center', sortable:false, editable:true}
				] ,
				rowNum:1000,
				autowidth: true ,
				rowList:[10,20,30] ,
				//pager: $('#leftNav') ,
				sortname: 'BANKCODE' ,
				viewrecords: true ,
				sortorder:'asc' ,
				width: "96%" ,
				jsonReader: {
					repeatitems: false
				},
				//height: '100%' ,
				onSelectRow: function(id){
					if (v_rightLastSel != 0) $("#S_FLAG").val("U");
					
					if( v_rightLastSel != id ){
				        $(this).jqGrid('restoreRow',v_rightLastSel,true);    //해당 row 가 수정모드에서 뷰모드(?)로 변경
				        $(this).jqGrid('editRow',id,false);  //해당 row가 수정모드(?)로 변경

				        v_rightLastSel = id;
					}
				} ,
				loadComplete: function() {
					
				},
				hidegrid: false
			});
		}
		
		$(function() {
			$("#selectButton").click(function() {
				v_rightLastSel = 0;
				
				f_selectBankMst();
			});
		})
		
		function f_selectKeyBankMst() {
			var keyCode = window.event.keyCode;
			if(keyCode==13) {
				$("#selectButton").click();
			}
		}
		
		$(function() {
			$("#insertButton").click(function() {
				$("#S_FLAG").val("I");
				
				$("#leftList").jqGrid("addRow", 0);
			});
		})
		
		$(function() {
			$("#saveButton").click(function() {
				var ids = $("#leftList").jqGrid('getGridParam', 'selrow');	//선택아이디 가져오기
				
				$('#leftList').jqGrid('saveRow',ids,false,'clientArray'); //선택된 놈 뷰 모드로 변경

				var cellData = $("#leftList").jqGrid('getRowData', ids); //셀 전체 데이터 가져오기
				
				if (ids == null || ids == "") {
					alert("그리드를 선택하셔야 합니다.");
					
					return false;
				}
				
				if (cellData.BANKCODE == "") {
					alert("기관 코드를 입력하셔야 합니다.");
					
					$('#leftList').jqGrid('editRow', ids, true);
					$("#"+ids+"_BANKCODE").focus();
					
					return false;
				}
				
				if (cellData.BANKNAME == "") {
					alert("금융기관명을 입력하셔야 합니다.");
					
					$('#leftList').jqGrid('editRow', ids, true);
					$("#"+ids+"_BANKNAME").focus();
					
					return false;
				}
				
				var msg = "";
				if ($("#S_FLAG").val() == "I") {
					msg = "저장하시겠습니까?";
				} else {
					msg = "수정하시겠습니까?"
				}
				if (confirm(msg) == true) {
					var formData = "S_FLAG=" + $("#S_FLAG").val() + "&BANKCODE=" + cellData.BANKCODE + "&BANKNAME=" + cellData.BANKNAME + "&USEYN=" + cellData.USEYN + "&AUXCODE=" + cellData.AUXCODE;
					
					$.ajax({ 
						type: 'POST' ,
						data: formData,
						url: "/home/insertDataBankMst.do", 
						dataType : 'json',
						success: function(data){
							$("#S_FLAG_R").val("U");
							
							v_rightLastSel = 0;
							
							alert(data.resultMsg);
							
							$("#selectButton").click();
						},
						error:function(e){  
							alert("[ERROR]Menu 저장  중 오류가 발생하였습니다.");
						}  
					});
				} else {
					$("#selectButton").click();
				}
			});
		})
	</script>
</head>
<body>
	<div id="contents" style="width:1200px;" align="center">
		<div id="topDiv" style="width:98%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table class="blueone">
				<tr>
					<td><a class="ui-button ui-widget ui-corner-all" id="selectButton" name="selectButton">조회</a></td>
					<td><a class="ui-button ui-widget ui-corner-all" id="insertButton" name="insertButton">추가</a></td>
					<td><a class="ui-button ui-widget ui-corner-all" id="saveButton" name="saveButton">저장</a></td>
				</tr>
			</table>
		</div>
		<input type="hidden" id="S_FLAG" name="S_FLAG" />
		<div id="leftDiv" style="width:96%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table class="blueone">
				<tr>
					<td>금융기관</td>
					<td><input type="text" id="S_BANKNAME" name="S_BANKNAME" onkeydown="f_selectKeyBankMst();"/></td>
				</tr>
			</table>
			<table id="leftList"></table>
		</div>
	</div>
</body>
</html>