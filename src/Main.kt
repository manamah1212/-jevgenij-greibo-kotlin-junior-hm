import  common.Client
import common.Constants.ADD_NEW_MESSAGE
import common.Constants.CLOSE_APP_MESSAGE
import common.Constants.ENTER_FIRST_NAME_MESSAGE
import common.Constants.ENTER_KIDS_MESSAGE
import common.Constants.ENTER_SALARY_MESSAGE
import common.Constants.GREETING_MESSAGE
import common.Constants.INVALID_DATA_ERROR_MESSAGE
import common.Constants.SEPARATOR_MESSAGE
import common.Constants.SUCCESSFULLY_ADDED_TO_DB_MESSAGE
import common.clearScreen
import common.validateIfNotEmpty
import common.validateUserInput
import kotlin.system.exitProcess

val dataBase = arrayListOf<Client>()

fun main() {
    val newUser = inputHandler()


    newUser.salaryNeto = UserCalculations(newUser).getSalaryNeto()

    dataBase.add(newUser)

    outputHandler(dataBase)
}

/**
 * Gets data from user
 * @return Validated data in form of Client class
 */
fun inputHandler(): Client {
    var validData = false

    var name = ""
    var salary = ""
    var kids = ""


    while (!validData) {
        //Greet user and collect info
        println(GREETING_MESSAGE)

        print(ENTER_FIRST_NAME_MESSAGE)
        //to kas user ierakstit
        name = readLine().toString().trim()


        print(ENTER_KIDS_MESSAGE)
        kids = readLine().toString().trim()

        print(ENTER_SALARY_MESSAGE)
        salary = readLine().toString().trim()

        if (
            !validateIfNotEmpty(name) ||
            !validateUserInput(kids, "Int") ||
            !validateUserInput(salary, "Double")
        ) {
            clearScreen()
            println(INVALID_DATA_ERROR_MESSAGE)
            println()
        } else {
            validData = true
        }

    }
    return Client(
        name,
        kids.toInt(),
        salary.toDouble()

    )
}

fun outputHandler(clientData: ArrayList<Client>) {
    clearScreen()
    println(SUCCESSFULLY_ADDED_TO_DB_MESSAGE)
    println(SEPARATOR_MESSAGE)

    System.out.printf(
        "%-4s%-13s%-18s%-15s%-15s\n",
        "ID",
        "NAME",
        "SALARY BRUTO",
        "KIDS",
        "SALARY NETTO"
    )

    clientData.forEachIndexed { index, client ->
        System.out.printf(
            "%-4s%-13s%-18s%-15s%-15s\n",
            index,
            client.name,
            client.salary,
            client.kids,
            client.salaryNeto
        )
    }
    println(SEPARATOR_MESSAGE)

    println(ADD_NEW_MESSAGE)

    if (readLine().toString().trim() == "yes") {
        main()
    } else {
        closeApp()
    }
}

/**
 * Terminates app
 */
fun closeApp() {
    clearScreen()
    println(CLOSE_APP_MESSAGE)
    exitProcess(0)
}