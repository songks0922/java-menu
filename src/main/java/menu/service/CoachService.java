package menu.service;import java.util.ArrayList;import java.util.Arrays;import java.util.List;import java.util.stream.Collectors;import menu.domain.Coach;import menu.repository.CoachRepository;public class CoachService {    private final CoachRepository coachRepository;    public CoachService() {        this.coachRepository = new CoachRepository();    }    private int flag = 0;    public void addCoaches(String inputCoachNames) {        List<String> coachNames = inputSeparator(inputCoachNames);        coachNames.stream().forEach(name -> coachRepository.addCoach(new Coach(name)));    }//    public boolean allEnough() {//        flag = 0;////        coachRepository.isSuccess();//    }    // TODO: 없는 메뉴 입력 시 예외처리 필요    public void addUnEatableMenu(String inputMenus, String name) {        List<String> menus = inputSeparator(inputMenus);        Coach coach = coachRepository.findByName(name);        for (String menu : menus) {            coach.addUnEatableMenu(menu);        }    }    public void addEatMenu(String menu, int count) {        List<String> coachNames = coachRepository.getCoachNames();        for (String coachName : coachNames) {            Coach findCoach = coachRepository.findByName(coachName);            if (findCoach.enoughMenu(count)) {                findCoach.addEatMenu(menu);                findCoach.addCount();                break;            }        }    }    public List<String> coachNames() {        return coachRepository.getCoachNames();    }    private List<String> inputSeparator(String inputCoachNames) {        List<String> convert = Arrays.stream(inputCoachNames.split(","))            .collect(Collectors.toCollection(ArrayList::new));        return convert;    }    public boolean success(int count) {        List<String> coachNames = coachRepository.getCoachNames();        for (String coachName : coachNames) {            Coach findCoach = coachRepository.findByName(coachName);            if (findCoach.enoughMenu(count)) {                return false;            }        }        return true;    }}