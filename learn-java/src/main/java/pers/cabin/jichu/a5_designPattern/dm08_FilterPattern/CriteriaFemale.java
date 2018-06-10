package pers.cabin.jichu.a5_designPattern.dm08_FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiping on 2017/3/2.
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
