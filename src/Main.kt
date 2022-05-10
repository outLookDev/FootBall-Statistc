import java.util.Scanner

fun main() {
    var scanner=Scanner(System.`in`)
    var statisticsService= StatisticsService()
    while (true){
        println("1-> Add statistics !")
        println("2-> Statistics List !")
        println("3-> Remove List !")
        println("4-> Search statistics !")
        println("5-> Edit statistics Name !")
        println("Choose :")
        var choose=scanner.nextInt()
        when(choose){
            1->{
                statisticsService.addStatistic()
            }
            2-> {
                statisticsService.statistics()
            }
            4->{
                statisticsService.searchStatics()
            }
            3->{
                statisticsService.deleteStatistics()
            }
            5->{
                statisticsService.editStatics()
            }
            else->{
                println("Invalid number !")
            }

            }
        }


}