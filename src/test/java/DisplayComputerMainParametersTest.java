import model.Computer;
import org.junit.jupiter.api.Test;

public class DisplayComputerMainParametersTest {
    @Test
    public void createNewComputer() {
        Computer computer = new Computer();

        computer.setManufacturer("Sony");
        computer.setMotherBoard("Gigabyte H410M H V2 (rev. 1.7)");
        computer.setCPU("Intel Core i9-10900K");
        computer.setRAM("ADATA DDR4 16GB, 2400MHz");

        computer.displayComputerMainParameters();
    }
}
