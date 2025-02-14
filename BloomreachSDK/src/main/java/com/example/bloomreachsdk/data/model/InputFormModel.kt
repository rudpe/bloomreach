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

/**
 * Mock data.
 */
object InputFormModelConst {

    val inputModelName = InputModel(id = null, title = "Name", placeholder = "Your name")

    val inputModelAge = InputModel(id = null, title = "Age", placeholder = "Your age")

    val inputFormModel = InputFormModel(
        id = null,
        inputs = listOf(inputModelName, inputModelAge),
        submitButtonLabel = "Submit",
        fontSize = null,
        fontHexColor = null,
        backgroundHexColor = null,
        backgroundImageId = null
    )
}
