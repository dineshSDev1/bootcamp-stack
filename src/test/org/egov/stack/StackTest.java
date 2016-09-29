package test.org.egov.stack;

import static org.junit.Assert.*;

import org.egov.stack.Stack;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {

	 @Rule
	 public ExpectedException thrown = ExpectedException.none();
	
	 @Test
	 public void checkPushInStack() throws Exception
	 {
		 
		 //basic stack push test
		 Stack stack=new Stack();
		 stack.push("One");
		 stack.push(2);
		 stack.push(3.0);
		 stack.push("10+1");
		 stack.push(" 10 - 3");
		 stack.push(" 8* 8 ");
		 stack.push("10 / 2");
		 stack.push(" 10 ");
		 assertArrayEquals(new Object[]{"One", 2, 3.0, 11.0, 7.0, 64.0, 5.0, 10.0 }, stack.toArray());
		 
		 //check null pointer exception
		 thrown.expect(NullPointerException.class);
		 stack.push(null);
	 }
	 
	 @Test
	 public void checkPopInStack() throws Exception
	 {
		 
		 //basic stack pop test
		 Stack stack=new Stack();
		 stack.push(0);
		 stack.push("A");
		 stack.push(1f);
		 assertEquals(1f, stack.pop());
		 assertArrayEquals(new Object[]{0, "A"}, stack.toArray());
		 
		 //empty stack pop return null test
		 stack=new Stack();
		 assertEquals(null, stack.pop());
	 }
	 
	 @Test
	 public void checkToArrayEmptyStack()throws Exception
	 {
		 Stack stack=new Stack();
		 assertArrayEquals(new Object[]{}, stack.toArray());
	 }
	 
	 @Test
	 public void checkStackSize()throws Exception
	 {
		 Stack stack=new Stack();
		 stack.push("A");
		 stack.push("B");
		 stack.push("C");
		 assertEquals(3, stack.size());
	 }
	 
	 @Test
	 public void checkStackIsEmpty()throws Exception
	 {
		 Stack stack=new Stack();
		 assertEquals(true, stack.isEmpty());
		 stack.push("1");
		 assertEquals(false, stack.isEmpty());
	 }
	 
	 @Test
	 public void checkIsContainsInStack()throws Exception
	 {
		 Stack stack=new Stack();
		 stack.push(1);
		 stack.push("tWo");
		 stack.push(3);
		 assertEquals(true, stack.contains("tWo"));
		 
		//check null pointer exception
		 thrown.expect(NullPointerException.class);
		 stack.contains(null);
	 }
	 
}
