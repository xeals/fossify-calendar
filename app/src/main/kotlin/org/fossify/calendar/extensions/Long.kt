package org.fossify.calendar.extensions

import org.fossify.calendar.helpers.Formatter
import org.fossify.calendar.models.Event
import org.joda.time.DateTimeZone

fun Long.isTsOnProperDay(event: Event): Boolean {
    val dateTime = Formatter.getDateTimeFromTS(this, DateTimeZone.forID(event.getTimeZoneString()))
    val power = 1 shl (dateTime.dayOfWeek - 1)
    return event.repeatRule and power != 0
}
