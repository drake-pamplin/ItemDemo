package code.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import code.VO.Item;
import code.exception.InvalidArgException;
import code.utils.Constants;

public class ItemRepository {
    Map<String, Item> dictionary;

    public ItemRepository() {
        dictionary = new HashMap<>();
    }

    public void AddMemberToKey(String key, String member) throws InvalidArgException {
        if (!ContainsKey(key)) {
            Item item = new Item(key, new ArrayList<String>(Arrays.asList(member)));
            dictionary.put(key, item);
            return;
        }

        Item item = dictionary.get(key);
        if (item.getMembers().contains(member)) {
            String errorMessage = String.format(Constants.exceptionMessageMemberExists, member, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldMember, errorMessage);
        }
        item.getMembers().add(member);
        dictionary.put(key, item);
    }

    public void Clear() {
        dictionary.clear();
    }
    
    public boolean ContainsKey(String key) {
        return dictionary.containsKey(key);
    } 

    public boolean ContainsKeys() {
        return dictionary.size() != 0;
    }

    public boolean ContainsMember(String key, String member) throws InvalidArgException {
        if (!ContainsKey(key)) {
            String errorMessage = String.format(Constants.exceptionMessageKeyDoesNotExist, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldKey, errorMessage);
        }
        
        Item item = dictionary.get(key);
        return item.getMembers().contains(member);
    }
    
    public List<Item> GetAllItems() throws InvalidArgException {
        if (dictionary.size() == 0) {
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldItemList, Constants.exceptionMessageItemsEmpty);
        }
        return new ArrayList<>(dictionary.values());
    }

    public List<String> GetAllKeys() throws InvalidArgException {
        if (dictionary.size() == 0) {
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldItemList, Constants.exceptionMessageItemsEmpty);
        }
        return new ArrayList<>(dictionary.keySet());
    }

    public List<String> GetAllMembers() throws InvalidArgException {
        if (!ContainsKeys()) {
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldItemList, Constants.exceptionMessageItemsEmpty);
        }

        List<String> membersList = new ArrayList<>();
        for (Entry<String, Item> entry : dictionary.entrySet()) {
            for (String member : entry.getValue().getMembers()) {
                membersList.add(member);
            }
        }
        return membersList;
    }

    public List<String> GetAllMembersForKey(String key) throws InvalidArgException {
        if (!ContainsKey(key)) {
            String errorMessage = String.format(Constants.exceptionMessageKeyDoesNotExist, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldKey, errorMessage);
        }
        
        Item item = dictionary.get(key);
        return item.getMembers();
    }

    public void RemoveMemberForKey(String key, String member) throws InvalidArgException {
        if (!ContainsKey(key)) {
            String errorMessage = String.format(Constants.exceptionMessageKeyDoesNotExist, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldKey, errorMessage);
        }

        if (!ContainsMember(key, member)) {
            String errorMessage = String.format(Constants.exceptionMessageMemberDoesNotExist, member, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldMember, errorMessage);
        }

        Item item = dictionary.get(key);
        item.getMembers().remove(member);
        if (item.getMembers().size() == 0) {
            dictionary.remove(key);
        } else {
            dictionary.put(key, item);
        }
    }

    public void RemoveAllMembersForKey(String key) throws InvalidArgException {
        if (!ContainsKey(key)) {
            String errorMessage = String.format(Constants.exceptionMessageKeyDoesNotExist, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldKey, errorMessage);
        }

        dictionary.remove(key);
    }
}
