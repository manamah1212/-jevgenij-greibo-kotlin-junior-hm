import common.Client


class UserCalculations(private var ourClient: Client) {


    var temp: Double = 0.0
    var dependent = 250.0
    var incomeTax = 0.0
    var personalIncomeTax = 0.0
    var socialTax = ourClient.salary / 100 * 11
    var taxableMoney = 0.0


    /**
     * count salary netto
     */
    fun getSalaryNeto(): Double? {
        getIncomeTax()
        getPersonalIncomeTax()

        temp = ourClient.salary - socialTax - personalIncomeTax
        return temp


    }

    /**
     * Income tax for
     * @ourClient
     */
    fun getIncomeTax() {
        if (ourClient.salary > 0 && ourClient.salary < 20004) {
            incomeTax = ourClient.salary / 100 * 11
        }
        if (ourClient.salary > 20004 && ourClient.salary < 62800) {
            incomeTax = ourClient.salary / 100 * 11
        } else {
            incomeTax = (ourClient.salary / 100 * 31.4)
        }


        /* return when (ourClient.salary) {
             in 0.0..20004.0 -> incomeTax = (ourClient.salary / 100) * 11
             in 20004.0..62800.0 -> incomeTax = (ourClient.salary / 100) * 23
             else -> incomeTax = (ourClient.salary / 100 * 31.4)
         }*/
    }

    fun getPersonalIncomeTax() {
        personalIncomeTax = taxableMoney * incomeTax
    }


}
