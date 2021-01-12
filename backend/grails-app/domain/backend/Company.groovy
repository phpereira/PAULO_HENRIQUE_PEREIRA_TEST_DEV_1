package backend

class Company {

    String name;
    String segment;

    static hasMany = [stocks: Stock]

    static constraints = {
        name size: 5..30, blank: false, unique: true
        segment size: 3..20, blank: false


    }
}
