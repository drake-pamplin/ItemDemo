package code.utils;

public class Constants {
    public static final String commandAdd = "ADD";
    public static final String commandAllMembers = "ALLMEMBERS";
    public static final String commandClear = "CLEAR";
    public static final String commandItems = "ITEMS";
    public static final String commandKeyExists = "KEYEXISTS";
    public static final String commandKeys = "KEYS";
    public static final String commandMemberExists = "MEMBEREXISTS";
    public static final String commandMembers = "MEMBERS";
    public static final String commandRemove = "REMOVE";
    public static final String commandRemoveAll = "REMOVEALL";
    
    public static final String exceptionMessageGeneric = "Invalid argument.";
    public static final String exceptionMessageItemsEmpty = "No items exist.";
    public static final String exceptionMessageKeyDoesNotExist = "Key \"%s\" does not exist.";
    public static final String exceptionMessageMemberDoesNotExist = "Member \"%s\" does not exist within Key \"%s\".";
    public static final String exceptionMessageMemberExists = "Member \"%s\" already exists within Key \"%s\".";

    public static final String fieldItemList = "Item List";
    public static final String fieldKey = "KEY";
    public static final String fieldMember = "MEMBER";

    public static final String messageAddCommand = "Add member to key: %s <%s> <%s>";
    public static final String messageAllMembersCommand = "Get all members from all keys: %s";
    public static final String messageClearCommand = "Clear all members and keys: %s";
    public static final String messageCommandHeader = "Commands:";
    public static final String messageItemsCommand = "Retrieve a list of all items: %s";
    public static final String messageKeyCommand = "Lookup a list of keys: %s";
    public static final String messageKeyExistsCommand = "Check if a key exists: %s";
    public static final String messageMemberExistsCommands = "Check if a member exists in a key: %s";
    public static final String messageMembersCommand = "Lookup a list of members for a key: %s";
    public static final String messageRemoveAllCommand = "Remove all members of a key: %s";
    public static final String messageRemoveCommand = "Remove member from key: %s <%s> <%s>";
}
