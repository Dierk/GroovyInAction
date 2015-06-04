import groovy.transform.Canonical

@Canonical
class Booking {
    String meetingRoom
    String className
    Date start, end
}

def book(meeting) {
    [room: { name ->
        [between: { sd ->
            [and: { ed ->
                [to: { to ->
                    def b = new Booking(meetingRoom: name,
                        className: to, start: sd, end: ed)
                    println b
                    b
                }]
            }]
        }]
    }]
}

def meeting
@Category(Integer)
class TimeCategory {
    static Date getAm(Integer self) {
        def d = Calendar.instance
        d.set(Calendar.MINUTE, 0)
        d.set(Calendar.SECOND, 0)
        d.set(Calendar.HOUR_OF_DAY, self)
        d.time
    }
}
use(TimeCategory) {
    book meeting room 'Honolulu' between 9.am and 12.am to 'B2'
}

