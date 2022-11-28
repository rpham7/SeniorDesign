import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class SQLExtraction {
    val connectionProps = Properties()
    var username:String
    var password:String

    constructor(user:String, pass:String) {
        this.username = user
        this.password = pass
    }

    fun addBulking() {
        //sql query
    }

    fun addCutting() {
        //sql query
    }

    fun addMaintaining() {
        //sql query
    }

    fun extractWorkouts(): MutableList<Map<String, String>> {
        return mutableListOf()
    }

    fun connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            var conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "127.0.0.1" +
                        ":" + "3306" + "/" +
                        "",
                connectionProps
            )
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
    }
}
}