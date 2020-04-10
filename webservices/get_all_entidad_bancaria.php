<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
require 'CORE/Banco.php';
$data = BDD::QUERY("select identidad_bancaria as idbanco,descripcion,estado from entidad_bancaria");

foreach ($data as $e){
    $new = new Banco($e['idbanco'],$e['descripcion'],$e['estado']);
    $array[]= $new;
}


if ($array) {
    $array = array("entidad_bancaria" => $array);
    echo json_encode($array, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}
