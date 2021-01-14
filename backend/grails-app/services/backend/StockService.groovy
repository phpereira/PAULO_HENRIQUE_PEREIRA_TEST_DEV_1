package backend

import java.math.RoundingMode
import java.time.LocalDateTime

import grails.gorm.transactions.*

@Transactional
class StockService {

    def getStocks(String company, int hours) {

        long start = System.currentTimeMillis()
        LocalDateTime dateRange = LocalDateTime.now().minusHours(hours)

        def stocks = Stock.executeQuery("SELECT s FROM Stock s, Company c " +
                "WHERE s.company = c.id " +
                "AND c.name LIKE :company " +
                "AND s.priceDate > :hours", [company: company, hours: dateRange])

        println "Quotes: "
        stocks.forEach({ stock ->
            println "Date: ${stock.priceDate} - Price: ${stock.price}"
        })

        float elapsedTime = (System.currentTimeMillis() - start);
        println "Time elapsed: " + elapsedTime + " ms"
        println "Quotes retrieved:" + stocks.size()
    }

    def findAllStocksByCompanyId(Serializable id) {
        return Stock.executeQuery("SELECT s FROM Stock s WHERE s.company.id = :id", [id: id]).toList();
    }

    def findStocksPricesByCompany(Serializable id) {
        return Stock.executeQuery("SELECT s.price FROM Stock s "
                + "where s.company.id = :id",
                [id: id]
        ).toList();
    }

    def getStocksByCompany(String company) {
        return Stock.findAll("from Stock s "
                + "where s.company.name = :name",
                [name: company]
        ).toList();
    }

    def findAllCompanies() {
        List<Company> companies = Company.executeQuery("SELECT c.id, c.name, c.segment FROM Company c")
    }
}