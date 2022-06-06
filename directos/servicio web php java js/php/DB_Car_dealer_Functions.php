<?php

class DB_Car_dealer_Functions
{

  private $db;


  function __construct()
  {
    require_once 'DB_Connect.php';
    $this->db = new DB_Connect();
    $this->db->connect();
  }

  function __destruct()
  {
  }
  // Get the cars sold in a delegation
  public function getCarsByDelegation($idDelegation)
  {
    $con = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
    $result = mysqli_query($con, "select
          c.id_car,
          c.model,
          c.doors,
          c.horse_power,
          c.max_speed,
          c.price
        from
          salesman sm,  sale s,  car c
        where
          sm.id_delegation = $idDelegation
          and sm.id_salesman = s.id_salesman
          and s.id_car = c.id_car") or die(mysqli_error($con));
    // Be ensure that the query was executed right
    $no_of_rows = mysqli_num_rows($result);
    if ($no_of_rows > 0) {
      return $result;
    } else {
      return false;
    }
  }

  function getCustomers(){
    $con = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
    
    $sql = "SELECT id_customer, first_name, last_name ";
    $sql .= "FROM customer";
    
    $result = mysqli_query($con, $sql) or die(mysqli_error($con));

    $no_of_rows = mysqli_num_rows($result);
    if ($no_of_rows > 0) {
      return $result;
    } else {
      return false;
    }
  }

  function getCarsByCustomer($idCustomer){
    $con = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
    
    $sql = "SELECT c.model, c.horse_power, s.sale_date, d.city  ";
    $sql .= "FROM car c, sale s, salesman sa, delegation d ";
    $sql .= "WHERE c.id_car = s.id_car ";
    $sql .= "and s.id_salesman = sa.id_salesman ";
    $sql .= "and sa.id_delegation = d.id_delegation ";
    $sql .= "and s.id_customer = {$idCustomer}";
    
    $result = mysqli_query($con, $sql) or die(mysqli_error($con));

    $no_of_rows = mysqli_num_rows($result);
    if ($no_of_rows > 0) {
      return $result;
    } else {
      return false;
    }
  }

  function deleteSalesman($DNI)
  {

    $con = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);

    $sql = "DELETE FROM salesman ";
    $sql .= "WHERE DNI = '" . $DNI . "'";

    mysqli_query($con, $sql) or die(mysqli_error($con));;

    $no_affected_rows = mysqli_affected_rows($con);

    $con->close();

    return $no_affected_rows > 0;
  }
}
