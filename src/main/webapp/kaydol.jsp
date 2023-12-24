<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body class="container">
	<div class="row justify-content-center">
		<div class="mt-5 col-6">
			<form action="kaydol" method="post">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">İsim
						Soyisim</label> <input name="name" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp">

				</div>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Email</label> <input
						name="email" type="email" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				<div class="d-flex justify-content-around">
					<div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="cizim"
								id="defaultCheck1"> <label class="form-check-label"
								for="defaultCheck1"> Çizim yapmak </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="tasarim"
								id="defaultCheck2"> <label class="form-check-label"
								for="defaultCheck2"> Tasarım yapmak </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="yoga"
								id="defaultCheck3"> <label class="form-check-label"
								for="defaultCheck3"> Yoga/pilates </label>
						</div>
					</div>
					<div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="enstruman"
								id="defaultCheck4"> <label class="form-check-label"
								for="defaultCheck4"> Enstrüman çalmak </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="blog"
								id="defaultCheck5"> <label class="form-check-label"
								for="defaultCheck5"> Blog yazmak </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="vlogger"
								id="defaultCheck6"> <label class="form-check-label"
								for="defaultCheck6"> Vlogger olmak </label>
						</div>
					</div>

				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="cinsiyet"
						value="erkek" id="flexRadioDefault1"> <label
						class="form-check-label" for="flexRadioDefault1"> Erkek </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="cinsiyet"
						value="kadin" id="flexRadioDefault2" checked> <label
						class="form-check-label" for="flexRadioDefault2"> Kadın </label>
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<input name="sifre" type="password" class="form-control"
						id="exampleInputPassword1">
				</div>
				<button type="submit" class="btn btn-primary">Kaydet</button>
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>