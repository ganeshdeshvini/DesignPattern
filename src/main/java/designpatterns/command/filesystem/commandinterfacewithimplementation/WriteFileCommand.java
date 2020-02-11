package designpatterns.command.filesystem.commandinterfacewithimplementation;

import designpatterns.command.filesystem.receiver.FileSystemReceiver;

public class WriteFileCommand implements Command {
	FileSystemReceiver fileSystemReceiver;

	public WriteFileCommand(FileSystemReceiver fileSystemReceiver) {
		this.fileSystemReceiver = fileSystemReceiver;
	}

	@Override
	public void execute() {
		this.fileSystemReceiver.writeFile();
	}
}
