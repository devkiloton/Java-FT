
import java.util.Arrays;
import java.util.List;

enum Gender {
    MALE, FEMALE
}

class User {
    public final String name;
    public final Gender gender;
    public final Double cardLimit;

    public User(String name, Gender gender, double cardLimit) {
        this.name = name;
        this.gender = gender;
        this.cardLimit = cardLimit;
    }
}

public class Imperative {

    public static Double sumLimitCards(List<User> users) {
        double sum = 0;

        for (int i = 0; i < users.size(); i++) {
            sum += users.get(i).cardLimit;
        }

        return sum;
    }

    public static Double sumLimitCardsMaleUsers(List<User> users) {
        double sum = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).gender == Gender.MALE) {
                sum += users.get(i).cardLimit;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        final List<User> users = Arrays.asList(
                new User("Antônio", Gender.MALE, 100),
                new User("João", Gender.MALE, 120),
                new User("Maria", Gender.FEMALE, 160));

        final Double sumLimitAllCards = sumLimitCards(users);
        System.out.println(sumLimitAllCards);
        final Double sumLimitCardsMaleUsers = sumLimitCardsMaleUsers(users);
        System.out.println(sumLimitCardsMaleUsers);

    }
}
