<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Toto</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Lists<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/list/create">Create new List</a></li>
          <li><a href="/list">View Lists</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Tasks<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/task/create">Create New Task</a></li>
          <li><a href="/task">View Tasks</a></li>
        </ul>
      </li>
      <li class="dropdown">
          <sec:ifAnyGranted roles="ROLE_USER">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <!-- TODO: Menu settings needs to go to user information for current logged in user only. -->
              <!-- <li><a href="/user/">Settings</a></li> -->
              <li><a href="/logout">Logout</a></li>
            </ul>
          </sec:ifAnyGranted>
          <sec:ifNotGranted roles ='ROLE_USER'>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Login<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/login">Login</a></li> <!-- Need to set to current logged in user only -->
            <!-- TODO:  Need to create a register section for users to register for an account. -->
            <!--<li><a href="/register">Register</a></li> -->
          </ul>
          </sec:ifNotGranted>
      </li>

    </content>
    <div class="svg" role="presentation">
        <div class="grails-logo-container">
            <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
        </div>
    </div>
    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Welcome to Toto</h1>
            <p>
                This is a simple Grails To-Do application using Grails 3.2.9 and Spring Security Core 3.1.2.
            </p>
        </section>
    </div>
</body>
</html>
