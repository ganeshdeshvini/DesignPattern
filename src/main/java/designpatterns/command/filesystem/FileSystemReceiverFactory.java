package designpatterns.command.filesystem;


import designpatterns.command.filesystem.receiver.FileSystemReceiver;
import designpatterns.command.filesystem.receiver.UnixFileSystemReceiver;
import designpatterns.command.filesystem.receiver.WindowsFileSystemReceiver;

public class FileSystemReceiverFactory {

    public static FileSystemReceiver getInstance(FileSystemReceiverType fileSystemReceiverType) {
        switch (fileSystemReceiverType) {
            case WINDOWS:
                return new WindowsFileSystemReceiver();
            case UNIX:
                return new UnixFileSystemReceiver();
            default:
                throw null;
        }
    }
}
