
<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
require 'CORE/Comercio.php';
$data = BDD::QUERY("select * from comercio");

foreach ($data as $e){
    $new = new Comercio($e['idcomercio'],$e['codigo'],$e['nombre_comercial'],$e['estado'],$e['direccion'] ,$e['ciudad'] ,$e['correo']
        ,$e['telefono_contacto']
        ,$e['idusuarios']);
    $array[]= $new;
}


if ($data) {
    $datos = array("comercio" => $array);
    echo json_encode($datos, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}