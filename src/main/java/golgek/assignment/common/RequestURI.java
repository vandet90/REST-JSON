package golgek.assignment.common;

public class RequestURI {
	
	public static String HOST_NAME="";
	public static int PORT= 0;
	public static String PATH="";
	
	public static String getDomain(){
		
		String domain = "";
		if(RequestURI.PORT != 0){
			domain = RequestURI.HOST_NAME + ":" + RequestURI.PORT;
		}else{
			domain = RequestURI.HOST_NAME;
		}
		
		return domain;
	}
}

