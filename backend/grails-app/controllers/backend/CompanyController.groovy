package backend

import java.util.stream.Collectors

class CompanyController {

    CompanyService companyService
    StockService stockService
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        respond companyService.list().stream().map{return [
                id: it.id,
                name: it.name,
                segment: it.segment,
                stocks: stockService.findAllStocksByCompanyId(it.id).stream().map{stock->
                    return [
                            price: stock.price,
                            priceDate: stock.priceDate.toString()
                    ]
                }.collect(Collectors.toList())
        ]}.collect(Collectors.toList())
    }

    def listStocks(String company, int hours) {
        respond stockService.getStocks(company, hours)
    }
}
