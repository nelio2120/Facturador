<?php


class Provincia
{
    public $idprovincia,$nombre,$estado;

    /**
     * Provincia constructor.
     * @param $idprovincia
     * @param $nombre
     * @param $estado
     */
    public function __construct($idprovincia, $nombre, $estado)
    {
        $this->idprovincia = $idprovincia;
        $this->nombre = $nombre;
        $this->estado = $estado;
    }

    /**
     * @return mixed
     */
    public function getIdprovincia()
    {
        return $this->idprovincia;
    }

    /**
     * @param mixed $idprovincia
     */
    public function setIdprovincia($idprovincia)
    {
        $this->idprovincia = $idprovincia;
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