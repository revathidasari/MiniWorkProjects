package com.example.minipojects.sampleFiles.testing

object RegistrationUtil {

    private val existingUsers = listOf("dasari", "revathi")
    /*
    * Input is not valid if
    * -username/password is empty
    * -username is already taken
    * -confirmed password is not same as password
    * -password contains less than 2 digits*/
    fun validateRegistrationInput(
        username:String,
        password:String,
        confirmedPassword:String
    ) : Boolean {
        if (username.isEmpty() || password.isEmpty())
            return false
        if (username in existingUsers)
            return false
        if (password != confirmedPassword)
            return false
        if (password.count { it.isDigit() } < 2)
            return false
        return true
    }
}