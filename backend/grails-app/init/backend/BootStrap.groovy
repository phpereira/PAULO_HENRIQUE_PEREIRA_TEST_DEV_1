package backend

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.chrono.ChronoLocalDate

class BootStrap {

    def init = { servletContext ->

        int maximum = 10
        int minimum = 1

        def nitryx = new Company(name: 'Nitryx', segment: 'Consultoria').save(failOnError: true)
        def google = new Company(name: 'Amazon', segment: 'Serviços').save(failOnError: true)
        def tim = new Company(name: 'Tim', segment: 'Telecomunicações').save(failOnError: true)

        var actualDate = LocalDate.now();
        var lastDate = actualDate.minusDays(30)
        var actualTime = LocalTime.now();

        for (LocalDate date = lastDate; date.isEqual(actualDate as ChronoLocalDate); date = date.plusDays(1)) {

            for (LocalTime hour = date.atTime(10, 0) as LocalTime; hour.with(LocalTime.of(18, 0)); hour.plusHours(1)) {
                while (hour.isBefore(LocalTime.of(18, 0))) {

                    if (hour != actualTime) {




                        LocalDateTime priceDate = date.atTime(hour.plusMinutes(1))

                        int stockPrice = Math.random() * (maximum - minimum) + minimum
                        Stock stock = new Stock(price: stockPrice, priceDate: priceDate)
                        stock.company = nitryx
                        stock.save(failOnError: true)

                        int stockPrice1 = Math.random() * (maximum - minimum) + minimum
                        Stock stock1 = new Stock(price: stockPrice1, priceDate: priceDate)
                        stock1.company = google;
                        stock1.save(failOnError: true)

                        int stockPrice2 = Math.random() * (maximum - minimum) + minimum
                        Stock stock2 = new Stock(price: stockPrice2, priceDate: priceDate)
                        stock2.company = tim
                        stock2.save(failOnError: true)
                    } else {
                        break
                    }
                }
            }
        }
        def destroy = {
        }
    }
}
