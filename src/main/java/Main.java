import entity.User;
import service.UserService;
import service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.getAll();
//        for (User user : userList) {
//            System.out.println(user);
//        }
        List<User> userList1 = userService.getBalanceById();
        for (User user : userList1) {
            System.out.println(user);
        }
    }
}
