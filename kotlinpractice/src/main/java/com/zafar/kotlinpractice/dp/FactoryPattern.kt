package com.zafar.kotlinpractice.dp

import kotlin.concurrent.thread

enum class DialogType {
    DIALOG_CREATE_CHAT,
    DIALOG_DELETE_MSG,
    DIALOG_EDIT_MSG
}

sealed class Dialog() {
    object CreateChatDialog : Dialog()
    object DeleteMsgDialog : Dialog()
    object EditMsgDialog : Dialog()
}

object DialogFactory {
    fun getDialog(dialogType: DialogType): Dialog {

        thread(start = true) {
            println("Thread is running")
        }

        return when (dialogType) {
            DialogType.DIALOG_CREATE_CHAT -> Dialog.CreateChatDialog
            DialogType.DIALOG_DELETE_MSG -> Dialog.DeleteMsgDialog
            DialogType.DIALOG_EDIT_MSG -> Dialog.EditMsgDialog
        }
    }
}