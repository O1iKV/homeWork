import Model.FamilyTree.FamilyTree;
import Model.Human.Human;
import Model.Human.Sex;
import Model.Service;
import View.Console;
import View.View;
import Presenter.Presenter;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataLoad<Рerson> tree = new DataLoad<>();//Работа с файлом
        //Фиксация персон в формате Имя, Фамилия, пол. Дата рождения и дата смерти гггг, мм, дд (без 0)
        //getByName - указание родителя
        TypeOfRelationship tree = new TypeOfRelationship();
        tree.addHuman(new Рerson("Владимир", "Никитин", Gender.Male,
                LocalDate.of(1938, 1, 8),  LocalDate.of(2008, 6, 10)));
        tree.addHuman(new Рerson("Александра", "Никитина", Gender.Female,
                LocalDate.of(1932,5, 6),LocalDate.of(2019,9, 5)));
        tree.addHuman(new Рerson("Елена", "Никитина", Gender.Female,
                LocalDate.of(1954, 2, 15), LocalDate.of(2022, 4, 1),
                tree.getByName("Александра", "Никитина"), tree.getByName("Владимир", "Никитин")));
        Service service = new Service(tree);
        View view = new Console();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}