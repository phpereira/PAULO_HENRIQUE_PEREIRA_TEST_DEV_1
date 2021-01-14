package backend

import java.math.RoundingMode
import java.time.LocalDate
import java.time.LocalTime

class BootStrap {

    def init = { servletContext ->

        int maximum = 10
        int minimum = 1

        def nitryx = new Company(name: 'Nitryx', segment: 'Consultoria').save(failOnError: true)
        def google = new Company(name: 'Amazon', segment: 'Serviços').save(failOnError: true)
        def tim = new Company(name: 'Tim', segment: 'Telecomunicações').save(failOnError: true)

        LocalDate actualDate = LocalDate.now()
        def currentDate

        Arrays.asList(nitryx, google, tim).forEach({ company ->
            currentDate = actualDate.minusDays(30)
            while (currentDate <= actualDate) {

                def workHour = LocalTime.of(10, 0)

                while (workHour <= LocalTime.of(18, 0)) {
                    def price = minimum + (Math.random() * (maximum - minimum));
                    Stock stock = new Stock(
                            price: BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP).toDouble(),
                            priceDate: currentDate.atTime(workHour)
                    )
                    stock.company = company
                    stock.save(failOnError: true)
                    workHour = workHour.plusMinutes(1)
                }
                currentDate = currentDate.plusDays(1)
            }
        })
    }

    def destroy = {
    }
}
