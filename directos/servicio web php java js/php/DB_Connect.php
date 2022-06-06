<?php
 
class DB_Connect {

    function __construct() {
 
    }

    function __destruct() {
        $this->close();
    }

    public function connect() {
        require_once 'config.php';
        $con = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
        mysqli_select_db($con, DB_DATABASE);
 
        return $con;
    }
 
    public function close() {
        $con = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
        mysqli_close($con);
    }
 
}
 
?>