import com.javacto.dao.UserDao;
import com.javacto.dao.UserDaoImpl;
import com.javacto.po.User;
import com.javacto.utils.Page;

import java.util.List;

public class UserQueryTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        Page page = new Page();
        List<User> pageUser = userDao.getPageUser(page, null);
        for(User u:pageUser){
            System.out.println(u);
        }
        System.out.println(userDao.getTotalCount(null));
    }
}
