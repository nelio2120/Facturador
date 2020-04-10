<?php


class Equipo
{

    public $idequipo,$serie,$modelo,$idestatus,$idbannco;

    /**
     * Equipo constructor.
     * @param $idequipo
     * @param $serie
     * @param $modelo
     * @param $idestatus
     * @param $idbannco
     */
    public function __construct($idequipo, $serie, $modelo, $idestatus, $idbannco)
    {
        $this->idequipo = $idequipo;
        $this->serie = $serie;
        $this->modelo = $modelo;
        $this->idestatus = $idestatus;
        $this->idbannco = $idbannco;
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
    public function getSerie()
    {
        return $this->serie;
    }

    /**
     * @param mixed $serie
     */
    public function setSerie($serie)
    {
        $this->serie = $serie;
    }

    /**
     * @return mixed
     */
    public function getModelo()
    {
        return $this->modelo;
    }

    /**
     * @param mixed $modelo
     */
    public function setModelo($modelo)
    {
        $this->modelo = $modelo;
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
    public function getIdbannco()
    {
        return $this->idbannco;
    }

    /**
     * @param mixed $idbannco
     */
    public function setIdbannco($idbannco)
    {
        $this->idbannco = $idbannco;
    }


}