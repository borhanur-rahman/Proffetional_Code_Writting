import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static void main(String[] args)
	{

		//		Check arguments
		if(args.length!=1)
		{
			System.out.println( Constant.INVALID);
		}
		else if(args[0].equals("a"))
		{
			System.out.println(Constant.LOAD);
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(Constant.FILENAME)));
				String line = bufferedReader.readLine();
				String names[] = line.split(",");
				for(String name : names)
				{
					System.out.println(name);
				}
				bufferedReader.close();
			}
			catch (Exception e)
			{

			}
			System.out.println(Constant.LOADED);
		}
		else if(args[0].equals("r"))
		{
			System.out.println(Constant.LOAD);
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(Constant.FILENAME)));
				String line = bufferedReader.readLine();
				//System.out.println(line);
				String names[] = line.split(",");
				Random random = new Random();
				int index = random.nextInt(names.length);
				System.out.println(names[index]);
				bufferedReader.close();
			}
			catch (Exception e)
			{

			}
			System.out.println(Constant.LOADED);
		}
		else if(args[0].contains("+"))
		{
			System.out.println(Constant.LOAD);
			try
			{
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter(Constant.FILENAME, true));
				String name = args[0].substring(1);
				Date date = new Date();
				String dateformate = Constant.DATEFORMATE;
				DateFormat dateFormat = new SimpleDateFormat(dateformate);
				String formatDate= dateFormat.format(date);
				bufferedWriter.write(", "+name+"\nList last updated on "+formatDate);
				bufferedWriter.close();
			}
			catch (Exception e)
			{

			}

			System.out.println(Constant.LOADED);
		}
		else if(args[0].contains("?"))
		{
			System.out.println(Constant.LOAD);
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(Constant.FILENAME)));
				String studentName=args[0].substring(1);
				String line = bufferedReader.readLine();
				int index=line.indexOf(studentName);
				if(index==-1)
				{
					System.out.println("Not Found");
				}
				else
				{
					System.out.println("We Found it");
				}
				bufferedReader.close();
			}
			catch (Exception e)
			{

			}
			System.out.println(Constant.LOADED);
		}
		else if(args[0].contains("c"))
		{
			System.out.println(Constant.LOAD);
			try
			{
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(Constant.FILENAME)));
				String line = bufferedReader.readLine();
				String names[] = line.split(",");



				System.out.println(names.length +" word(s) found ");
				bufferedReader.close();
			}
			catch (Exception e)
			{

			}
			System.out.println(Constant.LOADED);
		}
		else
		{
			System.out.println( Constant.INVALID);
		}
	}
}
