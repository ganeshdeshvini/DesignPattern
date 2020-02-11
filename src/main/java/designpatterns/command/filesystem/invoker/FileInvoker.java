package designpatterns.command.filesystem.invoker;


import designpatterns.command.filesystem.commandinterfacewithimplementation.Command;

public class FileInvoker {
	Command command;

	public FileInvoker(Command command) {
		this.command = command;
	}

	public void execute() {
		this.command.execute();
	}

}
