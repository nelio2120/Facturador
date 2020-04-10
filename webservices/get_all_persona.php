
<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
include 'CORE/Persona.php';
$id = isset($_GET['id'])?$_GET['id']:false;
if ($id){
    $id = "where idpersona = $id";
}else{
    $id = "";
}
$data = BDD::QUERY("select idpersona,nombre,apellido,cedula,telefono,correo,estado from persona $id");

foreach ($data as $v)
{
    $class = new Persona($v['idpersona'],$v['nombre'],$v['apellido'],$v['cedula'],$v['telefono'],$v['correo'],$v['estado']);
    $array[] = $class;
}







if ($array) {
    $datos = array("persona"=>$array);
    echo json_encode($datos, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}