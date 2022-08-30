<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/update.css">
<script>
	window.onload = function() {
		console.log("onload...");
		let btn_idCheck = document.querySelector("#btn_idCheck");
		let result = document.querySelector("#result");

		btn_idCheck.onclick = function(event) {
			console.log("onclick");
			let id = document.querySelector("#id");
			console.log(id.value);
		
			let req = new XMLHttpRequest();
		
			req.addEventListener("load", function() {
				console.log(this.status);
				console.log(this.resposeText);
				if(this.status==200) {
					try {
						let txt_json = this.responseText;
						let obj_json = JSON.parse(txt_json);
						console.log(obj_json);
						console.log(obj_json.result);
						
						let txt = "";
						if (obj_json.result === "Not Ok") {
							txt = "사용중";
						} else {
							txt = "사용가능";
						}
						result.innerHTML = txt;	
					} catch (e) {
						console.log("json 형식이 아님");
					}
					
				}//end if
			});
			
			req.open("GET","http://localhost:8090/JSP03request/json_idCheck.do?id=" + id.value);
			req.send();
			event.preventDefault();
			event.stopPropagation();
		};
	};
</script>
</head>
<body>
	<h3>회원수정</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form action="m_updateOK.do" method="post">
		<table>
			<tbody>
				<tr>
					<td><label for="num">NUM:</label></td>
					<td>${param.num}<input type="hidden" placeholder="NUM" id="num" name="num" value="${param.num}"></td>
					<!-- ${param.num} 내부에 히든으로 숨겨진 숫자를 가져온다. 가져오는 정보는 주소창에 있는 것을 가져온다. -->
					<td></td>
				</tr>
				<tr>
					<td><label for="id">ID:</label></td>
					<td><input type="text" placeholder="ID" id="id" name="id"
						value="${vo2.id}"></td>
					<td><input type="button" id="btn_idCheck" value="중복체크"><span id="result"></span></td>
				</tr>
				<tr>
					<td><label for="pw">PW:</label></td>
					<td><input type="password" placeholder="PW" id="pw" name="pw"
						value="${vo2.pw}"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="name">NAME:</label></td>
					<td><input type="text" placeholder="NAME" id="name"
						name="name" value="${vo2.name}"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="tel">TEL:</label></td>
					<td><input type="text" placeholder="TEL" id="tel" name="tel"
						value="${vo2.tel}"></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td colspan="3"><input type="submit" value="수정완료"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>