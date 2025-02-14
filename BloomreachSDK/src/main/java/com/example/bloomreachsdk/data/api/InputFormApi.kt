package com.example.bloomreachsdk.data.api

import com.example.bloomreachsdk.data.Response
import com.example.bloomreachsdk.data.model.InputFormModel
import com.example.bloomreachsdk.data.model.InputModel

internal interface InputFormApi {

    suspend fun createForm(inputFormModel: InputFormModel): Response<InputFormModel>

    suspend fun getForm(formId: Long): Response<InputFormModel?>

    suspend fun editForm(formId: Long, inputFormModel: InputFormModel): Response<Unit>

    suspend fun submitForm(formId: Long, values: List<String>): Response<Unit>

    suspend fun addInput(formId: Long, inputModel: InputModel): Response<InputModel>

    suspend fun editInput(inputId: Long, input: InputModel): Response<Unit>

    suspend fun deleteInput(inputId: Long): Response<Unit>

    suspend fun setSubmitButtonLabel(formId: Long, label: String): Response<Unit>

    suspend fun setFormFontSize(formId: Long, fontSize: Int): Response<Unit>

    suspend fun setFontHexColor(formId: Long, hexColor: String): Response<Unit>

    suspend fun setBackgroundHexColor(formId: Long, hexColor: String): Response<Unit>

    suspend fun setBackgroundImage(formId: Long, image: String): Response<Unit>
}