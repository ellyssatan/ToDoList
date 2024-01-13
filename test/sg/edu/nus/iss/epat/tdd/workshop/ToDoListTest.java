package sg.edu.nus.iss.epat.tdd.workshop;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ToDoListTest extends TestCase {
   // Define Test Fixtures

   public ToDoListTest() {
      super();
   }

   @Before
   public void setUp() throws Exception {
      // Initialise Test Fixtures
   }

   @After
   public void tearDown() throws Exception {
      // Uninitialise test Fixtures
   }

   @Test
   public void testAddTask() {
      ToDoList todo = new ToDoList();
      Task newTask = new Task("Go run");
      todo.addTask(newTask);
      Collection<Task> list = todo.getAllTasks();
      assertTrue(list.contains(newTask));
   }

   @Test
   public void testGetStatus() {
      ToDoList todo = new ToDoList();
      Task tasks = new Task("test");
      todo.addTask(tasks);
      assertFalse(todo.getStatus("test"));
   }

   @Test
   public void testRemoveTask() {
      ToDoList todo = new ToDoList();
      Task task1 = new Task("test");
      Task task2 = new Task("test2");
      Task task3 = new Task("test3");
      todo.addTask(task1);
      todo.addTask(task2);
      todo.addTask(task3);
      todo.removeTask("test");
      assertFalse(todo.getAllTasks().contains(task1));
   }

   @Test
   public void testGetCompletedTasks() {
      ToDoList todo = new ToDoList();

      Task task1 = new Task("test", true);
      Task task2 = new Task("test2", true);
      todo.addTask(task1);
      todo.addTask(task2);

      Collection<Task> expected = new ArrayList<>();
      expected.add(task1);
      expected.add(task2);

      Collection<Task> actual = todo.getCompletedTasks();
      System.out.println(actual);

      assertTrue(actual.contains(task1));
      assertTrue(actual.contains(task2));

   }
}
