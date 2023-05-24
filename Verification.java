package Login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Verification {

	public static void main(String[] args) 
	{
		BufferedReader read = null;
		BufferedWriter write = null;
		String line ;
		int row = 1;
		try {
			while((line = read.readLine())!= null)
			{
				read = new BufferedReader(new FileReader("input file"));
				write = new BufferedWriter(new FileWriter("output file"));
				String[] l1 = line.split(",");
				String email = l1[0];
				String age = l1[1];
				String name = l1[2];
				String password = l1[3];
				String gender =  l1[5];
				String lang = l1[5];
				String mob_no = l1[6];
				Verification.verifyEmail(email, row, write);
				verifyAge(age,row,write);
				verifyName(name, row, write);
				verifyPassword(password, row, write);
				verifyGender(gender, row, write);
				verifyLang(lang, row, write);
				verifyMob(mob_no, row, write);
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(read!=null) {
					read.close();
				}
				if(write!=null) {
					write.close();
				}
			}
			catch(IOException io)
			{
				io.printStackTrace();
			}
		}
	}
	public static void verifyEmail(String email,int row ,BufferedWriter write)
	{
		if(email.isEmpty()||email.isBlank())
		{
			try {
				write.write("Entered email is empty or blank in row no "+ row );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			if(email.length()>=6&&email.length()<=50)
			{
				if(email.contains("@")&&email.contains("."))
				{
					if(email.matches("[a-z0-9]+[@][a-z]+[//.][a-z]+{2,3}"))
					{
						System.out.println("email verified at row no "+row);
					}
				
					else
					{
						try {
							write.write("Entered valid email row no "+ row );
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				else
				{
					try {
						write.write("Entered email does not contain @ or . at row no "+ row );
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else
			{
				try {
					write.write("Entered name is not in the range of 6 to 50 at row no "+ row );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void verifyAge(String age,int row ,BufferedWriter write)
	{
		int age1 = Integer.parseInt(age);
		if(age1>0&age1<=150)
		{
			System.out.println("Age is verified ");
		}
		else
		{
			try {
				write.write("Entered age not between 0 to 150 at row no "+ row );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void verifyName(String name,int row ,BufferedWriter write)
	{
		String name1 = name.trim();
		if(name1.isEmpty()||name1.isBlank())
		{
			try {
				write.write("Enter a valid name in row no "+ row );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			if(name1.length()>0&&name1.length()<=50)
			{
				if(name1.matches("[a-zA-Z ]+"))
				{
					System.out.println("name verified at row no "+ row);
				}
				else
				{
					try {
						write.write("Entered name contains number or special char at row no "+ row );
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else
			{
				try {
					write.write("Entered name is not in the range of 1 to 50 at row no "+ row );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void verifyPassword(String password,int row ,BufferedWriter write)
	{
		if(password.isEmpty()||password.isBlank())
		{
			try {
				write.write("Enter a valid password in row no "+ row );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			if(password.length()>=8&&password.length()<=50)
			{
				char[] pass = password.toCharArray();
				boolean hasCharacter = false ;
				boolean hasNumber = false ;
				boolean hasSpecialChar = false ;
				 for (char ch : pass) {
			            if (Character.isLetter(ch)) {
			                hasCharacter = true;
			            } else if (Character.isDigit(ch)) {
			                hasNumber = true;
			            } else if (ch == '@' || ch == '#') {
			                hasSpecialChar = true;
			            }
			        }
				 if(hasCharacter==true&&hasNumber==true&&hasSpecialChar==true)
				 {
					 System.out.println("Entered password is verified at row no "+row);
				 }
				 else
				 {
					 try {
						 
							write.write("Enter a valid password which cointain a combines of uppercase , lowercase and special character in row no "+ row );
						} catch (IOException e) {
							e.printStackTrace();
						}
				 }
			}
			else
			{
				try {
					write.write("Entered password is not in the range of 8 to 50 at row no "+ row );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void verifyGender(String gender,int row ,BufferedWriter write)
	{
		if(gender.isEmpty()||gender.isBlank())
		{
			try {
				write.write("Enter a valid gender in row no "+ row );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			char gender1 = gender.charAt(0);
			if(gender1=='m'||gender1=='F'||gender1=='M'||gender1=='F')
			{
				System.out.println("Gender verified at row no " +row);
			}
			else
			{
				try {
					write.write("Entered gender is not valid at row no "+ row );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void verifyLang(String lang,int row,BufferedWriter write)
	{
		String [] language = {"english","hindi","marathi","french","german"}; 
		boolean a=false;
		if(lang.isEmpty()||lang.isBlank())
		{
			try {
				write.write("Entered language is not valid at row no "+ row );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			for(int i =0 ; i<language.length ; i++)
			{
				if(lang==language[i])
				{
					a=true;
				}
			}
			if(a==true)
			{
				System.out.println("entered language is verified at row no"+row);
			}
			else
			{
				try {
					write.write("Entered language is not valid at row no "+ row );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void verifyMob(String mob_no,int row ,BufferedWriter write)
	{
		if(mob_no.isEmpty()||mob_no.isBlank())
		{
			try {
				write.write("Enter a valid mobile number in row no "+ row );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			if(mob_no.length()==13)
			{
				if(mob_no.matches("\\+[1-9]\\d{1,2}[789]\\d{9}"))
				{
					System.out.println("Mobile number is verified at row no "+row);
				}
			}
			else
			{
				try {
					write.write("Entered mobile number is not valid at row no "+ row );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
