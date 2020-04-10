
<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
require 'CORE/Provincia.php';
$data = BDD::QUERY("select idProvincia,nombre,estado from provincia");
foreach ($data as $e){
    $new = new Provincia($e['idprovincia'],$e['nombre'],$e['estado']);
    $array[]= $new;
}


if ($array) {
    $array = array("provincia" => $array);
    echo json_encode($array, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}
