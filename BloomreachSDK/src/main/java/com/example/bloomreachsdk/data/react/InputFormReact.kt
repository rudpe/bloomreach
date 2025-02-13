package com.example.bloomreachsdk.data.react

import android.util.Log
import com.example.bloomreachsdk.data.InputForm
import com.example.bloomreachsdk.data.Response
import com.example.bloomreachsdk.data.api.InputFormApi
import com.example.bloomreachsdk.data.model.InputFormModel
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


internal class InputFormReact @Inject constructor(
    private val inputForm: InputForm,
    private val inputFormApi: InputFormApi
) : ReactContextBaseJavaModule() {

    private val formScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    override fun getName(): String = "InputForm"

    @ReactMethod
    fun createForm(inputFormModel: InputFormModel, successCallback: Callback, errorCallback: Callback) {
        formScope.launch {
            try {
                val result = withContext(context = Dispatchers.IO) {
                    inputFormApi.createForm(inputFormModel)
                }
                when (result) {
                    is Response.Error -> {
                        Log.i("CREATE", "Input form wasn't created. Error: ${result.error}")
                        errorCallback.invoke(result.error.toString())
                    }
                    is Response.Success -> {
                        Log.i("CREATE", "Input form was created")
                        successCallback.invoke(result.data)
                    }
                }
            } catch (e: Exception) {
                errorCallback.invoke(e.toString())
            }
        }
    }
}
