<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
require 'CORE/Ciudad.php';
$data = BDD::QUERY("select * from ciudad");

foreach ($data as $e){
    $new = new Ciudad($e['idciudad'],$e['nombre'],$e['idprovincia'],$e['estado']);
    $array[]= $new;
}

if ($array) {
    $array = array("ciudad" => $array);
    echo json_encode($array, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}