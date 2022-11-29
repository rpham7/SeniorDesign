import Goal.Bulking
import Goal.Cutting
import Goal.Maintaining
import java.util.Random

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val s = object: MeasurementConversion() {

    }
    println(s.heightConversion(5, 9))
    println(s.weightConversion(45))

    // var user: User()
    // this will be used for the user input that is inputted in to create to get method generation
    var bulkList = mutableListOf<User>()
    var mainList = mutableListOf<User>()
    var cutList = mutableListOf<User>()

    var dumSet = mutableMapOf<String, String>()
    dumSet.put("S1", "OverheadPress")
    dumSet.put("S2", "Lat Raise")
    dumSet.put("S3", "Hello")
    println(dumSet.keys)


    var tempAmountOfUsers = 100

    while (tempAmountOfUsers > 0) {
        val gender:Int = Random().nextInt(0, 2)
        val goal:Int = Random().nextInt(0,3)
        var tempUser = User(
            Random().nextInt(16,50), Random().nextDouble(100.0, 300.0), Random().nextDouble(150.0, 200.0), Random().nextDouble(5.0, 30.0),
                                goal(goal), gender(gender), Random().nextDouble(10.0, 20.0), Random().nextDouble(90.0, 153.0))
        if(goal(goal).equals("Cutting"))
            cutList.add(tempUser)
        else if(goal(goal).equals("Maintaining"))
            mainList.add(tempUser)
        else
            bulkList.add(tempUser)

       tempAmountOfUsers--
    }

    val bulkGen = Bulking(bulkList)
    val mainGen = Maintaining(mainList)
    val cutGen = Cutting(cutList)

    //bulkGen.showList()
    mainGen.showList()
    //cutGen.showList()

}
fun goal(goal:Int): String {
    if (goal == 0)
        return "Cutting"
    else if(goal == 1)
        return "Bulking"
    else
        return "Maintaining"
}
fun gender(gender:Int): String {
    if(gender == 0)
        return "Male"
    else
        return "Female"
}
