package common


import java.lang.NumberFormatException

fun clearScreen() {
    for (i in 1..35) {
        println("")
    }
}

/**
 * Takes [userInput]
 * @return Boolean if is not empty
 */
fun validateIfNotEmpty(userInput: String): Boolean {
    return userInput != ""
    return userInput != ""
}

/**
 * validates if user providet [userInput] is int
 * @return boolean
 */
fun validateIfInt(userInput: String): Boolean {
//    try {
//        //DO THIS
//    }catch (e: AssertionError){
//        //Do SOMETHING ELSE
//    }
    return try {
        userInput.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }

}

/**
 * validates if user providet [userInput] is double
 * @return boolean
 */
fun validateIfDouble(userInput: String): Boolean {
    return try {
        userInput.toDouble()
        true
    } catch (e: NumberFormatException) {
        false
    }

}

/**
 * Takse [userInput] & [requiredType] of user input
 * @return boolean
 */
fun validateUserInput(userInput: String, requiredType: String): Boolean {
    //Check if not empty
    if (!validateIfNotEmpty(userInput)) {
        return false
    }
    when (requiredType) {
        "Int" -> {
            if (!validateIfInt(userInput)) {
                return false
            }
            if (userInput.toInt() < 0) {
                return false
            }
        }
        "Double" -> {
            if (!validateIfDouble(userInput)) {
                return false
            }
            if (userInput.toDouble() < 0) {
                return false
            }
        }
    }
    return true
}
