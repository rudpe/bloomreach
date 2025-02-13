package com.example.bloomreach

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloomreachsdk.data.InputForm
import com.example.bloomreachsdk.data.model.InputFormModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val inputForm: InputForm
    private val inputForm: InputForm
) : ViewModel() {

    //private val inputForm = InputFormImpl(inputFormApi)

    fun createInputForm() {
        viewModelScope.launch {
            inputForm.createForm(InputFormModel(
                id = null,
                inputs = emptyList(),
                submitButtonLabel = "Submit",
                fontSize = null,
                fontHexColor = null,
                backgroundHexColor = null,
                backgroundImageId = null
            ))
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}