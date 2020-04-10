<?php


class DetalleEquipo
{
    public $iddetalle_equipo,$idequipo,$idcomercio,$estado;

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
     * DetalleEquipo constructor.
     * @param $iddetalle_equipo
     * @param $idequipo
     * @param $idcomercio
     */
    public function __construct($iddetalle_equipo, $idequipo, $idcomercio)
    {
        $this->iddetalle_equipo = $iddetalle_equipo;
        $this->idequipo = $idequipo;
        $this->idcomercio = $idcomercio;
    }

    /**
     * @return mixed
     */
    public function getIddetalleEquipo()
    {
        return $this->iddetalle_equipo;
    }

    /**
     * @param mixed $iddetalle_equipo
     */
    public function setIddetalleEquipo($iddetalle_equipo)
    {
        $this->iddetalle_equipo = $iddetalle_equipo;
    }

    /**
     * @return mixed
     */
    public function getIdequipo()
    {
        return $this->idequipo;
    }

    /**
     * @param mixed $idequipo
     */
    public function setIdequipo($idequipo)
    {
        $this->idequipo = $idequipo;
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


}