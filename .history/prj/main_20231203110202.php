<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />

    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="menu.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.js"
        integrity="sha512-+k1pnlgt4F1H8L7t3z95o3/KO+o78INEcXTbnoJQ/F2VqDVhWoaiVml/OEHv9HsVgxUaVW+IbiZPUJQfF/YxZw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="script.js"></script>
    <link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css"
        rel="stylesheet" />
</head>

<body data-bs-theme="dark">
    <nav class="navbar bg-body-tertiary" role="navigation">
        <div id="menuToggle">
            <input type="checkbox" />

            <!--
          Przycisk
          -->
            <span></span>
            <span></span>
            <span></span>

            <ul id="menu">
                <li>
                    <input type="checkbox" id="theme-mode" checked data-toggle="toggle" data-on="Light" data-off="Dark"
                        data-onstyle="dark" data-offstyle="light" data-style="border" />
                    <script>
                    $(function() {
                        $("#theme-mode").change(function() {
                            if (document.body.getAttribute("data-bs-theme") == "dark") {
                                document.body.setAttribute("data-bs-theme", "light");
                            } else {
                                document.body.setAttribute("data-bs-theme", "dark");
                            }
                        });
                    });
                    </script>
                </li>
            </ul>
        </div>
        <div class="text">w3c</div>
    </nav>

    <?php
    
    $user = $_POST["username"];
    echo $user

    ?>

    <script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
    </script>
</body>

</html>