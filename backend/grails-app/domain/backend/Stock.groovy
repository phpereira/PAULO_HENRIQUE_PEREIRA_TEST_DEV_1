package backend

import java.time.LocalDateTime

class Stock {

    BigInteger price
    LocalDateTime priceDate

    static belongsTo = [company: Company]

    static constraints = {
        price nullable: false, blank: false

        priceDate nullable: false, blank: false
    }
}
