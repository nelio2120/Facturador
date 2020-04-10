<?php


class CrudDetalleEquipo
{
    public static function Insertar($array)
    {
        $id = BDD::INSERTAR_DESDE_ARRAY("detalle_equipo",$array);
        if($id){
            return array("id"=>$id);
        }else{
            return array("id"=>0);
        }
    }
    public static function Actualizar($array,$iddetalle)
    {
        $id = BDD::ACTUALIZAR_DESDE_ARRAY("detalle_equipo",$array,"iddetalle_equipo=$iddetalle");
        if($id){
            return array("id"=>$id);
        }else{
            return array("id"=>0);
        }
    }
}