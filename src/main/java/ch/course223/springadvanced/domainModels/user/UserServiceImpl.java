package ch.course223.springadvanced.domainModels.user;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

/*
    SalaryOperationSingleResult bestEarningUser = (List<User> users) -> users.stream().sorted(Comparator.comparing(User::getSalary).reversed()).findFirst();
    SalaryOperationSingleResult worstEarningUser = (List<User> users) -> users.stream().sorted(Comparator.comparing(User::getSalary)).findFirst();

    SalaryOperationMultipleResults allUsersEarningMoreThan2000 = (List<User> users) -> users.stream().filter(user -> user.getSalary() > 2000).collect(Collectors.toList());
    SalaryOperationMultipleResults allUsersEarningLessThan2000 = (List<User> users) -> users.stream().filter(user -> user.getSalary() < 2000).collect(Collectors.toList());

    SalaryOperationMultipleResults allUsersEarningBetween200And3000 = (List<User> users) -> users.stream().filter(user -> user.getSalary() > 2000 && user.getSalary() < 3000).collect(Collectors.toList());

    SalaryOperationMultipleResults allUsersWithEvenEarnings = (List<User> users) -> users.stream().filter(user -> user.getSalary() % 2 == 0).collect(Collectors.toList());
    SalaryOperationMultipleResults allUsersWithOddEarnings = (List<User> users) -> users.stream().filter(user -> user.getSalary() % 2 != 0).collect(Collectors.toList());
*/

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getBestEarningUser() {
        Optional<User> user = userRepository.findAll().stream().sorted(Comparator.comparing(User::getSalary).reversed()).findFirst();
        if (user.isPresent()) {
            return user.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public User getWorstEarningUser() {
        Optional<User> user = userRepository.findAll().stream().sorted(Comparator.comparing(User::getSalary)).findFirst();
        if (user.isPresent()) {
            return user.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<User> allUsersWithEvenEarnings() {
        return userRepository.findAll().stream().filter(user -> user.getSalary() % 2 == 0).collect(Collectors.toList());
    }

    @Override
    public List<User> allUsersWithOddEarnings() {
        return userRepository.findAll().stream().filter(user -> user.getSalary() % 2 != 0).collect(Collectors.toList());
    }

    @Override
    public List<User> allUsersEarningMoreThan(int x) {
        return userRepository.findAll().stream().filter(user -> user.getSalary() > x).collect(Collectors.toList());
    }

    @Override
    public List<User> allUsersEarningLessThan(int x) {
        return userRepository.findAll().stream().filter(user -> user.getSalary() < x).collect(Collectors.toList());
    }

    @Override
    public List<User> allUsersEarningBetween(int x, int y) {
        return userRepository.findAll().stream().filter(user -> user.getSalary() > x && user.getSalary() < y).collect(Collectors.toList());
    }

    @Override
    public List<User> allUsersEarningAboveAverage() {
        var wrapper = new Object(){int salaryTotal = 0; int amountUsers = 0;};
        userRepository.findAll().stream().forEach(user -> {
            wrapper.salaryTotal += user.getSalary();
            wrapper.amountUsers++;
        });
        float average = wrapper.salaryTotal/wrapper.amountUsers;
        return userRepository.findAll().stream().filter(user -> user.getSalary() > average).collect(Collectors.toList());
    }

    // Question to be solved: What is a more ideal way of retrieving above values? 


}
