<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="/webjars/popper.js/1.15.0/umd/popper.js"></script>
    <script src="/webjars/popper.js/1.15.0/umd/popper-utils.js"></script>
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/webjars/datatables/1.10.12/js/jquery.dataTables.js"></script>
    <script src="/webjars/datatables/1.10.12/js/dataTables.bootstrap4.js"></script>
    <script src="/webjars/datatables/1.10.12/js/dataTables.jqueryui.js"></script>
    <script src="/webjars/datatables/1.10.12/js/dataTables.material.js"></script>
    <script src="/webjars/datatables/1.10.12/js/dataTables.semanticui.js"></script>
    <script src="/webjars/datatables/1.10.12/js/dataTables.uikit.js"></script>



    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/css/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.bootstrap4.css"/>
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.jqueryui.css"/>
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.material.css"/>
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.semanticui.css"/>
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.uikit.css"/>
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/jquery.dataTables.css"/>
    <link rel="stylesheet" href= "/webjars/datatables/1.10.12/css/jquery.dataTables_themeroller.css"/>
    <script type="text/javascript">

        $(document).ready(function() {
            $('[data-toggle="tooltip"]').tooltip()
        });

        function onCLickSearch() {
            var URL = "http://localhost:8080/zemoga_portfolio_api/user_info/";
            if ($('#idEmployee').val() !== '') {
                URL += $('#idEmployee').val();

            }
            var jqxhr = $.ajax(URL)
                .done(function(msg) {
                    $("#photo").attr("src",msg['image']);
                    $("#name").text(msg['name']);
                    $("#description").text(msg['description']);
                    $("#sample").text(msg['twitts']);
                    $("#timeline").text(msg['name'] +'\'s ' +' Timeline');

                })
                .fail(function() {
                    alert( "error" );
                })
                .always(function() {

                });
        }



    </script>

    <style>

        body {
            padding-top: 5rem;
        }

        .starter-template {
            padding: 3rem 1.5rem;
            text-align: center;
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">TestApp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<main role="main" class="container">

    <div class="starter-template">
        <div class="container">
            <div class="row">
                <div class="col-8   ">

                    <h1>Profile User</h1>
                    <p class="lead">Demo App</p>

                </div></div></div>


        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">User Name</span>
                        </div>
                        <input id="idEmployee" type="text" aria-label="Id Empleado" class="form-control">
                        <button class="btn btn-secondary my-2 my-sm-0" onclick="onCLickSearch()" data-toggle="tooltip" >Get Profile</button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">&nbsp;</div>
            </div>

            <div class="row">
                <div class="col-3">
                    <img id="photo"/>
                </div>
                <div class="col-9"><h3 id="name">Perfil</h3>
                        <p id="description"></p>
                </div>
            </div>
            <div class="col-12">
                <h3 id="timeline">TimeLine</h3>
                <span id="sample" class="border"></span>
            </div>
        </div>
    </div>

</main>
</body>
</html>