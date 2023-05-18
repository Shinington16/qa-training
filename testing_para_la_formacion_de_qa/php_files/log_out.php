<?php
    session_start();
    session_destroy();
    header('Location: ../html_files/log_in.html');
    exit;
?>