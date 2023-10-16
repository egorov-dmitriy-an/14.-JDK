import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Developer devFront = new DeveloperFront();
        Developer devBack = new DeveloperBack();
        Developer devFull = new DeveloperFull();
        List<Developer> devList = Arrays.asList(devFull, devFront, devBack);

        for (Developer dev : devList
        ) {
            ShowDetails.show(dev);
        }
    }
}