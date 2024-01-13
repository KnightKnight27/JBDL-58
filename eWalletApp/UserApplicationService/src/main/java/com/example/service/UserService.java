package com.example.service;

import com.example.model.User;
import com.example.repository.UserCacheRepository;
import com.example.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements UserDetailsService {
    private static final String USER_CREATE_TOPIC = "user_created";

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCacheRepository userCacheRepository;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public void create(User user) throws JsonProcessingException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities("usr:svc");
        userRepository.save(user);
        JSONObject userObj = new JSONObject();
        userObj.put("phone",user.getPhone());
        userObj.put("name",user.getName());
        userObj.put("email",user.getEmail());
        kafkaTemplate.send(USER_CREATE_TOPIC,objectMapper.writeValueAsString(userObj));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
    public User get(Integer userId) throws Exception{
        User user = userCacheRepository.get(userId);
        if(user != null){
            return user;
        }
        user = userRepository.findById(userId).orElseThrow(()->new Exception());
        userCacheRepository.set(user);
        return user;
    }
}
