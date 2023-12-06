package Assignment1_OS;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Terminal3 
{
public String PathHandle(String p,String dpath)
{
	if(p.contains("\\"))
	{
		
		return p;
	}
	else
		{
		String path1 = dpath + "\\" + p;
		return path1;
		}
	
}
public String D_path = "C:\\Users\\bodyy\\OneDrive\\Desktop";
public static boolean check(String path)
		{
		String checkPath=path;
		File checkFile=new File(checkPath);
		if(checkFile.exists() && checkFile.isDirectory())
		{
			return true;
		}
		else {
		return false;
		}
		}
public String cat(String filename) throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		 String line;
		 StringBuilder resultStringBuilder = new StringBuilder();
		 int i = 0;
		 while ((line = br.readLine()) != null) {
		resultStringBuilder.append(line).append("\n");
		 }
		 return resultStringBuilder.toString();
	}
public static void cp (String Src_f,String Dest_f) 
	{
		FileInputStream is = null;
		FileOutputStream os = null;
		try{
		    File infile =new File(Src_f);
		    File outfile =new File(Dest_f);
		    is = new FileInputStream(infile);
		    os = new FileOutputStream(outfile);
		    byte[] buffer = new byte[1024];
		    int length;
		    while ((length = is.read(buffer)) > 0){
		    	os.write(buffer, 0, length);
		    }
		    is.close();
		    os.close();
			}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
public static void mkdir(String sourcePath,String path) 
	{
		int ind=sourcePath.lastIndexOf("\\");
		String filename="";
		
		if(ind==-1) {//short
			filename=sourcePath;
			sourcePath=path;
		}
		else {//long
			filename=sourcePath.substring(ind+1, sourcePath.length());
			sourcePath=sourcePath.substring(0,ind);
		}
		
		String checkPath=sourcePath;
		File checkFile=new File(checkPath);
		if(checkFile.exists() && checkFile.isDirectory()) {
			checkFile=new File(sourcePath+"\\"+filename);
			if(checkFile.exists()) {
			}
			else {
				checkFile.mkdir();
			}
		}
			

	}
public static void more (String file_name) throws IOException 
	{
		Scanner os1 = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		//String Path = p + "\\" + file_name;
		Scanner s = new Scanner(new File(file_name));
		while (s.hasNext()){
		    list.add(s.nextLine());
		}
		String[] a = list.toArray(new String[list.size()]);
		int index = list.size();
		int d = (int) Math.floor(index/5);
		boolean x= true;
		int g =0;
		int t =0;
		int count=0;
		{
			while(x == true) 
			{
				if(count == d) 
				{
					int j = (index%5);
					t+=j;
				}
				else {t+=5;}
				for(int i=g;i<t;i++) 
				{
				   System.out.println(a[i]);
				}
				g=t;
				count++;
				String ay2 = os1.nextLine();
				if(!(ay2.equals("more")) || !(count<=d)) 
				{
					x=false;
				}
			}
		}
	}
public void help() 
	{
		
		String[] help1 = {"cat:To write on a file","touch:To Create a file", "cd:To change the directory"
				,"mkdir: To create a directory"};

		for(int i=0;i<4;i++)
		{
			System.out.println(help1[i]);
		}
	}
public String ls(String p) 
	{
		String res="";
		String list[];
		File f1=new File(p);
		list=f1.list();
		for(int i=0;i<list.length;i++) 
		{
			res+=list[i];
			res+="\n";
		}
		return(res);
	}
public void rmdir(String p) 
{
	new File(p).delete();
}
public void mv (String s,String d) 
{
	File file = new File(s);
	File rename = new File(d);
	file.renameTo(rename);
}
public void rm (String Src_path) 
{
	File ds = new File (Src_path);
	ds.delete();
}
public void date (String d, Parser3 batt) throws IOException 
{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	if(batt.operator == true)
	{
		String path12 = d + "\\" + batt.User_Input2[1].substring(1);
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(path12));
		writer1.write(dtf.format(now));
		writer1.close();
	}
	else if(batt.operator2 == true) 
	{
		String path1 = d + "\\" + batt.User_Input2[1].substring(1);
		OutputStream os = new FileOutputStream(new File(path1), true);
		os.write("\n".getBytes(), 0, "\n".length());
		os.write(dtf.format(now).getBytes(), 0,dtf.format(now).length());
		os.close();
	}
}
public String date() 
{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	return(dtf.format(now));
}
public void ls(String p,Parser3 batt) throws IOException 
{
	if(batt.operator == true) 
	{
		String path12 = p + "\\" + batt.User_Input2[1].substring(1);
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(path12));
		writer1.write(ls(p));
		writer1.close();
	}
	if(batt.operator2 == true) 
	{
		String path12 = p + "\\" + batt.User_Input2[1].substring(1);
		OutputStream os = new FileOutputStream(new File(path12), true);
		os.write("\n".getBytes(), 0, "\n".length());
		os.write(ls(p).getBytes(), 0,ls(p).length());
		os.close();
	}
	if(batt.operator3 == true) 
	{
		if(batt.User_Input2[1].substring(1).equals("more")) 
		{
			FileWriter fw = null;
			BufferedWriter bw = null;
			PrintWriter out = null;
			 fw = new FileWriter("C:\\Users\\bodyy\\OneDrive\\Desktop\\tesr\\hima2.txt");
			    bw = new BufferedWriter(fw);
			    out = new PrintWriter(bw);
			    out.println(ls(p));
			    //out.flush();
			    out.close();
			    bw.close();
			    fw.close();
			    more("C:\\Users\\bodyy\\OneDrive\\Desktop\\tesr\\hima2.txt");
		}
	}
}
public void clear()
{
	for(int i =0;i<12;i++) 
	{
		System.out.println("\n");
	}
}
public void args(String k) 
{
	if(k.equals("cd")) 
	{
		System.out.println("cd:Takes 1 argument 'Path'");
	}
	if(k.equals("help")) 
	{
		System.out.println("Help: Takes no arguments");
	}
	if(k.equals("ls")) 
	{
		System.out.println("ls: Takes no arguments OR takes an operator and a File");
	}
	if(k.equals("rmdir")) 
	{
		System.out.println("rmdir: Takes 1 argument 'Path of Folder or directory'");
	}
	if(k.equals("cat")) 
	{
		System.out.println("cat: Takes 1 or more arguments'1 or more File OR 1 File + Operator + 1 File '");
	}
	if(k.equals("cp")) 
	{
		System.out.println("cp: Takes 2 arguments'2 Files'");
	}
	if(k.equals("mkdir")) 
	{
		System.out.println("mkdir: Take 1 argument 'Folder Name'");
	}
	if(k.equals("more")) 
	{
		System.out.println("more: Take 1 argument 'File'");
	}
	if(k.equals("mv")) 
	{
		System.out.println("");
	}
	if(k.equals("rm")) 
	{
		System.out.println("rm: Take 1 argument 'File'");
	}
	if(k.equals("date")) 
	{
		System.out.println("date: Takes no argument OR operator + 1 File");
	}
	if(k.equals("clear")) 
	{
		System.out.println("Clear: Takes no arguments");
	}
	if(k.equals("args")) 
	{
		System.out.println("args: Takes 1 argument 'Command'");
	}
}
public void cat(String filename,Parser3 p,Terminal3 q) throws IOException 
{
	if(p.operator == true) {
		String path1 = q.D_path + "\\" + p.User_Input2[1].substring(1);
		for(int i =1;i<p.User_Input3.length;i++)
	{
		if(p.getArguments21(i).length()!=0)
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(path1));
			writer.write(q.cat(PathHandle(p.getArguments21(i),q.D_path)));
			writer.close();
			p.operator =false;
			p.operator2 = false;
		}
		else 
		{
			break;
		}
	}
	}
	if(p.operator2 == true) {
		String path1 = q.D_path + "\\" + p.User_Input2[1].substring(1);
	for(int i =1;i<p.User_Input3.length;i++)
	{
		if(p.getArguments21(i).length()!=0)
		{
			OutputStream os = new FileOutputStream(new File(path1), true);
			os.write("\n".getBytes(), 0, "\n".length());
			os.write(q.cat(PathHandle(p.getArguments21(i),q.D_path)).getBytes(), 0,
					q.cat(PathHandle(p.getArguments21(i),q.D_path)).length());
			os.close();
			p.operator =false;
			p.operator2 = false;
		}
		else 
		{
			break;
		}
	}
	}
	if(p.operator3 == true) 
	{
		if(p.User_Input2[1].substring(1).equals("more")) 
		{
			FileWriter fw = null;
			BufferedWriter bw = null;
			PrintWriter out = null;
			 fw = new FileWriter("C:\\Users\\bodyy\\OneDrive\\Desktop\\tesr\\hima3.txt");
			    bw = new BufferedWriter(fw);
			    out = new PrintWriter(bw);
			    out.println(cat(PathHandle(p.User_Input3[1],q.D_path)));
			    out.close();
			    bw.close();
			    fw.close();
			    more("C:\\Users\\bodyy\\OneDrive\\Desktop\\tesr\\hima3.txt");
		}
	}
}
}







