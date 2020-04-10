package com.example.facturador.Activity.API.Services;


import com.example.facturador.Activity.Model.BancoSerializer;
import com.example.facturador.Activity.Model.CiudadSerializable;
import com.example.facturador.Activity.Model.ComercioSerializable;
import com.example.facturador.Activity.Model.DetalleEquipoSerializable;
import com.example.facturador.Activity.Model.EquipoSerializable;
import com.example.facturador.Activity.Model.EstatusSerializable;
import com.example.facturador.Activity.Model.PersonaSerializer;
import com.example.facturador.Activity.Model.ProvinciaSerializable;
import com.example.facturador.Activity.Model.RolSerializer;
import com.example.facturador.Activity.Model.Sincronizacion;
import com.example.facturador.Activity.Model.UserDeserializer;
import com.example.facturador.Activity.Model.Usuarios;
import com.google.gson.Gson;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Service {

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<UserDeserializer> getUsuario();

    @GET("/webservices/trunk/Proyecto_Facturas/get_usuario.php")
    Call<UserDeserializer> getUsuario(@Query("usuario") String usuario);

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_rol.php")
    Call<RolSerializer> getRol();

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_entidad_bancaria.php")
    Call<BancoSerializer> getBanco();

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_estatus.php")
    Call<EstatusSerializable> getEstatus();


    @GET("/webservices/trunk/Proyecto_Facturas/get_all_equipo.php")
    Call<EquipoSerializable> getEquipo();

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_comercio.php")
    Call<ComercioSerializable> getComercio();

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_provincia.php")
    Call<ProvinciaSerializable> getProvincia();

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_ciudad.php")
    Call<CiudadSerializable> getCiudad();


    @GET("/webservices/trunk/Proyecto_Facturas/get_all_detalle_equipo.php")
    Call<DetalleEquipoSerializable> getDetalle();

    @GET("/webservices/trunk/Proyecto_Facturas/get_all_persona.php")
    Call<PersonaSerializer> getPersona();



    @POST("/webservices/trunk/Proyecto_Facturas/insertar_usuario.php")
    @FormUrlEncoded
    Call<Sincronizacion> setUsuario(@Field("json") String json);


    @POST("/webservices/trunk/Proyecto_Facturas/insertar_detalle.php")
    @FormUrlEncoded
    Call<Sincronizacion> setDetalle(@Field("json") String json);
}
