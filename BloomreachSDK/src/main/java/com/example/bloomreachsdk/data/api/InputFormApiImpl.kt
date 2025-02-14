package com.example.bloomreachsdk.data.api

import com.example.bloomreachsdk.data.Response
import com.example.bloomreachsdk.data.model.InputFormModel
import com.example.bloomreachsdk.data.model.InputFormModelConst
import com.example.bloomreachsdk.data.model.InputModel
import kotlin.random.Random

internal class InputFormApiImpl : InputFormApi {

    override suspend fun createForm(inputFormModel: InputFormModel): Response<InputFormModel> {
        return if (Random.nextBoolean()) {
             Response.Success(inputFormModel.copy(id = 100))
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun getForm(formId: Long): Response<InputFormModel?> {
        return if (Random.nextBoolean()) {
            Response.Success(InputFormModelConst.inputFormModel)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun editForm(formId: Long, inputFormModel: InputFormModel): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun submitForm(formId: Long, values: List<String>): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun addInput(formId: Long, inputModel: InputModel): Response<InputModel> {
        return if (Random.nextBoolean()) {
            Response.Success(InputFormModelConst.inputModelName)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun editInput(inputId: Long, input: InputModel): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun deleteInput(inputId: Long): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun setSubmitButtonLabel(formId: Long, label: String): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun setFormFontSize(formId: Long, fontSize: Int): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun setFontHexColor(formId: Long, hexColor: String): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun setBackgroundHexColor(formId: Long, hexColor: String): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }

    override suspend fun setBackgroundImage(formId: Long, image: String): Response<Unit> {
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else {
            Response.Error(Exception("Something went wrong."))
        }
    }
}