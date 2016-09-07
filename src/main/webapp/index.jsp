<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Welcome to OpenShift</title>

<link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>

	<section class='container'>
		<hgroup>
			<h1>JBossEWS (Apache/Tomcat) App on OpenShift</h1>
		</hgroup>


		<div class="row">
			<section class='col-xs-12 col-sm-6 col-md-6'>
				<section>
					<h2>Spring rest services</h2>
					<p>This is an simple example of an application which makes
						available rest services.</p>
					<p>It is using Spring 4, MySql 5.6 and JDBC Connection.</p>
				</section>
			</section>

			<section class="col-xs-12 col-sm-6 col-md-6">

				<h2>Available Services</h2>

				<h3>GET</h3>
				<ul>
					<li>Get all persons<br />http://&lt;localhost:port&gt;/app-jdbc/person
					</li>
				</ul>
				<ul>
					<li>Get a person by id<br />http://&lt;localhost:port&gt;/app-jdbc/person/{id}</li>
				</ul>

			</section>
			
			<section class='col-xs-12 col-sm-12 col-md-12'>
				<h2>
				Tutorial to create an openshift app:				
				</h2>
				<p><a href="https://hub.openshift.com/quickstarts/96-tomcat-7-jboss-ews-2-0">
				https://hub.openshift.com/quickstarts/96-tomcat-7-jboss-ews-2-0</a></p>
			
			</section>
		</div>

		<footer>
			<div class="logo">
				<a href="https://www.openshift.com/"></a>
			</div>
		</footer>
	</section>
</body>
</html>
