package com.example.mongoproject.services;

import com.example.mongoproject.domain.User;
import com.example.mongoproject.dto.UserDto;
import com.example.mongoproject.repository.UserRepository;
import com.example.mongoproject.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user == null){
            throw new ObjectNotFoundException("User not found!");
        }
      return user.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDto(UserDto objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id){
        findById(id);
       userRepository.deleteById(id);
    }



    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj , obj);
        return  userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setId(obj.getId());
    }
}
