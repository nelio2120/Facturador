<?php


class Ciudad
{
    public $idciudad;
    public $nombre;
    public $idprovincia;
    public $estado;

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


    /**
     * Ciudad constructor.
     * @param $idciudad
     * @param $nombre
     * @param $idprovincia
     */
    public function __construct($idciudad, $nombre, $idprovincia,$estado)
    {
        $this->idciudad = $idciudad;
        $this->nombre = $nombre;
        $this->idprovincia = $idprovincia;
        $this->estado = $estado;
    }

    /**
     * @return mixed
     */
    public function getIdciudad()
    {
        return $this->idciudad;
    }

    /**
     * @param mixed $idciudad
     */
    public function setIdciudad($idciudad)
    {
        $this->idciudad = $idciudad;
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



}