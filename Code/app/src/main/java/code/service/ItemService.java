package code.service;

import java.util.List;

import code.VO.Item;
import code.exception.InvalidArgException;
import code.repository.ItemRepository;
import code.utils.Constants;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;

    // Add member to key.
    public void AddMemberToKey(String key, String member) throws InvalidArgException {
        // Validate key and member.
        if (itemRepository.ContainsKey(key) && itemRepository.ContainsMember(key, member)) {
            String errorMessage = String.format(Constants.exceptionMessageMemberExists, member, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldMember, errorMessage);
        }

        // Add member to key.
        itemRepository.AddMemberToKey(key, member);
    }

    // Clear all members and keys.
    public void ClearRepository() {
        itemRepository.Clear();
    }

    // Check if a key exists.
    public boolean ContainsKey(String key) throws InvalidArgException {
        // Return check.
        return itemRepository.ContainsKey(key);
    }

    // Check if a member exists.
    public boolean MemberExists(String key, String member) throws InvalidArgException {
        boolean exists = false;
        
        try {
            exists = itemRepository.ContainsMember(key, member);
        } catch (InvalidArgException e) {
            exists = false;
        }
        
        // Return check.
        return exists;
    }

    // Get all items.
    public List<Item> GetAllItems() throws InvalidArgException {
        // Validate items exist.
        if (!itemRepository.ContainsKeys()) {
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldItemList, Constants.exceptionMessageItemsEmpty);
        }

        // Return all items.
        return itemRepository.GetAllItems();
    }

    // Get all keys.
    public List<String> GetAllKeys() throws InvalidArgException {
        // Validate items exist.
        if (!itemRepository.ContainsKeys()) {
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldItemList, Constants.exceptionMessageItemsEmpty);
        }

        // Return list of keys.
        return itemRepository.GetAllKeys();
    }

    // Get all members.
    public List<String> GetAllMembers() throws InvalidArgException {
        // Validate items exist.
        if (!itemRepository.ContainsKeys()) {
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldItemList, Constants.exceptionMessageItemsEmpty);
        }

        // Return member list.
        return itemRepository.GetAllMembers();
    }
    
    // Get all members for a key.
    public List<String> GetAllMembersForKey(String key) throws InvalidArgException {
        // Validate key exists.
        if (!itemRepository.ContainsKey(key)) {
            String errorMessage = String.format(Constants.exceptionMessageKeyDoesNotExist, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldKey, errorMessage);
        }

        // Return list of members for key.
        return itemRepository.GetAllMembersForKey(key);
    }

    // Remove all members from a key.
    public void RemoveAllMembersForKey(String key) throws InvalidArgException {
        // Validate key exists.
        if (!itemRepository.ContainsKey(key)) {
            String errorMessage = String.format(Constants.exceptionMessageKeyDoesNotExist, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldKey, errorMessage);
        }

        // Remove members for key.
        itemRepository.RemoveAllMembersForKey(key);
    }
    
    // Remove member from a key.
    public void RemoveMemberFromKey(String key, String member) throws InvalidArgException {
        // Validate key and member.
        if (!itemRepository.ContainsKey(key)) {
            String errorMessage = String.format(Constants.exceptionMessageKeyDoesNotExist, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldKey, errorMessage);
        }
        if (!itemRepository.ContainsMember(key, member)) {
            String errorMessage = String.format(Constants.exceptionMessageMemberDoesNotExist, member, key);
            throw new InvalidArgException(Constants.exceptionMessageGeneric, Constants.fieldMember, errorMessage);
        }

        // Remove member from key.
        itemRepository.RemoveMemberForKey(key, member);
    }
}
