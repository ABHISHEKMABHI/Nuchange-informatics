
import java.util.LinkedList;
import java.util.Scanner;

import com.google.gson.Gson;

public class jassignment {
	public static void main(String[] args) {

		LinkedList<j1> list = new LinkedList<j1>(); // Creating an LinkedList using class j1

		int x = 1;
		String jsonArray;

		do {
			System.out.println("Enter the command");
			Scanner sc = new Scanner(System.in);
			String user_command = sc.nextLine();
			String[] command = user_command.split(" ");

			// To store a url in the table
			if (command[0].equals("storeurl")) {
				int shortkey = command[1].hashCode();
				j1 newj = new j1(shortkey, command[1], 0);
				list.add(newj);
				System.out.println("url stored successfully");

			} else
			// incrementing count of the Url
			if (command[0].equals("get")) {
				int list_size = list.size();
				for (int i = 0; i < list_size; i++) {
					String value = list.get(i).name;
					if (value.equals(command[1])) {
						list.get(i).count += 1;
						System.out.println(list.get(i).shortkey + " count is incremented");
						break;
					}
				}
			} else
			// To view the Present Count of the url
			if (command[0].equals("count")) {
				int list_size = list.size();
				for (int i = 0; i < list_size; i++) {
					String value = list.get(i).name;
					if (value.equals(command[1])) {
						System.out.println(list.get(i).count + " is the present count");
						break;
					}
				}
			} else
			// Listing complete urls details in Json format
			if (command[0].equals("list")) {
				Gson js = new Gson(); // Creating an object js which is used to convert LinkedList to Json Format
				jsonArray = js.toJson(list);
				System.out.println(jsonArray);
			} else if (command[0].equals("exit")) {
				System.out.println("exiting");
				x = 0;
			} else {

				System.out.println("Entered command is wrong");

			}
		} while (x == 1);

	}
}
