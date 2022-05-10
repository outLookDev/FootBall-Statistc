class Statistics {
    var name: String = ""
    var wins: String = ""
    var louses: String = ""
    var draws: String =  ""
    var point: String = ""

    constructor()
    constructor(name: String, wins: String, louses: String, draws: String, point: String) {
        this.name = name
        this.wins = wins
        this.louses = louses
        this.draws = draws
        this.point = point
    }

    override fun toString(): String {
        return "$name,$wins,$louses,$draws,$point"
    }

}