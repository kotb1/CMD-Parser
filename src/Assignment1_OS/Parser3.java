package Assignment1_OS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Parser3
{
	
		String[] args;
		String cmd;
		public boolean isparsed=false;
		public boolean operator=false;
		public boolean operator2=false;
		public boolean operator3=false;
		public String command= " ";
		public String command1= " ";
		String arg1= " ";
		String arg2= " ";
		Scanner in = new Scanner(System.in);
		public String[] User_Input = new String[10];
		public String[] User_Input1 = new String[10];
		public String[] User_Input2 = new String[5];
		public String[] User_Input3 = new String[5];
		public String[] copyCommands={"clear","cd", "ls", "cp", "mv", "rm",
			"mkdir", "rmdir", "cat", "more", "pwd","date","help","args","quit"};
		public void parse2()
		{
			
			boolean check= true;
			while(check==true)
			{
				String uinput= in.nextLine();
				User_Input1=uinput.split(" ");
				for(int i1 = 0; i1 < User_Input1.length;i1++)
				{
					if(User_Input1[i1].equals("<")) 
					{
						operator = true;
					}
					if(User_Input1[i1].equals("<<")) 
					{
						operator2 = true;
					}
					if(User_Input1[i1].equals("|")) 
					{
						operator3 = true;
					}
			if(operator == true) 
			{
				User_Input2=uinput.split("<");
				User_Input3=User_Input2[0].split(" ");	
				command1=User_Input3[0];
				int x=0;
				for(int j=0;j<copyCommands.length;j++)
				{
					if(command1.equals(copyCommands[j]))
					{
						check=false;
						break;
					}
					else if(command1!=copyCommands[j])
					{
						x++;
					}
					if(x==copyCommands.length)
					{
						System.out.println("Wrong command");
					}
					
				}
			}
			else if(operator2 == true) 
			{
				User_Input2=uinput.split("<<");
				User_Input3=User_Input2[0].split(" ");	
				command1=User_Input3[0];
				int x=0;
				for(int j=0;j<copyCommands.length;j++)
				{
					if(command1.equals(copyCommands[j]))
					{
						check=false;
						break;
					}
					else if(command1!=copyCommands[j])
					{
						x++;
					}
					if(x==copyCommands.length)
					{
						System.out.println("Wrong command");
					}
					
				}
			}
			else if(operator3 ==true) 
			{
				User_Input2=uinput.split("\\|");
				User_Input3=User_Input2[0].split(" ");	
				command1=User_Input3[0];
				int x=0;
				for(int j=0;j<copyCommands.length;j++)
				{
					if(command1.equals(copyCommands[j]))
					{
						check=false;
						break;
					}
					else if(command1!=copyCommands[j])
					{
						x++;
					}
					if(x==copyCommands.length)
					{
						System.out.println("Wrong command");
						check = false;
					}
					
				}
			}
			else {
				User_Input=uinput.split(" ");
				
				for(int i=0;i<3;i++)
				{
				if(i==0) 
				{
					command=User_Input[i];
					int x=0;
					for(int j=0;j<copyCommands.length;j++)
					{
						if(command.equals(copyCommands[j]))
						{
							check=false;
							break;
						}
						else if(command!=copyCommands[j])
						{
							x++;
						}
						if(x==copyCommands.length)
						{
							System.out.println("Wrong command");
						}
						
					}
				}
			}
			}
			}
			}
			
		}
		public String getCMd1() 
		{
			if(operator ==true || operator2 ==true || operator3 ==true) 
			{
				cmd = User_Input3[0];
				return cmd;
			}
			else 
			{	
			cmd=User_Input[0];
			return cmd;
			}
		}
		public String getArguments21(int index)
		{
		if(operator ==true) 
		{
			return User_Input3[index];
		}
		else 
		{
			return User_Input[index];
		}
		}
}






