import java.io.File
import java.io.FileWriter
import java.util.Scanner

class StatisticsService : StatisticsInterface {
    var scanner = Scanner(System.`in`)
    var count = 0
    var file = File("statisticFile.txt")
    override fun addStatistic() {

        println("Name:")
        var name = scanner.next()
        println("Wins:")
        var wins = scanner.next()
        println("Loses:")
        var loses = scanner.next()
        println("Draw:")
        var draws = scanner.next()
        var points = wins.toInt() * 3 + draws.toInt()
        var statistics = Statistics()
        statistics.name = name
        statistics.wins = wins
        statistics.louses = loses
        statistics.draws = draws
        statistics.point = points.toString()
        var writer = FileWriter(file, true)
        writer.write("${statistics.name},${statistics.wins},${statistics.louses},${statistics.draws},${statistics.point}" + "\n")
        println("Successfully !")
        writer.close()
    }

    override fun statistics() {
        var clubs = ArrayList<Statistics>()
        var bufferedReader = file.bufferedReader()
        var list = bufferedReader.readLines()
        for (s in list) {
            var str = s
            if (str.isNotEmpty()) {
                val array = str.split(',')
                var footBall =
                    Statistics(array[0], array[1], array[2], array[3], array[4])
                clubs.add(footBall)

            }

        }
        clubs.sortedBy { it.point }
        for (club in 0 until clubs.size) {
            println("==================================${club + 1}================")
            println("Name: " + clubs[club].name)
            println("Wins: " + clubs[club].wins)
            println("Louses: " + clubs[club].louses)
            println("Draws: " + clubs[club].draws)
            println("Point: " + clubs[club].point)
            println("==============================================================")
        }
    }

    override fun deleteStatistics() {
        if (file.length() > 0) {
            println("Delete name :")
            var deleteName = scanner.next()
            var deleteList = arrayListOf<Statistics>()
            var readLine = file.readLines()
            var isHave = false
            for (i in readLine.indices) {
                val index = readLine[i].indexOf(",")
                val username = readLine[i].substring(0, index)
                val wins = readLine[i].substring(index + 1)
                val louses = readLine[i].substring(index + 1)
                val draws = readLine[i].substring(index + 1)
                val point = readLine[i].substring(index + 1)
                val user = Statistics(username, wins, louses, draws, point)
                deleteList.add(user)
            }
            for (user in deleteList.indices) {
                if (deleteList[user].name == deleteName) {
                    isHave = true
                    deleteList.removeAt(user)
                    break

                }

            }
            if (!isHave) {
                println("Football  is Not Found !")

            } else {
                var writer = file.writer()
                for (users in deleteList.indices) {
                    writer.write("${deleteList[users].name},${deleteList[users].wins},${deleteList[users].louses},${deleteList[users].draws},${deleteList[users].point} \n")
                }

                writer.close()
                println("Success ! Delete !")

            }


        } else {
            println("File list is Empty !")
        }


    }

    override fun searchStatics() {
        if (file.length() > 0) {

            println("Search name :")
            var deleteName = scanner.next()
            var searchList = arrayListOf<Statistics>()
            var bufferedReader = file.bufferedReader()
            var list = bufferedReader.readLines()
            var readLine = file.readLines()
            var isHave = false
            for (i in list) {
                var str = i
                val array = str.split(',')

                var footBall =
                    Statistics(array[0], array[1], array[2], array[3], array[4])
                searchList.add(footBall)
            }
            for (user in searchList.indices) {
                if (searchList[user].name == deleteName) {
                    isHave = true
                    break

                }

            }
            if (!isHave) {
                println("Football  is Not Found !")

            } else {
                for (users in 0 until searchList.size) {
                    println("==============[${users+1}]==============")
                    println("Name: " + searchList[users].name)
                    println("Wins: " + searchList[users].wins)
                    println("Louses: " + searchList[users].louses)
                    println("Draws: " + searchList[users].draws)
                    println("Point: " + searchList[users].point)
                    println("============================================")
                }
                println("Success !  ")
            }


        } else {
            println("File list is Empty !")
        }

    }

    override fun editStatics () {
        if (file.length() > 0) {

            println("Edited name :")
            var deleteName = scanner.next()
            println("New Name: ")
            var newName = scanner.next()
            println("New Wins: ")
            var newWin = scanner.next()
            println("New Louses: ")
            var newLouses = scanner.next()
            println("New Draw: ")
            var newDraw = scanner.next()
            var newPoint = newWin.toInt() * 3 + newDraw.toInt()

            var deleteList = arrayListOf<Statistics>()
            var bufferedReader = file.bufferedReader()
            var list = bufferedReader.readLines()
            var readLine = file.readLines()
            var isHave = false
            for (i in list) {
                var str = i
                val array = str.split(',')

                var footBall =
                    Statistics(array[0], array[1], array[2], array[3], array[4])
                deleteList.add(footBall)
            }
            for (user in deleteList.indices) {
                for (user in 0 until deleteList.size) {
                    if (deleteList[user].name == deleteName) {
                        isHave = true
                        deleteList[user].name = newName
                        deleteList[user].wins = newWin
                        deleteList[user].draws = newDraw
                        deleteList[user].louses = newLouses
                        deleteList[user].point = newPoint.toString()
                        val users = Statistics()
                        users.name = newName

                        break
                    }


                }
                if (!isHave) {
                    println("Football  is Not Found !")

                } else {
                    var writer = file.writer()
                    for (users in deleteList) {
                        writer.write("${users.name},${users.wins},${users.louses},${users.draws},${users.point} \n")
                    }
                    writer.close()
                }
                    println("Success !  ")
                }

        } else {
            println("File list is Empty !")
        }
    }

}
