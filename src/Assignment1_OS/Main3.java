package Assignment1_OS;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
public class Main3
{
	public static void main (String[] args) throws IOException {
	Parser3 hoss= new Parser3();
	Terminal3 joe = new Terminal3();
	boolean x = true;
	while (x==true) 
	{
		System.out.println(joe.D_path);
		hoss.parse2();
		if(hoss.getCMd1().equals("cd")) 
		{
			if(joe.check(hoss.getArguments21(1))) 
			{
				joe.D_path = hoss.getArguments21(1);
			}
		}
		if(hoss.getCMd1().equals("cat")) 
		{
			if(hoss.operator == true || hoss.operator2 == true || hoss.operator3 == true) 
			{
				for(int i =1;i<hoss.User_Input3.length;i++) 
				{
					if(hoss.getArguments21(i).length()!=0) 
					{
						joe.cat(joe.PathHandle(hoss.getArguments21(i),joe.D_path)
								, hoss, joe);
					}
				}
			}
			else 
			{
				for(int i =1;i<hoss.User_Input.length;i++)
				{
					if(hoss.getArguments21(i).length()!=0)
					{
						System.out.println(joe.cat(joe.PathHandle(hoss.getArguments21(i),joe.D_path)
								));
					}
					else 
					{
						break;
					}
				}
			}
			
		}
		if(hoss.getCMd1().equals("mkdir"))
		{
			joe.mkdir(joe.PathHandle(hoss.getArguments21(1),joe.D_path),joe.D_path);
		}
		if(hoss.getCMd1().equals("more")) 
		{
			joe.more(joe.PathHandle(hoss.getArguments21(1),joe.D_path));
		}
		if(hoss.getCMd1().equals("cp")) 
		{
			String Src = joe.PathHandle(hoss.getArguments21(1),joe.D_path);
			String Dest = joe.PathHandle(hoss.getArguments21(2),joe.D_path);
			joe.cp(Src, Dest);
		}
		if(hoss.getCMd1().equals("help")) 
		{
			joe.help();
		}
		if(hoss.getCMd1().equals("ls"))
		{
			if(hoss.operator == true || hoss.operator2 == true || hoss.operator3 == true) 
			{
				joe.ls(joe.D_path,hoss);
				hoss.operator =false;
				hoss.operator2 = false;
				hoss.operator3 = false;
			}
			else
			{
				System.out.println(joe.ls(joe.D_path));
			}
		}
		if(hoss.getCMd1().equals("pwd")) 
		{
			System.out.println(joe.D_path);
		}
		if(hoss.getCMd1().equals("quit")) 
		{
			x=false;
		}
		if(hoss.getCMd1().equals("rmdir")) 
		{
			//joe.rmdir(joe.D_path + "\\" + hoss.getArguments21(1) );
			joe.rmdir(joe.PathHandle(hoss.getArguments21(1),joe.D_path));
		}
		if(hoss.getCMd1().equals("mv")) 
		{
			joe.mv(joe.PathHandle(hoss.getArguments21(1),joe.D_path)
					,joe.PathHandle(hoss.getArguments21(2),joe.D_path));
		}
		if(hoss.getCMd1().equals("rm")) 
		{
			joe.rm(joe.PathHandle(hoss.getArguments21(1),joe.D_path));
		}
		if(hoss.getCMd1().equals("date")) 
		{
			if(hoss.operator ==true || hoss.operator2 ==true) 
			{
				joe.date(joe.D_path,hoss);
				hoss.operator =false;
				hoss.operator2 = false;
			}
			else
				System.out.println(joe.date());
		}
		if(hoss.getCMd1().equals("clear")) 
		{
			joe.clear();
		}
		if(hoss.getCMd1().equals("args")) 
		{
			joe.args(hoss.getArguments21(1));
		} 
		
		
	}
	
	}
}