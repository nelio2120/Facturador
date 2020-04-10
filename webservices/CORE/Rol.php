<?php


class Rol
{
    public $idrol;
    public $nombre;
    public $estado;


    public function getIdrol()
    {
        return $this->idrol;
    }

    /**
     * @param mixed $idrol
     */
    public function setIdrol($idrol)
    {
        $this->idrol = $idrol;
    }

    /**
     * @return mixed
     */
    public function getNombre()
    {
        return $this->nombre;
    }

    /**
     * @param mixed $nombre
     */
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    /**
     * @return mixed
     */
    public function getEstado()
    {
        return $this->estado;
    }

    /**
     * @param mixed $estado
     */
    public function setEstado($estado)
    {
        $this->estado = $estado;
    }



}