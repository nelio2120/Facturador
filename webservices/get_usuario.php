<?php

header('Content-type: application/json');
require 'BASE/BDD.php';
include "CORE/Usuarios.php";


$id = isset($_GET['usuario'])?$_GET['usuario']:false;
if($id){
    $id = "where usuario='$id'";
}else{
    $id = "";
}

$data = BDD::QUERY("select * from usuarios $id");

foreach ($data as $v)
{

    $usario = new Usuarios($v['idusuarios'],$v['usuario']
        ,$v['clave'],$v['idrol'],$v['idpersona']);
    $array[] = $usario;
}



if ($array) {
    $datas = array("usuarios"=>$array);
    echo json_encode($datas, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
} else {
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}