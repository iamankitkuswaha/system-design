package service;

import entity.User;
import repository.InMemoryRepository;

public class UserService {
    
    public UserService(){
    }
    
    public void addUser(User user){
        InMemoryRepository.userMap.put(user.getId(), user);
        System.out.println("User "+user.getName()+" added successfully!!");
    }
    
    public User getUser(String userId){
        if(InMemoryRepository.userMap.containsKey(userId)){
           return InMemoryRepository.userMap.get(userId);
        }
        System.out.println("User with id: "+userId+" not present.");
        return null;
    }
    
    public void removeUser(String userId){
        if(getUser(userId)!=null){
            InMemoryRepository.userMap.remove(userId);
            System.out.println("User with id: "+userId+" removed successfully");
        }else{
            throw new IllegalArgumentException("User with id: "+userId+" not present");
        }
    }
}
