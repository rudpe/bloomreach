package com.example.bloomreachsdk.data.model

data class InputFormModel(
    val id: Long?,
    val inputs: List<InputModel>,
    val submitButtonLabel: String,
    val fontSize: Int?,
    /**
     * hexadecimal color e.g. #FFFFFF
     */
    val fontHexColor: String?,
    val backgroundHexColor: String?,
    val backgroundImageId: Long?
)
