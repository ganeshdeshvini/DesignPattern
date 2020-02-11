package designpatterns.command.filesystem.commandinterfacewithimplementation;

import designpatterns.command.filesystem.receiver.FileSystemReceiver;

public class CloseFileCommand implements Command {

	FileSystemReceiver fileSystemReceiver;

	public CloseFileCommand(FileSystemReceiver fileSystemReceiver) {
		this.fileSystemReceiver = fileSystemReceiver;
	}

	@Override
	public void execute() {
		this.fileSystemReceiver.closeFile();
	}
}
