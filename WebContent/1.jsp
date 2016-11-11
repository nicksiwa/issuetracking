<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div >
<form method="post" action="1.jsp">
	<h2 style="text-align: center;">ข้อมูลการกู้เงินและสถานะหนี้คงค้างขององค์กรปกครองส่วนท้องถิ่น</h2>
	<table align="center">
		<tr>
			<td style="text-align: right;">วันที่เริ่มต้น :</td>
			<td><input type="date" name="startday"></td>
			<td style="text-align: right;">วันที่สิ้นสุด :</td>
			<td><input type="date" name="endday"></td>
		</tr>
		<tr>
			<td style="text-align: right;">โครงการ/กิจกรรม :</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td style="text-align: right;">จำนวนสัญญาเงินกู้ :</td>
			<td><input type="text" value="" id="num" name="num"> <input type="submit" value="ตกลง"/></td>
		</tr>
	</table>
	<br>

	<%

	int num = 0;
	num=request.getParameter("num")==null?0:Integer.parseInt(request.getParameter("num")); 
	
	%>

<%for (int i=0;i<num;i++){ %>


	<fieldset>
		<legend> สัญญาเงินกู้ : <%=i+1 %> </legend>
		<table>
			<tr>
				<td style="text-align: right;">แหล่งเงินกู้ :</td>
				<td><select name="a">
						<option value="a">--เลือกแหล่งเงินกู้--</option>
						<option value="a">1. ธนาคารกรุงไทย</option>
						<option value="a">2. ธนาคารออมสิน</option>
						<option value="a">3. ธนาคาร ธกส.</option>
						<option value="a">4. กองทุนพัฒนาเมือง(ออมสิน)</option>
						<option value="a">5. อื่นๆ</option>
				</select>
			</tr>
			<tr>
				<td style="text-align: right;">วงเงินที่ ผวจ. หรือ รมว.มท.
					เห็นชอบ/อนุมัติ :</td>
				<td><input type="text"> บาท</td>
			</tr>
			<tr>
				<td style="text-align: right;">วันที่ ผวจ. หรือ รมว.มท.
					เห็นชอบ/อนุมัติ :</td>
				<td><input type="date" name="endday"></td>
			</tr>
			<tr>
				<td style="text-align: right;">จำนวนเงินที่ อปท. ทำสัญญากู้เงิน
					:</td>
				<td><input type="text"> บาท</td>
			</tr>
			<tr>
				<td style="text-align: right;">เลขทีสัญญากู้เงิน :</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td style="text-align: right;">วันที่ทำสัญญากู้เงิน :</td>
				<td><input type="date" name="endday"></td>
			</tr>
			<tr>
				<td style="text-align: right;">อัตราดอกเบี้ย :</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td style="text-align: right;">ระยะเวลาการกู้(ปี) :</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td style="text-align: right;">จำนวนเงินที่ชำระหนี้แล้ว
					ชำระเงินต้น :</td>
				<td><input type="text"> บาท</td>
			</tr>
			<tr>
				<td style="text-align: right;">จำนวนเงินที่ชำระหนี้แล้ว
					ชำระดอกเบี้ย :</td>
				<td><input type="text"> บาท</td>
			</tr>
			<tr>
				<td style="text-align: right;">รายได้ที่จัดเก็บเอง :</td>
				<td><input type="text"> บาท</td>
			</tr>
			<tr>
				<td style="text-align: right;">สถานะหนี้คงค้าง ณ สิ้นปี :</td>
				<td><input type="text"> บาท</td>
			</tr>

		</table>
	</fieldset>
	<br>
	
<%} %>
	<br>
	<table align="center">
		<tr>
			<td style="text-align: right;"><button>บันทึกข้อมูล</button></td>
			<td><button>ยกเลิก</button></td>
		</tr>
	</table>
	</form>
	</div>
	
	
</body>
</html>