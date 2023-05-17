<?php

    include("conection.php");

    header('Content-Type: text/html; charset=UTF-8');

    $username_form = $_POST['username'];
    $password_form = $_POST['password'];

    if(isset($_POST["btn-login"])) {
        $query = "SELECT pass FROM users WHERE user = '$username_form'";
        $sql = mysqli_query($conn, $query);
        $row = mysqli_fetch_assoc($sql)["pass"];

        switch ($row) {
            case 'form1234':
                echo "<script>window.location='../html_files/formAndRadio.html'</script>";
                break;
            case 'button1234':
                echo "<script>window.location='../html_files/button.html'</script>";
                break;
            case 'dinamic1234':
                echo "<script>window.location='../html_files/dinamicElements.html'</script>";
                break;
            case 'modal1234':
                echo "<script>window.location='../html_files/modalWindow.html'</script>";
                break;
            case 'alert1234':
                echo "<script> alert('Bienvenido a la página'); window.location='../html_files/alertWindow.html'</script>";
                break;
            case 'menu1234':
                echo "<script>window.location='../html_files/menu&list.html'</script>";
                break;
            case 'input1234':
                echo "<script>window.location='../html_files/otherInput.html'</script>";
                break;
            case 'moving1234':
                echo "<script>window.location='../html_files/movingElements.html'</script>";
                break;
            default:
            echo "<script> window.location='../html_files/log-in.html'; alert('Nombre de usuario o contraseña incorrecta');</script>";
        }
        $conn->close();
    }
?>