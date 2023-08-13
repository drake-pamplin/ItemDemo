package code.service;

import code.utils.Constants;
import lombok.Getter;

public class HelpService {
    @Getter
    private String commandList;

    public HelpService() {
        commandList = Constants.messageCommandHeader + "\n";
        commandList += String.format(Constants.messageAddCommand, Constants.commandAdd, Constants.fieldKey, Constants.fieldMember) + "\n";
        commandList += String.format(Constants.messageRemoveCommand, Constants.commandRemove, Constants.fieldKey, Constants.fieldMember) + "\n";
        commandList += String.format(Constants.messageKeyCommand, Constants.commandKeys) + "\n";
        commandList += String.format(Constants.messageMembersCommand, Constants.commandMembers, Constants.fieldKey) + "\n";
        commandList += String.format(Constants.messageRemoveAllCommand, Constants.commandRemoveAll, Constants.fieldKey) + "\n";
        commandList += String.format(Constants.messageClearCommand, Constants.commandClear) + "\n";
        commandList += String.format(Constants.messageKeyExistsCommand, Constants.commandKeyExists, Constants.fieldKey) + "\n";
        commandList += String.format(Constants.messageMemberExistsCommands, Constants.commandMemberExists, Constants.fieldKey, Constants.fieldMember) + "\n";
        commandList += String.format(Constants.messageAllMembersCommand, Constants.commandAllMembers) + "\n";
        commandList += String.format(Constants.messageItemsCommand, Constants.commandItems) + "\n";
        commandList += String.format(Constants.messageQuitCommand, Constants.commandQuit);
    }
}
