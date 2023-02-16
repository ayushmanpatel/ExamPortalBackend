package com.examportal.service.UserServiceImpl;

import com.examportal.entity.User;
import com.examportal.entity.UserRole;
import com.examportal.repo.RoleRepository;
import com.examportal.repo.UserRepository;
import com.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local= this.userRepository.findByUserName(user.getUsername());
        if(local!=null){
            System.out.println("User is already is present!!");
            throw new Exception("user is already present!!");
        }else{
                for(UserRole ur:userRoles){
                    roleRepository.save(ur.getRole());
                }
                user.getUserRoles().addAll(userRoles);
                local=this.userRepository.saveAll(user);
        }
        return null;
    }
}
