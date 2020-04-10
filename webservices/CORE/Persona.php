<?php


class Persona
{
    public $idpersona;
    public $Nombre;
    public $Apellido;
    public $Cedula;
    public $Telefono;
    public $Correo;
    public $Estado;

    /**
     * Persona constructor.
     * @param $idpersona
     * @param $Nombre
     * @param $Apellido
     * @param $Cedula
     * @param $Telefono
     * @param $Correo
     * @param $Estado
     */
    public function __construct($idpersona, $Nombre, $Apellido, $Cedula, $Telefono, $Correo, $Estado)
    {
        $this->idpersona = $idpersona;
        $this->Nombre = $Nombre;
        $this->Apellido = $Apellido;
        $this->Cedula = $Cedula;
        $this->Telefono = $Telefono;
        $this->Correo = $Correo;
        $this->Estado = $Estado;
    }


    /**
     * @return mixed
     */
    public function getIdpersona()
    {
        return $this->idpersona;
    }

    /**
     * @param mixed $idpersona
     */
    public function setIdpersona($idpersona)
    {
        $this->idpersona = $idpersona;
    }

    /**
     * @return mixed
     */
    public function getNombre()
    {
        return $this->Nombre;
    }

    /**
     * @param mixed $Nombre
     */
    public function setNombre($Nombre)
    {
        $this->Nombre = $Nombre;
    }

    /**
     * @return mixed
     */
    public function getApellido()
    {
        return $this->Apellido;
    }

    /**
     * @param mixed $Apellido
     */
    public function setApellido($Apellido)
    {
        $this->Apellido = $Apellido;
    }

    /**
     * @return mixed
     */
    public function getCedula()
    {
        return $this->Cedula;
    }

    /**
     * @param mixed $Cedula
     */
    public function setCedula($Cedula)
    {
        $this->Cedula = $Cedula;
    }

    /**
     * @return mixed
     */
    public function getTelefono()
    {
        return $this->Telefono;
    }

    /**
     * @param mixed $Telefono
     */
    public function setTelefono($Telefono)
    {
        $this->Telefono = $Telefono;
    }

    /**
     * @return mixed
     */
    public function getCorreo()
    {
        return $this->Correo;
    }

    /**
     * @param mixed $Correo
     */
    public function setCorreo($Correo)
    {
        $this->Correo = $Correo;
    }

    /**
     * @return mixed
     */
    public function getEstado()
    {
        return $this->Estado;
    }

    /**
     * @param mixed $Estado
     */
    public function setEstado($Estado)
    {
        $this->Estado = $Estado;
    }




}