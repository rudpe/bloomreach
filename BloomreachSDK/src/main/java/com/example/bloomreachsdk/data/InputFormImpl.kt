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
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Input form was created.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun getForm(formId: Long): Response<InputFormModel?> {
        when (val result = inputFormApi.getForm(formId)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Form was returned successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun editForm(formId: Long, inputFormModel: InputFormModel): Response<Unit> {
        when (val result = inputFormApi.editForm(formId, inputFormModel)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Form was edited successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun submitForm(formId: Long, values: List<String>): Response<Unit> {
        when (val result = inputFormApi.submitForm(formId, values)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Form was submitted successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun addInput(formId: Long, inputModel: InputModel): Response<InputModel> {
        when (val result = inputFormApi.addInput(formId, inputModel)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Input was added successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun editInput(inputId: Long, input: InputModel): Response<Unit> {
        when (val result = inputFormApi.editInput(inputId, input)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Input was edited successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun deleteInput(inputId: Long): Response<Unit> {
        when (val result = inputFormApi.deleteInput(inputId)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Input was deleted successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun setSubmitButtonLabel(formId: Long, label: String): Response<Unit> {
        when (val result = inputFormApi.setSubmitButtonLabel(formId, label)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Label was changed successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun setFormFontSize(formId: Long, fontSize: Int): Response<Unit> {
        when (val result = inputFormApi.setFormFontSize(formId, fontSize)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Font size was changed successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun setFontHexColor(formId: Long, hexColor: String): Response<Unit> {
        when (val result = inputFormApi.setFontHexColor(formId, hexColor)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Color was changed successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun setBackgroundHexColor(formId: Long, hexColor: String): Response<Unit> {
        when (val result = inputFormApi.setBackgroundHexColor(formId, hexColor)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Background color was changed successfully.")
                return Response.Success(result.data)
            }
        }
    }

    override suspend fun setBackgroundImage(formId: Long, image: String): Response<Unit> {
        when (val result = inputFormApi.setBackgroundImage(formId, image)) {
            is Response.Error -> {
                Log.i("CREATE", "Error: ${result.error}")
                return Response.Error(result.error)
            }
            is Response.Success -> {
                Log.i("CREATE", "Image was changed successfully.")
                return Response.Success(result.data)
            }
        }
    }
}