package service;


import entity.Expense;
import entity.Group;
import entity.User;
import repository.InMemoryRepository;

public class GroupService {
    public GroupService(){
    }

    public void addGroup(Group group){
        InMemoryRepository.groupMap.put(group.getId(), group);
    }

    public void addMemberToGroup(String groupId, User user){
        if(InMemoryRepository.groupMap.containsKey(groupId)){
            InMemoryRepository.groupMap.get(groupId).getGroupMembers().add(user);
        }else{
            System.out.println("Group with id: "+groupId+" not present");
        }
    }

    public void addExpenseToGroup(String groupId, Expense expense){
        if(InMemoryRepository.groupMap.containsKey(groupId)){
            InMemoryRepository.groupMap.get(groupId).getExpensesList().add(expense);
        }else{
            System.out.println("Group with id: "+groupId+" not present");
        }
    }

    public void removeGroup(String groupId){
        if(InMemoryRepository.groupMap.containsKey(groupId)){
            InMemoryRepository.groupMap.remove(groupId);
        }else{
            System.out.println("Group with id: "+groupId+" not present");
        }
    }

    public void removeUserFromGroup(String groupId,  User user){
        if(InMemoryRepository.groupMap.containsKey(groupId)){
            if(InMemoryRepository.groupMap.get(groupId).getGroupMembers().contains(user)){
                InMemoryRepository.groupMap.get(groupId).getGroupMembers().remove(user);
            }else{
                System.out.println("User is not present in the group!!");
            }
        }else{
            System.out.println("Group with group id: "+groupId+" is not present!!");
        }
    }
}
