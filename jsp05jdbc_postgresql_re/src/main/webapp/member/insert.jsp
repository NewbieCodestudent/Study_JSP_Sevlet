<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원입력</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/insert.css">

<script>
	window.onload = function() {
		console.log("onload....");
		let btn_idCheck = document.querySelector("#btn_idCheck");
		let result = document.querySelector("#result");
		// console.log(result);

		btn_idCheck.onclick = function(event) {
			console.log("onclick....");
			let id = document.querySelector("#id");
			// console.log(id);
			console.log(id.value);
			
			let req = new XMLHttpRequest();

			req.addEventListener("load", function() {
				console.log(this.status);
				console.log(this.responseText);
				//{"result":"Not OK"}
				if(this.status==200){
					try {
						let txt_json = this.responseText;
						let obj_json = JSON.parse(txt_json);
						console.log(obj_json);
						console.log(obj_json.result);

						let txt = "";
						if (obj_json.result === 'Not OK') {
							txt = "사용중인 아이디 입니다.";
						} else {
							txt = "사용가능한 아이디 입니다.";
						}
						result.innerHTML = txt;
					} catch (e) {
						console.log("json 형식이 아님.");
					}
					
				}//end if
				

				

			});
			
			req.open("GET",
					"http://localhost:8090/jsp05jdbc_postgresql/json_idCheck.do?id="
							+ id.value);
			req.send();

			event.preventDefault();
			event.stopPropagation();
		};
	};
</script>
</head>
<body>
	<h3>회원입력</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>

	<form action="m_insertOK.do" method="post" enctype="multipart/from-date">
		<table>
			<tbody>
				<tr>
					<td><label for="id">ID</label></td>
					<td><input type="text" placeholder="ID" id="id" name="id" value="admin"></td>
					<td><input type="button" id="btn_idCheck" value="중복체크"><span
						id="result"></span></td>
				</tr>
				<tr>
					<td><label for="pw">PW</label></td>
					<td><input type="password" placeholder="PW" id="pw" name="pw" value="hi1234"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="name">NAME</label></td>
					<td><input type="text" placeholder="NAME" id="name" name="name" value="kim"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="tel">TEL</label></td>
					<td><input type="text" placeholder="TEL" id="tel" name="tel" value="02"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="profile">프로필</label></td>
					<td><input type="file" placeholder="PROFILE" id="profile" name="profile"></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="회원가입"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>