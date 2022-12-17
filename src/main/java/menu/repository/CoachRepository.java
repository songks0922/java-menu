package menu.repository;import java.util.ArrayList;import java.util.Collections;import java.util.List;import java.util.stream.Collectors;import menu.domain.Coach;import menu.exception.ExceptionMessage;public class CoachRepository {    private final List<Coach> coaches = new ArrayList<>();    public void addCoach(Coach coach) {        coaches.add(coach);    }    public Coach findByName(String name) {        Coach findCoach = coaches.stream().filter(coach -> coach.equalsByName(name))            .findAny()            .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.                NOT_FOUND_COACH_NAME.getErrorMessage()));        return findCoach;    }    public List<String> getCoachNames() {        ArrayList<String> names = coaches.stream().map(coach -> coach.getCoachName())            .collect(Collectors.toCollection(ArrayList::new));        return Collections.unmodifiableList(names);    }    public boolean isSuccess(int count) {        for (Coach coach : coaches) {            return coach.enoughMenu(count);        }        return true;    }    public List<Coach> getCoaches() {        return Collections.unmodifiableList(coaches);    }}