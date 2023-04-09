import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<String> stack = new Stack<>();

    @Test
    public void push_oneValueTest() {
        stack.push("1");

        assertEquals(1, stack.size());
        assertEquals(stack.innerStorage.get(0), "1");
    }

    @Test
    public void push_someValueTest() {
        stack.push("1");
        stack.push("2");
        stack.push("3");

        assertEquals(3, stack.size());
        assertEquals(stack.innerStorage.get(0), "3");
        assertEquals(stack.innerStorage.get(1), "2");
        assertEquals(stack.innerStorage.get(2), "1");
    }

    @Test
    public void pop_thenEmptyTest() {
        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void pop_thenNotEmptyTest() {
        stack.push("1");
        stack.push("2");
        stack.push("3");

        assertEquals(3, stack.size());
        assertEquals("3", stack.pop());
        assertEquals(2, stack.size());
        assertEquals("2", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("1", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void peek_thenEmptyTest() {
        assertNull(stack.peek());
    }

    @Test
    public void peek_thenNotEmptyTest() {
        stack.push("1");
        stack.push("2");
        stack.push("3");

        assertEquals("3", stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    public void bracketsAreBalancedTest() {
        assertTrue(Stack.bracketsAreBalanced("()()()"));
        assertTrue(Stack.bracketsAreBalanced("(()((())()))"));

        assertFalse(Stack.bracketsAreBalanced("())("));
        assertFalse(Stack.bracketsAreBalanced("))(("));
        assertFalse(Stack.bracketsAreBalanced("((())"));
        assertFalse(Stack.bracketsAreBalanced("())"));
    }
}