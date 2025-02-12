package com.example.bloomreachsdk.data.api

import com.example.bloomreachsdk.data.Response
import com.example.bloomreachsdk.data.model.InputFormModel

internal class InputFormApiImpl : InputFormApi {
    override suspend fun createForm(inputFormModel: InputFormModel): Response<InputFormModel> {
        return Response.Success(inputFormModel)
    }
}