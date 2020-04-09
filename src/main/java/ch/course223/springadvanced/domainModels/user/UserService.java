package ch.course223.springadvanced.domainModels.user;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getBestEarningUser();
    User getWorstEarningUser();
    List<User> allUsersWithEvenEarnings();
    List<User> allUsersWithOddEarnings();
    List<User> allUsersEarningMoreThan(int x);
    List<User> allUsersEarningLessThan(int x);
    List<User> allUsersEarningBetween(int x, int y);
}
