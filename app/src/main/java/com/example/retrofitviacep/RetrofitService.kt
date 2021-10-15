package com.example.retrofitviacep

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    // Método que será responsável por
    // Chamar a api
    // https://viacep.com.br/ws/01001000/json/
    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") cep: String) :  Call<Cep>

    @GET("{uf}/{cidade}/{logradouro}/json")
    fun getCEPByLogradouro(
                    @Path("uf") uf: String,
                    @Path("cidade") cidade: String,
                    @Path("logradouro")logradouro: String)


}