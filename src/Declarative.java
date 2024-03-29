import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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

    // (User user) -> user.gender == Gender.MALE
    public static boolean isFemale(User user) {
        return user.gender == Gender.FEMALE;
    }
}

public class Declarative {

    public static Double sumLimitCards(List<User> users, Predicate<User> filter) {
        return users
                .stream()
                .filter(filter)
                .mapToDouble(user -> user.cardLimit)
                .sum();
    }

    public static void main(String[] args) {

        final List<User> users = Arrays.asList(
                new User("Antônio", Gender.MALE, 100),
                new User("João", Gender.MALE, 120),
                new User("Maria", Gender.FEMALE, 160));

        final Double sumLimitCardsMaleUsers = sumLimitCards(users, (User user) -> user.gender == Gender.MALE);
        final Double sumLimitCardsFemaleUsers = sumLimitCards(users, User::isFemale);

        System.out.println(sumLimitCardsMaleUsers);
        System.out.println(sumLimitCardsFemaleUsers);
    }
}