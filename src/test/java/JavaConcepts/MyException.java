package JavaConcepts;

@SuppressWarnings("serial")
class CustomException extends Exception {

	String str1;
	
	public CustomException(String str2) {
		str1 = str2;
	}
	
	public String toString(){
		return ("my exception occured : "+str1);
	}
	
}

public class MyException{
	   public static void main(String args[]){
		try{
			System.out.println("Starting of try block");
			// I'm throwing the custom exception using throw
			throw new CustomException("This is My error Message");
		}
		catch(CustomException exp){
			System.out.println("Catch Block") ;
			System.out.println(exp) ;
		}
	   }
	}
