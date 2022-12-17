package menu.domain;import java.util.ArrayList;import java.util.List;public class Coach {    private final String name;    private final List<Menu> unEatableMenu = new ArrayList<>();    public Coach(String name) {        this.name = name;    }    public void addUnEatableMenu(String menu) {        unEatableMenu.add(new Menu(menu));    }    public boolean equalsByName(String name) {        if (this.name.equals(name)) {            return true;        }        return false;    }    public String getCoachName() {        return name;    }}