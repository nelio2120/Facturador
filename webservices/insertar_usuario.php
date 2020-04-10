<?php
include "CORE/CrudUsuario.php";
$json = isset($_POST['json'])?$_POST['json']:false;

if($json){
    $var = json_decode($json,true);
    foreach ($var as $e) {
        $array = array("usuario" => $e['usuario']
        , "clave" => $e['clave'], "idrol"=> $e['rol']
        , "idpersona" => $e['persona']);
        $idbase = $e['idbase'];
        if($idbase == 0)
            $id = CrudUsuario::Insertar($array);
        else
            $id = CrudUsuario::Actualizar($array,$idbase);
        echo json_encode($id,JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
    }
}else{
    echo json_encode(json_encode($json),JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);;
}


