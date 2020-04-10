<?php


class Banco
{
    public $idbanco,$descripcion,$estado;

    /**
     * Banco constructor.
     * @param $idbanco
     * @param $descripcion
     * @param $estado
     */
    public function __construct($idbanco, $descripcion, $estado)
    {
        $this->idbanco = $idbanco;
        $this->descripcion = $descripcion;
        $this->estado = $estado;
    }

    /**
     * @return mixed
     */
    public function getIdbanco()
    {
        return $this->idbanco;
    }

    /**
     * @param mixed $idbanco
     */
    public function setIdbanco($idbanco)
    {
        $this->idbanco = $idbanco;
    }

    /**
     * @return mixed
     */
    public function getDescripcion()
    {
        return $this->descripcion;
    }

    /**
     * @param mixed $descripcion
     */
    public function setDescripcion($descripcion)
    {
        $this->descripcion = $descripcion;
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