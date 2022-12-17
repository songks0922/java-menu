package menu.view;import java.util.List;import menu.domain.Category;public class OutputView {    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";    private static final String EXIT_MESSAGE = "추천을 완료했습니다.";    public void printStartMessage() {        System.out.println(START_MESSAGE);    }    public void printResultMessage() {        System.out.println(RESULT_MESSAGE);    }    public void printCategory(List<Category> categories) {        String result = "[ 카테고리 | ";        for (int i = 0; i < 5; i++) {            if (i == 4) {                result += categories.get(i) + " ]";                break;            }            result += categories.get(i) + " | ";        }        System.out.println(result);    }    public void printRecommend(List<String> menu, String name) {        String result = "[ " + name + " | ";        for (int i = 0; i < 5; i++) {            if (i == 4) {                result += menu.get(i) + " ]";                break;            }            result += menu.get(i) + " | ";        }        System.out.println(result);    }    public void printDay() {        List<String> days = List.of("월요일", "화요일", "수요일", "목요일", "금요일");        String result = "[ 구분 | ";        for (int i = 0; i < 5; i++) {            if (i == 4) {                result += days.get(i) + " ]";                break;            }            result += days.get(i) + " | ";        }        System.out.println(result);    }    public void printExit() {        System.out.println(EXIT_MESSAGE);    }}