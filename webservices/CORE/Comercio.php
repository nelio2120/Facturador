<?php


class Comercio
{
    public $idcomercio;
    public $codigo;
    public $nombre_comercial;
    public $estado;
    public $direccion,$idciudad,$correo,$telefono,$idusuario;

    /**
     * Comercio constructor.
     * @param $idcomercio
     * @param $codigo
     * @param $nombre_comercial
     * @param $estado
     * @param $direccion
     * @param $idciudad
     * @param $correo
     * @param $telefono
     * @param $idusuario
     */
    public function __construct($idcomercio, $codigo, $nombre_comercial, $estado, $direccion, $idciudad, $correo, $telefono, $idusuario)
    {
        $this->idcomercio = $idcomercio;
        $this->codigo = $codigo;
        $this->nombre_comercial = $nombre_comercial;
        $this->estado = $estado;
        $this->direccion = $direccion;
        $this->idciudad = $idciudad;
        $this->correo = $correo;
        $this->telefono = $telefono;
        $this->idusuario = $idusuario;
    }

    /**
     * @return mixed
     */
    public function getIdcomercio()
    {
        return $this->idcomercio;
    }

    /**
     * @param mixed $idcomercio
     */
    public function setIdcomercio($idcomercio)
    {
        $this->idcomercio = $idcomercio;
    }

    /**
     * @return mixed
     */
    public function getCodigo()
    {
        return $this->codigo;
    }

    /**
     * @param mixed $codigo
     */
    public function setCodigo($codigo)
    {
        $this->codigo = $codigo;
    }

    /**
     * @return mixed
     */
    public function getNombreComercial()
    {
        return $this->nombre_comercial;
    }

    /**
     * @param mixed $nombre_comercial
     */
    public function setNombreComercial($nombre_comercial)
    {
        $this->nombre_comercial = $nombre_comercial;
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

    /**
     * @return mixed
     */
    public function getDireccion()
    {
        return $this->direccion;
    }

    /**
     * @param mixed $direccion
     */
    public function setDireccion($direccion)
    {
        $this->direccion = $direccion;
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
    public function getCorreo()
    {
        return $this->correo;
    }

    /**
     * @param mixed $correo
     */
    public function setCorreo($correo)
    {
        $this->correo = $correo;
    }

    /**
     * @return mixed
     */
    public function getTelefono()
    {
        return $this->telefono;
    }

    /**
     * @param mixed $telefono
     */
    public function setTelefono($telefono)
    {
        $this->telefono = $telefono;
    }

    /**
     * @return mixed
     */
    public function getIdusuario()
    {
        return $this->idusuario;
    }

    /**
     * @param mixed $idusuario
     */
    public function setIdusuario($idusuario)
    {
        $this->idusuario = $idusuario;
    }



}