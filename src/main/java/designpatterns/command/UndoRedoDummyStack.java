package designpatterns.command;

import java.util.Stack;

public class UndoRedoDummyStack<T> {
	// LinkedList<T> undoList = new LinkedList<T>();
	// LinkedList<T> redoList = new LinkedList<T>();
	Stack<T> undoList = new Stack<T>();
	Stack<T> redoList = new Stack<T>();
	// List<Integer> data

	void add(T data) {
		undoList.add(data);
		redoList.clear();
		System.out.println(data + " added to list");
	}

	void undo() {
		if (undoList.size() > 0) {
			T data = undoList.pop();
			System.out.println(data + " undoned");
			redoList.add(data);
		} else {
			System.out.println("No data to undo");
		}
	}

	void redo() {
		if (redoList.size() > 0) {
			T data = redoList.pop();
			System.out.println(data + " redone");
			undoList.add(data);
		} else {
			System.out.println("No data to redo");
		}
	}

	public static void main(String[] args) {
		UndoRedoDummyStack<Integer> undoRedoDummyStack = new UndoRedoDummyStack<>();
		undoRedoDummyStack.add(1);
		undoRedoDummyStack.add(2);
		undoRedoDummyStack.undo();
		undoRedoDummyStack.undo();
		// undoRedoDummyList.undo();
		// undoRedoDummyList.redo();
	}
}
