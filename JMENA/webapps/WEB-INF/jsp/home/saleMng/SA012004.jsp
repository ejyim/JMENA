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

	$(function(){

		$('#mainList').jqGrid({
			//caption: '은행입금 현황', 
			url:"/home/selectListSysMst.do" ,
			datatype:"json",
			loadError:function(){alert("Error~!!");},
			colNames:['입금일자', '지사', '담당자', '계약자', '입금구분', '입금금액', '수금처리금액', '처리잔액', '입금은행', '입금형태',
			          '소재지', '평수', '비고'],
			colModel:[
						{name:"KNAME",				index:'kName',		width:100,	align:'center'}
						, {name:"JUMINID",			index:'juminId',	width:100,	align:'center'}
						, {name:"MOBILENO",			index:'mobileNo',	width:100,	align:'center'}
						, {name:"BRANCHCODE",		index:'branchCode',	width:100,	align:'center'}
						, {name:"DEPTCODE",			index:'deptCode',	width:150,	align:'center'}
						, {name:"KNAME",			index:'kName',		width:100,	align:'center'}
						, {name:"O_JUMINID",		index:'juminId',	width:100,	align:'center'}
						, {name:"MOBILENO",			index:'mobileNo',	width:100,	align:'center'}
						, {name:"BRANCHCODE",		index:'branchCode',	width:100,	align:'center'}
						, {name:"O_BRANCHCODE",		index:'deptCode',	width:150,	align:'center'}
						, {name:"O_JOINDATE",		index:'kName',		width:100,	align:'center'}
						, {name:"O_RETIREDATE",		index:'juminId',	width:100,	align:'center'}
						, {name:"O_TOTAMT",			index:'mobileNo',	width:100,	align:'center'}
			],
			rowNum:10,
			autowidth: true,
			shrinkToFit: false,
			rowList:[10,20,30],
			sortname: 'kName',
			viewrecords: true,
			sortorder:'asc',
			width: '96%',
			jsonReader: {
				repeatitems: false
			},
			//height: '100%',
			onSelectRow: function(id){
				alert(id);
			},
			hidegrid: false
		});

/* 		$("#mainList").jqGrid('setGroupHeaders', {
		    useColSpanStyle: true, //rowspan자동으로 해줄지 여부.
		    groupHeaders:[
		      {
		        startColumnName: 'O_JUMINID',
		        numberOfColumns: 4,
		        titleText: '전근무현황'
		      }
		     ]
	    });
 */		 
		
	})	
</script>
<body>

<!-- <div style="width:100%; border:1px solid red;" align=center>
     <div style="width:90%;">
          <div style="width:33%; float:left; border:1px solid #333;">1</div>
          <div style="width:34%; float:left; border:1px solid #333;">2</div>
     </div>
</div>
 -->


	<div id="contents" style="width:1200px;" align="center">
		<div id="mainDiv" style="width:98%; float:left; border:1px solid #333; padding: 10px" align="left">
			<table width="98%" class="blueone">
				<tr>
					<th>입금기간</th>
					<td><input type="text" id="SALEDATE" name="SALEDATE" /> ~ <input type="text" id="SALEDATE" name="SALEDATE" /></td>
				</tr>
				<tr>
					<th>지사</th>
					<td>
						<select id="branchCode" name="branchCode">
							<option>서울</option>
							<option>경기</option>
							<option>부산</option>
						</select>
					</td>
					<th>담당자</th>
					<td>
						<select id="branchCode" name="branchCode">
							<option>서울</option>
							<option>경기</option>
							<option>부산</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>입금구분</th>
					<td>
						<select id="branchCode" name="branchCode">
							<option>서울</option>
							<option>경기</option>
							<option>부산</option>
						</select>
					</td>
					<th>입금인</th>
					<td><input type="text" id="SALEDATE" name="SALEDATE" /></td>
					<th>입금금액</th>
					<td><input type="text" id="SALEDATE" name="SALEDATE" /></td>
				</tr>
			</table>
			<br/>
			<table id="mainList" width="98%"></table>
			<div id="mainNav"></div>
		</div>
	</div>
</body>
</html>