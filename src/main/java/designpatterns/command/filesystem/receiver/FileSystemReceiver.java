package designpatterns.command.filesystem.receiver;

public interface FileSystemReceiver {
	void openFile();

	void writeFile();

	void closeFile();
}
