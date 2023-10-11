import model.Student;
import org.junit.jupiter.api.Test;

public class WorkingWithObjects {
    @Test
    public void creatingAndUsingObjects() {
        Student dima = new Student();
        dima.setFirstName("Дима");
        dima.setLastName("Мысливец");
        dima.setEmail("dimis@inbox.lv");
        dima.setAge(41);

        Student inna = new Student();
        inna.setFirstName("Инна");
        inna.setLastName("Мысливец");
        inna.setEmail("innadv@inbox.lv");
        inna.setAge(47);

        System.out.println(dima.getFirstName() + " + " + inna.getFirstName() + " = ");
        System.out.println("Любовь");
    }
}
