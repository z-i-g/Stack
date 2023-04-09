import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

    List<T> innerStorage;
    public Stack()
    {
        innerStorage = new LinkedList<>();
    }

    public int size()
    {
        return innerStorage.size();
    }

    public T pop()
    {
        return size() == 0 ? null : innerStorage.remove(0);
    }

    public void push(T val)
    {
        innerStorage.add(0, val);
    }

    public T peek()
    {
        return size() == 0 ? null : innerStorage.get(0);
    }

    public static boolean bracketsAreBalanced(String bracketsList) {
        java.util.Stack<String> stack = new java.util.Stack();
        for (String s: bracketsList.split("")) {
            if ("(".equals(s)) {
                stack.push(s);
                continue;
            }
            if (stack.empty())
                return false;
            stack.pop();
        }
        return stack.empty();
    }
}