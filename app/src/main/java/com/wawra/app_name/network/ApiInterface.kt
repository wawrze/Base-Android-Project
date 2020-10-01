package com.wawra.app_name.network

import com.wawra.app_name.network.models.ModelResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("/model")
    fun getModels(): Single<List<ModelResponse>>

}