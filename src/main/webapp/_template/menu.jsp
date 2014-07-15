<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <div class="navbar-default navbar-static-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="side-menu">
						<li>
                            <a href="<c:url value="/listLabel"/>"><i class="fa fa-fw"></i> Labels</a>
                        </li>
						<li>
                            <a href="<c:url value="/listGenre"/>"><i class="fa fa-fw"></i> Genres</a>
                        </li>
						<li>
                            <a href="<c:url value="/listArtist"/>"><i class="fa fa-fw"></i> Artists</a>
                        </li>
						<li>
                            <a href="<c:url value="/listTitle"/>"><i class="fa fa-fw"></i> Titles</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
