package list.ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderingPeople {

    private List<People> peopleList;


    public OrderingPeople() {
        this.peopleList = new ArrayList<People>();
    }

    public void addPeople(String name, int age, double height) {
        peopleList.add(new People(name, age, height));
    }


    public List<People> orderPeopleByAge() {
        List<People> peopleByAge = new ArrayList<>(peopleList);
        Collections.sort(peopleByAge);
        return peopleByAge;
    }


    public List<People> orderByHeight() {
        List<People> peopleByHeight = new ArrayList<>(peopleList);
        Collections.sort(peopleByHeight, new ComparatorByHeight());
        return peopleByHeight;
    }


    public static void main(String[] args) {
        OrderingPeople orderingPeople = new OrderingPeople();
        orderingPeople.addPeople("Nome 1", 30, 1.56);
        orderingPeople.addPeople("Nome 2", 29, 1.76);
        orderingPeople.addPeople("Nome 3", 28, 1.86);
        orderingPeople.addPeople("Nome 4", 27, 1.96);


        System.out.println(orderingPeople.orderByHeight());
        System.out.println(orderingPeople.orderPeopleByAge());

    }
}
