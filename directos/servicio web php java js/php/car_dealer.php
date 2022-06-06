<?php

/**
 * POST request
 */
if (isset($_POST['tag']) && $_POST['tag'] != '') {
    // tag
    $tag = $_POST['tag'];

    require_once 'DB_Car_dealer_Functions.php';
    $db = new DB_Car_dealer_Functions();

    // Array response in json
    $response = array("tag" => $tag, "success" => 0, "error" => 0);
    // tag evaluation
    if ($tag == 'getCarsByDelegation') {
        // Get the arguments
        $idDelegation = $_POST['idDelegation'];

        $cars = $db->getCarsByDelegation($idDelegation);
        if ($cars != false) {
            // json with success = 1
            $response = array("cars" => array());
            while ($row = mysqli_fetch_array($cars)) {
                array_push($response['cars'], array(
                    'id_car' => $row['id_car'],
                    'model' => $row['model'], 'horse_power' => $row['horse_power'],
                    'max_speed' => $row['max_speed'], 'doors' => $row['doors'], 'price' => $row['price']
                ));
            }
            $response["success"] = 1;
            $response["tag"] = "getCarsByDelegation";
            echo json_encode($response);
        } else {
            // json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "No existen coches para la delegación indicada";
            echo json_encode($response);
        }
    } else if ($tag == 'getDelegations') {
        $delegations = $db->getDelegations();
        if ($delegations != false) {
            // json with success = 1
            $response = array("delegations" => array());
            while ($row = mysqli_fetch_array($cars)) {
                array_push($response['delegations'], array('id_delegation' => $row['id_delegation'], 'city' => utf8_encode($row['city'])));
            }
            $response["success"] = 1;
            $response["tag"] = "getDelegations";
            echo json_encode($response);
        } else {
            // json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "No existen delegaciones";
            echo json_encode($response);
        }
    } else if ($tag == 'deleteSalesman') {
        // Get the arguments
        $DNI = $_POST['DNI'];
        $success = $db->deleteSalesman($DNI);

        $data = array("success" => $success);

        if (!$success) {
            $data["error_msg"] = "No existe ese DNI";
        }

        echo json_encode($data);
    } else if ($tag == 'getCustomers') {

        $customers = $db->getCustomers();
        if ($customers != false) {
            // json with success = 1
            $response = array("customers" => array());

            while ($row = mysqli_fetch_array($customers)) {

                $dataRow = array(
                    'id_customer' => $row['id_customer'],
                    'first_name' => utf8_encode($row['first_name']),
                    'last_name' => utf8_encode($row['last_name'])
                );
                array_push(
                    $response['customers'],
                    $dataRow
                );
            }
            $response["success"] = 1;
            $response["tag"] = "getCustomers";
            echo json_encode($response);
        } else {
            // json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "No existen clientes";
            echo json_encode($response);
        }
    } else if ($tag == 'getCarsByCustomer') {

        $id_Customer = $_POST['idCustomer'];

        $cars = $db->getCarsByCustomer($id_Customer);
        if ($cars != false) {
            // json with success = 1
            $response = array("cars" => array());

            while ($row = mysqli_fetch_array($cars)) {
                array_push(
                    $response['cars'],
                    array(
                        'model' => utf8_encode($row['model']),
                        'horse_power' => $row['horse_power'],
                        'sale_date' => $row['sale_date'],
                        'city' =>  utf8_encode($row['city'])
                    )
                );
            }
            $response["success"] = 1;
            $response["tag"] = "getCarsByCustomer";
            echo json_encode($response);
        } else {
            // json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "No existen compras";
            echo json_encode($response);
        }
    } else {
        echo "Petición no válida";
    }
} else {
    echo "Acceso denegado";
}

// if (isset($_GET['tag']) && $_GET['tag'] != '') {

//     $tag = $_GET['tag'];

//     require_once 'DB_Car_dealer_Functions.php';
//     $db = new DB_Car_dealer_Functions();

//     // Array response in json
//     $response = array("tag" => $tag, "success" => 0, "error" => 0);

//     if ($tag == 'getCustomers') {

//         $customers = $db->getCustomers();

//         if ($customers != false) {
//             // json with success = 1
//             $response = array("customers" => array());
//             while ($row = mysqli_fetch_array($customers)) {

//                 $dataRow = array(
//                     'id_customer' => $row['id_customer'],
//                     'first_name' => utf8_encode($row['first_name']),
//                     'last_name' => utf8_encode($row['last_name'])
//                 );
//                 array_push(
//                     $response['customers'],
//                     $dataRow
//                 );

                
//             }
//             $response["success"] = 1;
//             $response["tag"] = "getCustomers";
//             echo json_encode($response);
//         } else {
//             // json with error = 1
//             $response["error"] = 1;
//             $response["error_msg"] = "No existen clientes";
//             echo json_encode($response);
//         }
//     } else if ($tag == 'getCarsByCustomer') {

//         $id_Customer = $_POST['idCustomer'];

//         $cars = $db->getCarsByCustomer($id_Customer);
//         if ($customers != false) {
//             // json with success = 1
//             $response = array("cars" => array());

//             while ($row = mysqli_fetch_array($cars)) {
//                 array_push(
//                     $response['cars'],
//                     array(
//                         'model' => $row['model'],
//                         'horse_power' => $row['horse_power'],
//                         'sale_date' => $row['sale_date'],
//                         'city' =>  $row['city']
//                     )
//                 );
//             }
//             $response["success"] = 1;
//             $response["tag"] = "getCarsByCustomer";
//             echo json_encode($response);
//         } else {
//             // json with error = 1
//             $response["error"] = 1;
//             $response["error_msg"] = "No existen compras";
//             echo json_encode($response);
//         }
//     }
// }
// // }
