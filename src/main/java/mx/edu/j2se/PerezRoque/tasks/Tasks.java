package mx.edu.j2se.PerezRoque.tasks;

import java.time.LocalDateTime;
import java.util.*;

public class Tasks {

    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        AbstractTaskList output = TaskListFactory.createTaskList((tasks instanceof ArrayTaskList) ?
                ListTypes.types.ARRAY : ListTypes.types.LINKED);
        tasks.forEach(element-> {
            if(element.isActive()){
                try{
                    if(start.isBefore(element.nextTimeAfter(start)) &&
                            end.isAfter(element.nextTimeAfter(start))){
                        output.add(element);
                    }
                }catch (NullPointerException e){

                }

            }
        });
        return output;
    }

    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        SortedMap<LocalDateTime, Set<Task>> map = new TreeMap<LocalDateTime, Set<Task>>();

        tasks.forEach(element->{
            if(element.isActive()){
                if(element.isRepeated() && !start.isAfter(element.getEndTime()) && !end.isBefore(element.getStartTime())){
                    LocalDateTime aux = element.nextTimeAfter(start);
                    while(aux.isAfter(start) && aux.isBefore(end)){
                        if(map.containsKey(aux)){
                            map.get(aux).add(element);
                        }else {
                            Set<Task> s = new HashSet<Task>();
                            s.add(element);
                            map.put(aux, s);
                        }
                        aux = aux.plusNanos(element.getRepeatInterval().getNano());
                        aux = aux.plusSeconds(element.getRepeatInterval().getSecond());
                        aux = aux.plusMinutes(element.getRepeatInterval().getMinute());
                        aux = aux.plusHours(element.getRepeatInterval().getHour());
                        //interval in not functioning well
                        //aux = aux.plusDays(element.getRepeatInterval().getDayOfMonth());
                        //aux = aux.plusMonths(element.getRepeatInterval().getMonthValue());
                        //aux = aux.plusYears(element.getRepeatInterval().getYear());
                    }
                }else if(!element.isRepeated() && start.isBefore(element.getTime()) && end.isAfter(element.getTime())){
                    if(map.containsKey(element.getTime())){
                        map.get(element.getTime()).add(element);
                    }else {
                        Set<Task> s = new HashSet<Task>();
                        s.add(element);
                        map.put(element.getTime(), s);
                    }
                }
            }
        });
        return map;
    }

}
