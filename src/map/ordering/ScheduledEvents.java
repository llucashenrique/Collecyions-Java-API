package map.ordering;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class ScheduledEvents {

    private Map<LocalDate, Events> eventsMap;

    public ScheduledEvents() {
        this.eventsMap = new HashMap<>();
    }

    public void addEvent(LocalDate date, String name, String attraction) {
        eventsMap.put(date, new Events(name, attraction));
    }


    public void displayScheduled() {
        Map<LocalDate, Events> eventsTreeMap = new TreeMap<>(eventsMap);
        System.out.println(eventsTreeMap);
    }


    public void gettingNextEvent() {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDate = null;
        Events nextEvent = null;
        Map<LocalDate, Events> eventsTreeMap = new TreeMap<>(eventsMap);

        for (Map.Entry<LocalDate, Events> entry : eventsTreeMap.entrySet()) {

            if (entry.getKey().isEqual(currentDate) || entry.getKey().isAfter(currentDate)) {
                nextDate = entry.getKey();
                nextEvent = entry.getValue();
                System.out.println("The next event is: " + nextDate + " happened on the date: " + nextEvent);
                break;
            }
        }
    }

    public static void main(String[] args) {
        ScheduledEvents scheduledEvents = new ScheduledEvents();

        scheduledEvents.addEvent(LocalDate.of(2022, Month.JULY,15),"Event 01","Attraction 01");
        scheduledEvents.addEvent(LocalDate.of(2010, 10,11),"Event 02","Attraction 02");
        scheduledEvents.addEvent(LocalDate.of(2002, Month.JUNE,11),"My birthing","Attraction I");
        scheduledEvents.addEvent(LocalDate.of(2024, Month.DECEMBER,25),"Christmas,"," Attraction: birth of Jesus");

        System.out.println("Showing all scheduled events");
        scheduledEvents.displayScheduled();
        System.out.println("------------------------");

        System.out.println("Showing next scheduled event");
        scheduledEvents.gettingNextEvent();


    }
}
