<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
require 'CORE/Equipo.php';
$data = BDD::QUERY("select * from equipo");

foreach ($data as $e){
    $new = new Equipo($e['idequipo'],$e['serie'],$e['modelo'],$e['idestatus'],$e['idbanco']);
    $array[]= $new;
}


if ($array) {
    $array = array("equipo" => $array);
    echo json_encode($array, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}