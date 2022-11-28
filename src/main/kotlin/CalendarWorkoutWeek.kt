class CalendarWorkoutWeek {
    var day:String
    var listOfWorkouts: MutableList<Map<String, String>>

    constructor(day:String, list:MutableList<Map<String, String>>) {
        this.day = day
        this.listOfWorkouts = list
    }
}