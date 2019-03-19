package kr.hs.dgsw.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImp1 implements UserService {

    List<User> userList;

    public UserServiceImp1(){
        this.userList = new ArrayList<>();

        this.userList.add(new User("id1", "user1", "user1@dgsw"));
        this.userList.add(new User("id2", "user2", "user2@dgsw"));
        this.userList.add(new User("id3", "user3", "user3@dgsw"));
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(String id) {
        for(int i=0; i<userList.size(); i++){
            User found = this.userList.get(i);
            if(found.getId().equals(id))
                return found;
        }
        return null;
    }

    @Override
    public boolean add(User user) {
        User found = this.view(user.getId());
        if(found != null){
            return false;
        }
        return this.userList.add(user);
    }

    @Override
    public User update(User user) {
        User found = this.view(user.getId());
        if(found != null){
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    @Override
    public boolean delete(String id) {
        User found = this.view(id);
        return this.userList.remove(found);

    }

    /*

    // Iterator 이용
    public User find1(String name){
        Iterator<User> iterator = this.userList.iterator();
        while(iterator.hasNext()){
            User found = iterator.next();
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }

    // foreach 이용
    public User find2(String name){
        for(User found: this.userList) {
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }

    // stream 이용
    public User find3(String name){
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }

    */
}
