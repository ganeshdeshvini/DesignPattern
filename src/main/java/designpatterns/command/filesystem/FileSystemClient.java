package designpatterns.command.filesystem;

import designpatterns.command.filesystem.commandinterfacewithimplementation.CloseFileCommand;
import designpatterns.command.filesystem.commandinterfacewithimplementation.OpenFileCommand;
import designpatterns.command.filesystem.commandinterfacewithimplementation.WriteFileCommand;
import designpatterns.command.filesystem.invoker.FileInvoker;
import designpatterns.command.filesystem.receiver.FileSystemReceiver;

public class FileSystemClient {

    public static void main(String[] args) {
        // creating the Receiver Object
        FileSystemReceiver fileSystemReceiver = FileSystemReceiverFactory.getInstance(FileSystemReceiverType.WINDOWS);

        // creating command & associating with Receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fileSystemReceiver);

        // creating invoker & associating with Command
        FileInvoker file = new FileInvoker(openFileCommand);

        // perform action on invoker object
        file.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fileSystemReceiver);
        file = new FileInvoker(writeFileCommand);
        file.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystemReceiver);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }

}
