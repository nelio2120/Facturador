
<?php
header('Content-type: application/json');
require 'BASE/BDD.php';
include "CORE/Rol.php";
$id = isset($_GET['id'])?$_GET['id']:false;
if ($id){
    $id = "where idrol = $id";
}else{
    $id = "";
}
$data = BDD::QUERY("SELECT idrol,nombre,estado from rol $id");

foreach ($data as $v){
    $class = new Rol();
    $class->setIdrol($v['idrol']);
    $class->setNombre($v['nombre']);
    $class->setEstado($v['estado']);
    $array[] = $class;
}

if ($array) {
    $datos = array("roles"=>$array);
    echo json_encode($datos, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}else{
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}