package com.example.bloomreachsdk.data

import com.example.bloomreachsdk.data.model.InputFormModel
import com.example.bloomreachsdk.data.model.InputModel

interface InputForm {
    suspend fun createForm(inputFormModel: InputFormModel): Response<InputFormModel>

    fun getForm(formId: Long): Response<InputFormModel?>

    fun editForm(inputFormModel: InputFormModel): Response<Unit>

    fun submitForm(formId: Long): Response<Unit>

    fun addInput(formId: Long, inputModel: InputModel): Response<InputModel>

    fun editInput(inputId: Long, input: InputModel): Response<Unit>

    fun deleteInput(inputId: Long): Response<Unit>

    fun setSubmitButtonLabel(formId: Long, label: String)

    fun setFormFontSize(formId: Long, fontSize: Int)

    fun setFontHexColor(formId: Long, hexColor: String)

    fun setBackgroundHexColor(formId: Long, hexColor: String)

    fun setBackgroundImage(formId: Long, image: String)
}