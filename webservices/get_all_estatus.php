<?php

header('Content-type: application/json');
require 'BASE/BDD.php';
require 'CORE/Estatus.php';
$data = BDD::QUERY("select * from estatus");

foreach ($data as $e){
    $new = new Estatus($e['idestatus'],$e['nombre'],$e['estado']);
    $array[]= $new;
}

if ($array) {
    $array = array("estatus" => $array);
    echo json_encode($array, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else {

}