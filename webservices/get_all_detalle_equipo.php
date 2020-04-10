<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
require 'CORE/DetalleEquipo.php';
$data = BDD::QUERY("select iddetalle_equipo,idequipo,idcomercio from detalle_equipo");

foreach ($data as $e){
    $new = new DetalleEquipo($e['iddetalle_equipo'],$e['idequipo'],$e['idcomercio']);
    $array[]= $new;
}




if ($array) {
    $array = array("detalle_equipo" => $array);
    echo json_encode($array, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}