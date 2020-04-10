<?php
include "BASE/BDD.php";
include "CORE/CrudDetalleEquipo.php";
$json = isset($_POST['json'])?$_POST['json']:false;

if($json){
    $var = json_decode($json,true);
    foreach ($var as $e) {
        $array = array("idequipo" => $e['idequipo']
        , "idcomercio"=> $e['idcomercio']);
        $idbase = $e['id_base'];
        if($idbase == 0)
            $id = CrudDetalleEquipo::Insertar($array);
        else
            $id = CrudDetalleEquipo::Actualizar($array,$idbase);
        echo json_encode($id,JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
    }
}else{
    echo json_encode(json_encode($json),JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);;
}
