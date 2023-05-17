<?php
    $servername = "localhost";
    $username_db = "root";
    $password_db = "admin";
    $dbname = "formacion_qa";

    $conn = mysqli_connect($servername, $username_db, $password_db, $dbname);

    if (!$conn) {
        die("Conexión fallida: " . $conn->connect_error);
    }
?>
