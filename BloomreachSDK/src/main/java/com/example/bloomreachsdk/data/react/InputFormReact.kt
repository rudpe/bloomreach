package com.example.bloomreachsdk.data.react

import android.util.Log
import com.example.bloomreachsdk.data.InputForm
import com.example.bloomreachsdk.data.Response
import com.example.bloomreachsdk.data.model.InputFormModel
import com.example.bloomreachsdk.data.model.InputModel
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class InputFormReact @Inject constructor(
    private val inputForm: InputForm,
) : ReactContextBaseJavaModule() {

    private val formScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    override fun getName(): String = "InputForm"

    @ReactMethod
    fun createForm(inputFormModel: InputFormModel, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Input form was created.", successCallback, errorCallback) {
            inputForm.createForm(inputFormModel)
        }
    }

    @ReactMethod
    fun getForm(formId: Long, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Form was returned successfully.", successCallback, errorCallback) {
            inputForm.getForm(formId)
        }
    }

    @ReactMethod
    fun editForm(formId: Long, inputFormModel: InputFormModel, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Form was edited successfully.", successCallback, errorCallback) {
            inputForm.editForm(formId, inputFormModel)
        }
    }

    @ReactMethod
    fun submitForm(formId: Long, values: List<String>, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Form was submitted successfully.", successCallback, errorCallback) {
            inputForm.submitForm(formId, values)
        }
    }

    @ReactMethod
    fun addInput(formId: Long, inputModel: InputModel, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Input was added successfully.", successCallback, errorCallback) {
            inputForm.addInput(formId, inputModel)
        }
    }

    @ReactMethod
    fun editInput(inputId: Long, input: InputModel, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Input was edited successfully.", successCallback, errorCallback) {
            inputForm.editInput(inputId, input)
        }
    }

    @ReactMethod
    fun deleteInput(inputId: Long, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Input was deleted successfully.", successCallback, errorCallback) {
            inputForm.deleteInput(inputId)
        }
    }

    @ReactMethod
    fun setSubmitButtonLabel(formId: Long, label: String, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Label was changed successfully.", successCallback, errorCallback) {
            inputForm.setSubmitButtonLabel(formId, label)
        }
    }

    @ReactMethod
    fun setFormFontSize(formId: Long, fontSize: Int, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Font size was changed successfully.", successCallback, errorCallback) {
            inputForm.setFormFontSize(formId, fontSize)
        }
    }

    @ReactMethod
    fun setFontHexColor(formId: Long, hexColor: String, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Color was changed successfully.", successCallback, errorCallback) {
            inputForm.setFontHexColor(formId, hexColor)
        }
    }

    @ReactMethod
    fun setBackgroundHexColor(formId: Long, hexColor: String, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Background color was changed successfully.", successCallback, errorCallback) {
            inputForm.setBackgroundHexColor(formId, hexColor)

        }
    }

    @ReactMethod
    fun setBackgroundImage(formId: Long, image: String, successCallback: Callback, errorCallback: Callback) {
        inputFormAction("Image was changed successfully.", successCallback, errorCallback) {
            inputForm.setBackgroundImage(formId, image)
        }
    }

    private fun <T> inputFormAction(successMessage: String, successCallback: Callback, errorCallback: Callback, action: suspend () -> Response<T>) {
        formScope.launch {
            try {
                val result = withContext(context = Dispatchers.IO) {
                    action.invoke()
                }
                when (result) {
                    is Response.Error -> {
                        Log.i("CREATE", "Input form wasn't created. Error: ${result.error}")
                        errorCallback.invoke(result.error.toString())
                    }
                    is Response.Success -> {
                        Log.i("CREATE", successMessage)
                        successCallback.invoke(result.data)
                    }
                }
            } catch (e: Exception) {
                errorCallback.invoke(e.toString())
            }
        }
    }

}
