package kr.hs.dgsw.demo;

import java.util.List;

interface UserService {
    List<User> list();
    User view(String id);
    boolean add(User user);
    User update(User user);
    boolean delete(String id);
}
