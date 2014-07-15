<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div id="wrapper">

        <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/homepage"/>">Catalog</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                	${userLogged.username}
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                        	<a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
