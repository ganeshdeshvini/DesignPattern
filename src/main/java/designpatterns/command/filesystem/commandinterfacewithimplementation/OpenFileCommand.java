package designpatterns.command.filesystem.commandinterfacewithimplementation;

import designpatterns.command.filesystem.receiver.FileSystemReceiver;

public class OpenFileCommand implements Command {

	FileSystemReceiver fileSystemReceiver;

	public OpenFileCommand(FileSystemReceiver fileSystemReceiver) {
		this.fileSystemReceiver = fileSystemReceiver;
	}

	@Override
	public void execute() {
		this.fileSystemReceiver.openFile();
	}

}
