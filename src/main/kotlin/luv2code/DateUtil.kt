package luv2code

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object DateUtil {
    // The date formatter
// - dd:   day in month (number)
// - MM:   month in year (number)
// - yyyy: year
//
// See this link for details: https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
//
//
    private val formatter = SimpleDateFormat("dd/MM/yyyy")

    // read a date string and parse/convert to a date
    @Throws(ParseException::class)
    fun parseDate(dateStr: String?): Date? {
        return formatter.parse(dateStr)
    }

    // read a date and format/convert to a string
    fun formatDate(theDate: Date?): String? {
        var result: String? = null
        if (theDate != null) {
            result = formatter.format(theDate)
        }
        return result
    }
}