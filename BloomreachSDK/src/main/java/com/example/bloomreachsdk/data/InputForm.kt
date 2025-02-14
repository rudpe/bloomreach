package com.example.bloomreachsdk.data

import com.example.bloomreachsdk.data.model.InputFormModel
import com.example.bloomreachsdk.data.model.InputModel

interface InputForm {

    /**
    * Creates form. You need to call at first to create new form.
    * @params *inputFormModel* Model to create new form.
     *
     * @return `Response.Success` If form was created successfully.
    * */
    suspend fun createForm(inputFormModel: InputFormModel): Response<InputFormModel>

    /**
     * Gets form by ID.
     *
     * @return `Response.Success` If form was found.
     */
    suspend fun getForm(formId: Long): Response<InputFormModel?>

    /**
     * Edits form.
     *
     * @return `Response.Success` If form was edited.
     */
    suspend fun editForm(formId: Long, inputFormModel: InputFormModel): Response<Unit>

    /**
     * Submit form.
     *
     * @return `Response.Success` If form was submitted.
     */
    suspend fun submitForm(formId: Long, values: List<String>): Response<Unit>

    /**
     * Adds text input to form.
     *
     * @return `Response.Success` If text input was added.
     */
    suspend fun addInput(formId: Long, inputModel: InputModel): Response<InputModel>

    /**
     * Edits text input in form.
     *
     * @return `Response.Success` If text input was edited.
     */
    suspend fun editInput(inputId: Long, input: InputModel): Response<Unit>

    /**
     * Deletes text input from form.
     *
     * @return `Response.Success` If text input was deleted.
     */
    suspend fun deleteInput(inputId: Long): Response<Unit>

    /**
     * Changes label on submit button.
     *
     * @return `Response.Success` If label was changed.
     */
    suspend fun setSubmitButtonLabel(formId: Long, label: String): Response<Unit>

    /**
     * Changes text size for all components in form.
     *
     * @return `Response.Success` If text size was changed.
     */
    suspend fun setFormFontSize(formId: Long, fontSize: Int): Response<Unit>

    /**
     * Changes text color for all components in form.
     *
     * @return `Response.Success` If text color was changed.
     */
    suspend fun setFontHexColor(formId: Long, hexColor: String): Response<Unit>

    /**
     * Changes background color in form.
     *
     * @return `Response.Success` If background color was changed.
     */
    suspend fun setBackgroundHexColor(formId: Long, hexColor: String): Response<Unit>

    /**
     * Sets image to background.
     *
     * @return `Response.Success` If image was set.
     */
    suspend fun setBackgroundImage(formId: Long, image: String): Response<Unit>
}