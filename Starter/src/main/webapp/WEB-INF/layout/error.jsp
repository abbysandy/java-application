<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Error</title>
		<style>
			
			html, body {
				padding: 0;
				margin: 0;
			}
			
			body {
				font-family: Arial;
				color: rgba(0, 0, 0, 0.5);
				background-color: #f1f1f1;
			}
			
			.container {
				margin: 50px auto 40px auto;
				width: 600px;
				text-align: center;
			}
			
			h1 {
				width: 800px;
				position: relative; left: -100px;
				letter-spacing: -1px;
				line-height: 60px;
				font-size: 60px;
				font-weight: 100;
				margin: 0px 0 50px 0;
				text-shadow: 0 1px 0 #fff;
			}
			
			p {
				margin: 20px 0;
				line-height: 1.6;
			}
			
			a {
				color: #4183c4;
				text-decoration: none;
			}
      		
			a:hover {
				text-decoration: underline;
			}
			
		</style>
	</head>
	<body>
		
		<div class="container">
			
			<tiles:insertAttribute name="body" />
			
		</div>
	
	</body>
</html>