import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

	public static void main(String[] args) {
		ArrayList<String> taskList = new ArrayList<String>();
        Scanner tsknm = new Scanner(System.in);

        menu(taskList, tsknm);
                
	}
	
	public static void menu(ArrayList<String> taskList, Scanner tsknm) {
		do {
        	System.out.println("1. Add a task");
        	System.out.println("2. Remove a task");
        	System.out.println("3. Mark a task complete");
        	System.out.println("4. List the tasks");
        	System.out.println("Current list is " + taskList);
            System.out.println("What would you like to do?");
            if (tsknm.nextLine().contains("1")) {
                addTask(taskList, tsknm);
            }
            else if (tsknm.nextLine().contains("2")) {
                removeTask(taskList, tsknm);
            }
            else if (tsknm.nextLine().startsWith("3")) {
            	updateTask(taskList, tsknm);
            }
            else if (tsknm.nextLine().contains("4")) {
            	listTasks(taskList, tsknm);                
            }
            else {
            	continue;
            }
        } while (taskList.size() <= 200);
        tsknm.close();
        System.out.println("List is " + taskList);
        String[] arr = taskList.toArray(new String[0]);
        System.out.println("Array is " + Arrays.asList(arr));
	}
	
	public static void addTask(ArrayList<String> taskList, Scanner tsknm) {
		System.out.println("Enter the task to do : ");
        taskList.add(tsknm.nextLine());
        menu(taskList, tsknm);
        
	}
	
	public static void listTasks(ArrayList<String> taskList, Scanner tsknm){
		int currentPosition = 0;
		for(int i = 0; i < taskList.size(); i++) {
			currentPosition++;
    		System.out.println(currentPosition + ". " + taskList.get(i).toString());
    	}
		System.out.println("Want to go back? Enter \"exit\" in the console");
        if(tsknm.next().contains("exit")) {
        	menu(taskList, tsknm);
//        	taskList.add(tsknm.nextLine());
        }
        
    }
	
	public static void removeTask(ArrayList<String> taskList, Scanner tsknm) {
		
        do {
        	int currentPosition = 0;
        	for(int i = 0; i < taskList.size(); i++) {
        		currentPosition++;
        		System.out.println(currentPosition + ". " + taskList.get(i).toString());
        	}

            System.out.println("Current list is " + taskList);
            System.out.println("Do you want to remove a task? (y/n)");
            if (tsknm.next().startsWith("y")) {
                System.out.println("Enter task name : ");
                taskList.remove(tsknm.next());
            } else {
                break;
            }
        } while (taskList.size() <= 1);
        menu(taskList, tsknm);
//        taskList.add(tsknm.nextLine());
        
	}
	
	public static void updateTask(ArrayList<String> taskList, Scanner tsknm) {
		do {
        	int currentPosition = 0;
        	for(int i = 0; i < taskList.size(); i++) {
        		currentPosition++;
        		System.out.println(currentPosition + ". " + taskList.get(i).toString());
        	}

            System.out.println("Current list is " + taskList);
            System.out.println("Do you want to update a task? (y/n)");
            if (tsknm.next().startsWith("y")) {
                System.out.println("Enter task name : ");
                taskList.set(taskList.size(), tsknm.next());
            } else {
                break;
            }
        } while (taskList.size() <= 1);
        menu(taskList, tsknm);
	}
	
    @SuppressWarnings("resource")
    public static String ReadInputString(){
        // declare a new Scanner object
        Scanner scan = new Scanner(System.in);

        // read in user input and store it in the scanned variable
        String scanned = scan.nextLine();

        // return the String result to wherever the "StudentHelper.ReadInputString()" is called
        return scanned;
    }

    @SuppressWarnings("resource")
    public static int ReadInputInt(){
        // declare a new Scanner object
        Scanner scan = new Scanner(System.in);

        // read in user input and store it in the scanned variable
        int scanned = scan.nextInt();

        // return the int result to wherever the "StudentHelper.ReadInputInt()" is called
        return scanned;
    }

}
