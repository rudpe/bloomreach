package com.example.bloomreachsdk.data.api

import com.example.bloomreachsdk.data.Response
import com.example.bloomreachsdk.data.model.InputFormModel
import com.example.bloomreachsdk.data.model.InputModel
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

internal interface InputFormApi {
    //@POST("v1/input-form")
    suspend fun createForm(inputFormModel: InputFormModel): Response<InputFormModel>

    /*@GET("v1/input-form/{id}")
    suspend fun getForm(@Path("id") formId: Long): Response<InputFormModel?>

    @PUT("v1/input-form/{id}")
    suspend fun editForm(@Path("id") formId: Long, @Body inputFormModel: InputFormModel): Response<Unit>

    @POST("v1/input-form/{id}/submit")
    suspend fun submitForm(@Path("id") formId: Long, @Body values: List<String>): Response<Unit>

    @POST("v1/input-form/{id}/input")
    suspend fun addInput(@Path("id") formId: Long, @Body inputModel: InputModel): Response<InputModel>

    @PUT("v1/input-form/{formId}/input")
    suspend fun editInput(@Path("formId") inputId: Long, @Body input: InputModel): Response<Unit>

    @DELETE("v1/input-form/{formId}/input/{inputId}")
    suspend fun deleteInput(@Path("formId") formId: Long, @Path("inputId") inputId: Long): Response<Unit>

    @PUT("v1/input-form/{formId}/label")
    suspend fun setSubmitButtonLabel(formId: Long, @Body label: String)

    @PUT("v1/input-form/{formId}/font-size")
    suspend fun setFormFontSize(formId: Long, @Body fontSize: Int)

    @PUT("v1/input-form/{formId}/font-hex-color")
    suspend fun setFontHexColor(formId: Long, @Body hexColor: String)

    @PUT("v1/input-form/{formId}/background-hex-color")
    suspend fun setBackgroundHexColor(formId: Long, @Body hexColor: String)

    @PUT("v1/input-form/{formId}/image")
    suspend fun setBackgroundImage(formId: Long, image: String)*/
}