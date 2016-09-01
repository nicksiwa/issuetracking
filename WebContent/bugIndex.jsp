<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="robots" content="noindex,follow" />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link rel="stylesheet" type="text/css"
	href="https://siwa.mantishub.io/css/default.css" />
<link rel="stylesheet" type="text/css"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.min.css"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="https://siwa.mantishub.io/css/common_config.php" />
<link rel="stylesheet" type="text/css"
	href="https://siwa.mantishub.io/css/status_config.php" />
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="https://siwa.mantishub.io/css/ace.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://siwa.mantishub.io/css/ace-mantis.css" />
<!--[if lte IE 9]>	<link rel="stylesheet" type="text/css" href="https://siwa.mantishub.io/css/ace-part2.min.css" />
<![endif]-->
<link r el="stylesheet" type="text/css"
	href="https://siwa.mantishub.io/css/ace-skins.min.css" />
<!--[if lte IE 9]>	<link rel="stylesheet" type="text/css" href="https://siwa.mantishub.io/css/ace-ie.min.css" />
<![endif]-->
<link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />
<link rel="search" type="application/opensearchdescription+xml"
	title="MantisBT: Text Search"
	href="https://siwa.mantishub.io/browser_search_plugin.php?type=text" />
<link rel="search" type="application/opensearchdescription+xml"
	title="MantisBT: Issue Id"
	href="https://siwa.mantishub.io/browser_search_plugin.php?type=id" />
<script type="text/javascript" src="/javascript_config.php"></script>
<script type="text/javascript" src="/javascript_translations.php"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"
	integrity="sha256-xNjb53/rY+WmG+4L6tTl9m6PpqknWZvRt0rO1SRnJzw="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="/js/common.js"></script>
<meta http-equiv="Refresh"
	content="1800; URL=https://siwa.mantishub.io/my_view_page.php?refresh=true" />

<title>Insert title here</title>
</head>
<body>



	<div id="navbar"
		class="navbar navbar-default navbar-collapse navbar-fixed-top">
		<div id="navbar-container" class="navbar-container">
			<div class="navbar-header pull-left">
				<a href="my_view_page.php" class="navbar-brand"><span
					class="smaller-75"> Bug Tracking </span></a>
				<button type="button"
					class="navbar-toggle navbar-toggle-img collapsed pull-right"
					data-toggle="collapse" data-target=".navbar-buttons,.navbar-menu">
					<span class="sr-only">Toggle user menu</span><img
						class="nav-user-photo"
						src="https://secure.gravatar.com/avatar/c9775e2c16cd901bbd955f11ea8e3d2d?d=identicon&amp;r=G&amp;s=32"
						alt="administrator" />
				</button>
				<button type="button"
					class="small navbar-toggle menu-toggler pull-right grey"
					id="menu-toggler">
					<span class="sr-only">Toggle sidebar</span><span class="icon-bar"></span><span
						class="icon-bar"></span><span class="icon-bar"></span>
				</button>
			</div>
			<div class="hidden-xs">
				<div
					class="navbar-buttons navbar-header pull-right navbar-collapse collapse">
					<ul class="nav ace-nav">
						<li class="hidden-sm hidden-xs"><div
								class="btn-group btn-corner padding-right-8 padding-left-8">
								<a class="btn btn-primary btn-sm" href="bug_report_page.php"><i
									class="fa fa-edit"></i> Report Issue</a><a
									class="btn btn-primary btn-sm"
									href="manage_user_create_page.php"><i
									class="fa fa-user-plus"></i> Invite Users</a></li>
						<li class="grey"><a data-toggle="dropdown" href="#"
							class="dropdown-toggle"> &#160;MyProject&#160; <i
								class="ace-icon fa fa-angle-down bigger-110"></i>
						</a>
							<ul
								class="dropdown-menu dropdown-menu-right dropdown-yellow dropdown-caret dropdown-close">
								<li><a href="/set_project.php?project_id=0"><i
										class="ace-icon fa fa-circle-o"></i> All Projects </a></li>
								<li class="divider"></li>
								<li><a href="/set_project.php?project_id=1"
									selected="selected"><i class="ace-icon fa fa-dot-circle-o"></i>
										MyProject </a></li>
								<li><a href="/set_project.php?project_id=2"><i
										class="ace-icon fa fa-circle-o"></i> Test </a></li>
							</ul></li>
						<li class="grey"><a data-toggle="dropdown" href="#"
							class="dropdown-toggle"><span class="user-info">administrator</span><i
								class="ace-icon fa fa-angle-down"></i></a>
							<ul
								class="user-menu dropdown-menu dropdown-menu-right dropdown-yellow dropdown-caret dropdown-close">
								<li><a href="/account_page.php"><i
										class="ace-icon fa fa-user"> </i> My Account</a></li>

								<li class="divider"></li>
								<li><a href="/logout_page.php"><i
										class="ace-icon fa fa-sign-out"> </i> Logout</a></li>
							</ul></li>
						<li class="grey"><a id="help-widget"
							href="http://support.mantishub.com/hc/en-us/" target="blank"><i
								class="ace-icon fa fa fa-question bigger-150"></i></a></li>
					</ul>
				</div>
			</div>
			<div class="hidden-sm hidden-md hidden-lg">
				<div class="navbar-menu pull-left navbar-collapse collapse"
					role="navigation" style="height: auto;">
					<ul class="nav navbar-nav">
						<li class="grey"><a data-toggle="dropdown" href="#"
							class="dropdown-toggle">&#160;administrator&#160; <i
								class="ace-icon fa fa-angle-down bigger-110"></i></a>
							<ul
								class="user-menu dropdown-menu dropdown-menu-right dropdown-yellow dropdown-caret dropdown-close">
								<li><a href="/account_page.php"><i
										class="ace-icon fa fa-user"> </i> My Account</a></li>
						
								<li class="divider"></li>
								<li><a href="/logout_page.php"><i
										class="ace-icon fa fa-sign-out"> </i> Logout</a></li>
							</ul></li>
						<li class="grey"><a data-toggle="dropdown" href="#"
							class="dropdown-toggle"> &#160;MyProject&#160; <i
								class="ace-icon fa fa-angle-down bigger-110"></i>
						</a>
							<ul
								class="dropdown-menu dropdown-menu-right dropdown-yellow dropdown-caret dropdown-close">
								<li><a href="/set_project.php?project_id=0"><i
										class="ace-icon fa fa-circle-o"></i> All Projects </a></li>
								<li class="divider"></li>
								<li><a href="/set_project.php?project_id=1"
									selected="selected"><i class="ace-icon fa fa-dot-circle-o"></i>
										MyProject </a></li>
								<li><a href="/set_project.php?project_id=2"><i
										class="ace-icon fa fa-circle-o"></i> Test </a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>




<div class="main-container" id="main-container">


	
	
	
	
	<div id="assigned" class="widget-box widget-color-blue2 ">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="view_all_set.php?type=1&amp;temporary=y&amp;handler_id=1&amp;hide_status=80">Assigned to Me (Unresolved)</a><span class="badge">  0 - 0 / 0  </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa fa-chevron-up bigger-125"></i>
			</a>
		</div>
	</div>
	
	<div class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>
<tr><td>&#160;</td></tr></tbody>
</table>
	</div>
	</div>
	</div>
			<div class="widget-toolbox padding-8 clearfix">
				0 issues <a class="btn btn-xs btn-primary btn-white btn-round" href="view_all_set.php?type=1&temporary=y&handler_id=1&hide_status=80">
			View Issues		</a>
	</div>
</div>
</div>

<div class="space-10"></div><div id="reported" class="widget-box widget-color-blue2 ">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="view_all_set.php?type=1&amp;temporary=y&amp;reporter_id=1&amp;hide_status=90">Reported by Me</a><span class="badge">  0 - 0 / 0  </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa fa-chevron-up bigger-125"></i>
			</a>
		</div>
	</div>

	<div class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>
<tr><td>&#160;</td></tr></tbody>
</table>
	</div>
	</div></div></div>
	
	
	

		<script type="text/javascript"
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
			integrity="sha256-KXn5puMvxCw+dAYznun+drMdG1IFl3agK0p/pqT9KAo="
			crossorigin="anonymous"></script>
		<script type="text/javascript" src="/js/ace-extra.min.js"></script>
		<script type="text/javascript" src="/js/ace-elements.min.js"></script>
		<script type="text/javascript" src="/js/ace.min.js"></script>
		<script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
ga('create', 'UA-330112-9', 'mantishub.com');
ga('send', 'pageview');
</script>
		<script type="text/javascript">
/* <![CDATA[ */
var google_conversion_id = 970248102;
var google_conversion_language = "en";
var google_conversion_format = "3";
var google_conversion_color = "ffffff";
var google_conversion_label = "eQWuCIrG5AkQpp_TzgM";
var google_remarketing_only = false;
/* ]]> */
</script>
		<script type="text/javascript"
			src="//www.googleadservices.com/pagead/conversion.js">
</script>
		<noscript>
			<div style="display: inline;">
				<img height="1" width="1" style="border-style: none;" alt=""
					src="//www.googleadservices.com/pagead/conversion/970248102/?label=eQWuCIrG5AkQpp_TzgM&guid=ON&script=0" />
			</div>
		</noscript>
		<script>(function(w,d,t,r,u){var f,n,i;w[u]=w[u]||[],f=function(){var o={ti:"4061542"};o.q=w[u],w[u]=new UET(o),w[u].push("pageLoad")},n=d.createElement(t),n.src=r,n.async=1,n.onload=n.onreadystatechange=function(){var s=this.readyState;s&&s!=="loaded"&&s!=="complete"||(f(),n.onload=n.onreadystatechange=null)},i=d.getElementsByTagName(t)[0],i.parentNode.insertBefore(n,i)})(window,document,"script","//bat.bing.com/bat.js","uetq");</script>
		<noscript>
			<img src="//bat.bing.com/action/0?ti=4061542&Ver=2" height="0"
				width="0" style="display: none; visibility: hidden;" />
		</noscript>
		<script type="text/javascript">
  var _dcq = _dcq || [];
  var _dcs = _dcs || {};
  _dcs.account = '4007299';

  (function() {
    var dc = document.createElement('script');
    dc.type = 'text/javascript'; dc.async = true;
    dc.src = '//tag.getdrip.com/4007299.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(dc, s);

    window._dcq = window._dcq || [];
    window._dcq.push(["identify", {
      email: "t_tinfinity@hotmail.com"
    }]);
    window._dcq.push(["track", "Started a Trial", { value: 1500 }]);
  })();
</script>
</body>
</html>