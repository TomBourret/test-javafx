package fr.insalyon.teamparrot.testjavafx.event;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class EventBus {
    private static EventBus instance = new EventBus();

    public static EventBus getInstance() {
        return instance;
    }

    private Subject<Event> busSubject;

    private EventBus() {
        busSubject = PublishSubject.create();
    }

    public void subscribe(final Class<?> eventClass, Consumer<Event> consumer) {
        busSubject
                .filter(event -> event.getClass() == eventClass)
                .subscribe(consumer);
    }

    private void _post(Event value) {
        busSubject.onNext(value);
    }
    
    public static void post(Event event) {
        EventBus.getInstance()._post(event);
    }
}
