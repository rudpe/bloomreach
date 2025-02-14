package com.example.bloomreach

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloomreachsdk.data.InputForm
import com.example.bloomreachsdk.data.model.InputFormModelConst
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val inputForm: InputForm
) : ViewModel() {

    fun createInputForm() {
        viewModelScope.launch {
            inputForm.createForm(InputFormModelConst.inputFormModel)
        }
    }

    fun getForm() {
        viewModelScope.launch {
            inputForm.getForm(FORM_ID)
        }
    }

    fun editForm() {
        viewModelScope.launch {
            inputForm.editForm(FORM_ID, InputFormModelConst.inputFormModel)
        }
    }

    fun submitForm() {
        viewModelScope.launch {
            inputForm.submitForm(FORM_ID, listOf("Jano", "55"))
        }
    }

    fun addInput() {
        viewModelScope.launch {
            inputForm.addInput(FORM_ID, InputFormModelConst.inputModelName)
        }
    }

    fun editInput() {
        viewModelScope.launch {
            inputForm.editInput(INPUT_ID, InputFormModelConst.inputModelName)
        }
    }

    fun deleteInput() {
        viewModelScope.launch {
            inputForm.deleteInput(INPUT_ID)
        }
    }

    fun setSubmitButtonLabel() {
        viewModelScope.launch {
            inputForm.setSubmitButtonLabel(FORM_ID, "Submit")
        }
    }

    fun setFormFontSize() {
        viewModelScope.launch {
            inputForm.setFormFontSize(FORM_ID, 15)
        }
    }

    fun setFontHexColor() {
        viewModelScope.launch {
            inputForm.setFontHexColor(FORM_ID, "#FFFFFF")
        }
    }

    fun setBackgroundHexColor() {
        viewModelScope.launch {
            inputForm.setBackgroundHexColor(FORM_ID, "#000000")
        }
    }

    fun setBackgroundImage() {
        viewModelScope.launch {
            inputForm.setBackgroundImage(FORM_ID, "BASE64")
        }
    }

    companion object {
        private const val FORM_ID = 10L
        private const val INPUT_ID = 100L
    }
}