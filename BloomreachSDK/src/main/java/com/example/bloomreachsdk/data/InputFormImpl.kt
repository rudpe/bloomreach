package com.example.bloomreachsdk.data

import android.util.Log
import com.example.bloomreachsdk.data.api.InputFormApi
import com.example.bloomreachsdk.data.model.InputFormModel
import com.example.bloomreachsdk.data.model.InputModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class InputFormImpl @Inject constructor(
    private val inputFormApi: InputFormApi
) : InputForm {
    override suspend fun createForm(inputFormModel: InputFormModel): Response<InputFormModel> {
        when (val result = inputFormApi.createForm(inputFormModel)) {
            is Response.Error -> {
                Log.i("CREATE", "Input form wasn't created. Error: ${result.error}")
                return Response.Success(inputFormModel)
            }
            is Response.Success -> {
                Log.i("CREATE", "Input form was created")
                return Response.Success(inputFormModel)
            }
        }
    }

    override fun getForm(formId: Long): Response<InputFormModel?> {
        TODO("Not yet implemented")
    }

    override fun editForm(inputFormModel: InputFormModel): Response<Unit> {
        TODO("Not yet implemented")
    }

    override fun submitForm(formId: Long): Response<Unit> {
        TODO("Not yet implemented")
    }

    override fun addInput(formId: Long, inputModel: InputModel): Response<InputModel> {
        TODO("Not yet implemented")
    }

    override fun editInput(inputId: Long, input: InputModel): Response<Unit> {
        TODO("Not yet implemented")
    }

    override fun deleteInput(inputId: Long): Response<Unit> {
        TODO("Not yet implemented")
    }

    override fun setSubmitButtonLabel(formId: Long, label: String) {
        TODO("Not yet implemented")
    }

    override fun setFormFontSize(formId: Long, fontSize: Int) {
        TODO("Not yet implemented")
    }

    override fun setFontHexColor(formId: Long, hexColor: String) {
        TODO("Not yet implemented")
    }

    override fun setBackgroundHexColor(formId: Long, hexColor: String) {
        TODO("Not yet implemented")
    }

    override fun setBackgroundImage(formId: Long, image: String) {
        TODO("Not yet implemented")
    }
}