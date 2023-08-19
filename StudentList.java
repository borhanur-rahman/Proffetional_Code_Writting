import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static void main(String[] args)
	{
		int argSize=0;

		for(String arg:args)
		{
			argSize++;
		}
		//		Check arguments
		if(argSize!=1)
		{
			System.out.println("Invalid Input");
		}
		else if(args[0].equals("a"))
		{
			System.out.println("Loading data ...");
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				String names[] = line.split(",");
				for(String name : names)
				{
					System.out.println(name);
				}
			}
			catch (Exception e)
			{

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r"))
		{
			System.out.println("Loading data ...");
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				System.out.println(line);
				String names[] = line.split(",");
				Random random = new Random();
				int index = random.nextInt();
				System.out.println(names[index]);
			}
			catch (Exception e)
			{

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");
			try
			{
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter("students.txt", true));
				String name = args[0].substring(1);
				Date date = new Date();
				String dateformate = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateformate);
				String formatDate= dateFormat.format(date);
				bufferedWriter.write(", "+name+"\nList last updated on "+formatDate);
				bufferedWriter.close();
			}
			catch (Exception e)
			{

			}

			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("?"))
		{
			System.out.println("Loading data ...");
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				String names[] = line.split(",");
				boolean done = false;
				String name = args[0].substring(1);
				for(int index = 0; index<names.length && !done; index++)
				{
					if(names[index].equals(name))
					{
						System.out.println("We found it!");
						done=true;
					}
				}
			}
			catch (Exception e)
			{

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c"))
		{
			System.out.println("Loading data ...");
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				char charArray[] = line.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char character:charArray)
				{
					if(character ==' ')
					{
						if (!in_word)
						{
							count++;
							in_word =true;
						}
						else
						{
							in_word=false;
						}
					}
				}
				System.out.println(count +" word(s) found " + charArray.length);
			}
			catch (Exception e)
			{

			}
			System.out.println("Data Loaded.");
		}
		else
		{
			System.out.println("Invalid Input.");
		}
	}
}
