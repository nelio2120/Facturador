<?php


class Estatus
{
    public $idestatus;
    public $nombre;
    public $estado;

    /**
     * Estatus constructor.
     * @param $idestatus
     * @param $descripcion
     * @param $estado
     */
    public function __construct($idestatus, $descripcion, $estado)
    {
        $this->idestatus = $idestatus;
        $this->nombre = $descripcion;
        $this->estado = $estado;
    }

    /**
     * @return mixed
     */
    public function getIdestatus()
    {
        return $this->idestatus;
    }

    /**
     * @param mixed $idestatus
     */
    public function setIdestatus($idestatus)
    {
        $this->idestatus = $idestatus;
    }

    /**
     * @return mixed
     */
    public function getDescripcion()
    {
        return $this->nombre;
    }

    /**
     * @param mixed $descripcion
     */
    public function setDescripcion($descripcion)
    {
        $this->nombre = $descripcion;
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