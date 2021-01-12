package backend

import grails.gorm.transactions.Transactional

import java.time.LocalDateTime

@Transactional
class StockService {

    def getStocks(String company, int hours) {

        long start = System.currentTimeMillis()
        int stocksQuantity = 0;

        LocalDateTime dateRange = LocalDateTime.now().minusHours(hours)

        def stocks = Stock.executeQuery("SELECT s FROM Stock s, Company c " +
                "WHERE s.company = c.id " +
                "AND c.name LIKE :company " +
                "AND s.priceDate > :hours", [company: company, hours: dateRange])

        println "\n"
        println "Quotes: "

        stocks.each { stock ->
            println "${stock.price}"
            stocksQuantity++
        }

        println "\n"

        float elapsedTime = (System.currentTimeMillis() - start) / 1000F;
        println "Time elapsed: " + elapsedTime + "\n"
        println "Quotes retrieved: ${stocksQuantity} \n"

    }
}
