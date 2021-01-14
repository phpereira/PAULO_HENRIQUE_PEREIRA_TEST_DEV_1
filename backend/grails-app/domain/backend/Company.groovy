package backend

class Company {

    String name;
    String segment;

    static constraints = {
        name size: 3..30, blank: false, unique: true
        segment size: 3..20, blank: false
    }
}
