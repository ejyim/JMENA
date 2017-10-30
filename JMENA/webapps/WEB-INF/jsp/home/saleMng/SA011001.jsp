<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/resource/css/jquery-ui.css" />
	<link rel="stylesheet" href="/resource/css/ui.jqgrid.css" />

</head>
<script type="text/javascript">

	$(document).ready(function(){
		
		f_selectListEnaSaleMst();
		f_selectListEnaSaleISTb();
		f_selectListEnaSaleJNTb();
		f_selectListEnaSaleHisTb();
		
	});


	function f_selectListEnaSaleMst(){
		$('#leftList').jqGrid({
			//caption: '매출관리'
			url:"/home/selectListSysMst.do" ,
			datatype:"json" ,
			loadError:function(){alert("Error~!!");} ,
			colNames:['매출일자', '원지주', '주소', '매출평수', '매출면적', '매출대금'] ,
			colModel:[
				{name:"SALEDATE",		index:'SALEDATE',		width:60,	align:'center'}
				,{name:"CONNAME",		index:'CONNAME',		width:60,	align:'center'}
				,{name:"CONADDRESS",	index:'CONADDRESS',		width:60,	align:'center'}
				,{name:"CONPY",			index:'CONPY',			width:60,	align:'center'}
				,{name:"CONM2",			index:'CONM2',			width:60,	align:'center'}
				,{name:"CONM2",			index:'CONM2',			width:60,	align:'center'}
			] ,
			rowNum:10 ,
			autowidth: true ,
			shrinkToFit: false,
			rowList:[10,20,30] ,
			sortname: 'sortKey' ,
			viewrecords: true ,
			sortorder:'asc' ,
			width: "96%" ,
			jsonReader: {
				repeatitems: false
			},
			//height: '100%' ,
			onSelectRow: function(id){
				alert(id);
			} ,
			hidegrid: false
		});
	}
	
	function f_selectListEnaSaleISTb(){
		$('#bottomList1').jqGrid({
			//caption: '입금 스케쥴 관리'
			url:"/home/selectListSysMst.do" ,
			datatype:"json" ,
			loadError:function(){alert("Error~!!");} ,
			colNames:['입금구분', '입금일', '입금예정일', '입금처리금액', '입금여부', '비고'] ,
			colModel:[ 
				{name:"SYSID",			index:'SYSID',		width:60,	align:'center'}
				, {name:"SYSNAME",		index:'SYSNAME',	width:60,	align:'center'}
				, {name:"SORTKEY",		index:'SORTKEY',	width:60,	align:'center'}
				, {name:"USEYN",		index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",		index:'USEYN',		width:60,	align:'center'}
				, {name:"REMARK",		index:'REMARK',		width:60,	align:'center'}
			] ,
			rowNum:10 ,
			autowidth: true ,
			shrinkToFit: false,
			rowList:[10,20,30] ,
			sortname: 'SORTKEY' ,
			viewrecords: true ,
			sortorder:'asc' ,
			width: "96%" ,
			jsonReader: {
				repeatitems: false
			},
			//height: '100%' ,
			onSelectRow: function(id){
				alert(id);
			} ,
			hidegrid: false
		});
	}
	
	function f_selectListEnaSaleJNTb(){
		
		
		$('#bottomList2').jqGrid({
			//caption: '등기 관리'
			url:"/home/selectListSysMst.do" ,
			datatype:"json" ,
			loadError:function(){alert("Error~!!");} ,
			colNames:['명의자', '주민번호', '연락처', '점유면적', '점유평수', '매매대금', '매매단가', 'DC사항', 'DC율', '실 매매가', '등본제출여부', '비고'] ,
			colModel:[
				{name:"SYSID",		index:'SYSID',		width:60,	align:'center'}
				, {name:"SYSNAME",	Index:'SYSNAME',	width:60,	align:'center'}
				, {name:"SORTKEY",	index:'SORTKEY',	width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"USEYN",	index:'USEYN',		width:60,	align:'center'}
				, {name:"REMARK",	index:'REMARK',		width:60,	align:'center'}
			] ,
			rowNum:10 ,
			autowidth: true ,
			shrinkToFit: false,
			rowList:[10,20,30] ,
			sortname: 'SORTKEY' ,
			viewrecords: true ,
			sortorder:'asc' ,
			width: "96%" ,
			jsonReader: {
				repeatitems: false
			},
			//height: '100%' ,
			onSelectRow: function(id){
				alert(id);
			} ,
			hidegrid: false
		});
	}

	function f_selectListEnaSaleHisTb(){

		$('#bottomList3').jqGrid({
			//caption: '시스템 및 메뉴관리' ,
			url:"/home/selectListSysMst.do" ,
			datatype:"json" ,
			mtype: 'POST',
			loadtext: '로딩중...',
			loadError:function(){alert("Error~!!");} ,
			colNames:['변동일자', '변동구분', '직전 계약면적', '직전 계약평수', '변경면적', '변경평수', '비고'] ,
			colModel:[
				{name:"SYSID",			index:'SYSID',		width:60,		align:'center'}
				, {name:"SYSNAME",		index:'SYSNAME',	width:60,		align:'center'}
				, {name:"SORTKEY",		index:'SORTKEY',	width:60,		align:'center'}
				, {name:"USEYN",		index:'USEYN',		width:60,		align:'center'}
				, {name:"USEYN1",		index:'USEYN1',		width:60,		align:'center'}
				, {name:"USEYN2",		index:'USEYN2',		width:60,		align:'center'}
				, {name:"REMARK",		index:'REMARK',		width:60,		align:'center'}
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
				
			} ,
			hidegrid: false ,
		});
	}
	
	
	
</script>
<body>
	<div id="contents" style="width:1200px;" align="center">
		<div id="topDiv" style="width:98%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table width="99%">
				<tr>
					<td align="right">
						<a class="ui-button ui-widget ui-corner-all" id="selectButton" name="selectButton">조회</a>
						<a class="ui-button ui-widget ui-corner-all" id="insertButton" name="insertButton">추가</a>
						<a class="ui-button ui-widget ui-corner-all" id="saveButton" name="saveButton">저장</a>
					</td>
				</tr>
			</table>
		</div>
		<div id="leftDiv" style="width:48%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table width="99%" class="blueone">
				<tr>
					<td>매출기간</td>
					<td><input type="text" id="SALEDATE" name="SALEDATE" /> ~ <input type="text" id="SALEDATE" name="SALEDATE" /></td>
				</tr>
				<tr>
					<td>담당자</td>
					<td><input type="text" id="SALERCD" name="SALERCD" /></td>
				</tr>
				<tr>
					<td>지번(주소)</td>
					<td><input type="text" id="CONADDRESS" name="CONADDRESS" /></td>
				</tr>
			</table>
			<table id="leftList"></table>
		</div>
		<div id="rightDiv" style="width:48%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table class="blueone">
				<tr>
					<td>계약일자/번호</td>
					<td colspan="3"><input type="text" id="SYSID" name="SYSID" /><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>매출구분</td>
					<td colspan="3">
						<select id="SYSID" name="SYSID">
							<option></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>담당자</td>
					<td>
						<select id="SYSID" name="SYSID">
							<option></option>
						</select>
					</td>
					<td>계약지사</td>
					<td>
						<select id="SYSID" name="SYSID">
							<option></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>관리번호</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
					<td>지역구분</td>
					<td>
						<select id="SYSID" name="SYSID">
							<option></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="3"><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>원지주 성명</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
					<td>주민번호</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>분양/잔여면적</td>
					<td><input type="text" id="SYSID" name="SYSID" /> / <input type="text" id="SYSID" name="SYSID" /></td>
					<td>분양/잔여평수</td>
					<td><input type="text" id="SYSID" name="SYSID" /> / <input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>계약자 성명</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
					<td>계약자주민번호</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>계약자 주소</td>
					<td colspan="3"><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>계약자 연락처</td>
					<td colspan="3"><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>계약면적</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
					<td>계약평수</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>매매대금</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
					<td>매매단가</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>위탁수수료</td>
					<td colspan="3"><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>DC사항</td>
					<td>
						<select id="SYSID" name="SYSID">
							<option></option>
						</select>
					</td>
					<td>DC율</td>
					<td><input type="text" id="SYSID" name="SYSID" /> % </td>
				</tr>
				<tr>
					<td>DC금액</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
					<td>실 판매가</td>
					<td><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
				<tr>
					<td>비고</td>
					<td colspan="3"><input type="text" id="SYSID" name="SYSID" /></td>
				</tr>
			</table>
		</div>
		<div id="bottomDiv" style="width:98%; float:left; border:1px solid #333; padding: 10px" align="left">
			<div id="bottomDiv1">
				<table id="bottomList1"></table>
			</div>
			<div id="bottomDiv2">
				<table id="bottomList2"></table>
			</div>
			<div id="bottomDiv3">
				<table id="bottomList3"></table>
			</div>
		</div>
	</div>	
		
</body>
</html>