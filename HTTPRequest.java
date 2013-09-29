import java.net.URL ;
import java.util.Map ;
import java.util.HashMap ;

public class HTTPRequest{

	private URL url ; // if users do not specify port, URL default it to 80
	private String requestBody ;
	private Map<String, String> headers ;

	public HTTPRequest( URL url ){
		this( url, new HashMap<String,String>(), "" ) ;
	}

	public HTTPRequest( URL url, Map<String, String> headers){
		this( url, headers , "" ) ;
	}

	public HTTPRequest( URL url, Map<String, String> headers, String requestBody){
		
		this.url = url ;
		this.headers = headers ;
		this.requestBody = requestBody ;

	}

	public void addCookies(Map<String, String> cookies) {
		String key = "Cookie";
		String value = new String("empty");
		if (cookies.containsKey("csrftoken") && cookies.containsKey("sessionid")) {
			value = new String("csrftoken="+cookies.get("csrftoken")+"; sessionid="+cookies.get("sessionid"));
			System.out.println("both");
		}
		else if (cookies.containsKey("csrftoken")) {
			value = new String("csrftoken="+cookies.get("csrftoken"));
		}
		else if (cookies.containsKey("sessionid")) {
			value = new String("sessionid="+cookies.get("sessionid"));
		}
		this.headers.put(key, value);
	}

	public void setURL(URL url){
		this.url = url ;
	}

	public URL getURL(){
		return this.url ;
	}

	public void setRequestBody(String requestBody){
		this.requestBody = requestBody ;
	}

	public String getRequestBody(){
		return this.requestBody ;
	}

	public void setHeaders(Map<String, String> headers){
		this.headers = headers ;
	}

	public Map<String, String> getHeaders(){
		return this.headers ;
	}

	@Override
	public String toString(){
		return  "REQUEST :" + "\n" + 
				"URL : " + url.toString() + "\n" 				
				+ "HEADERS: " + "\n"
				+ headers.toString() + "\n"  
				+ "BODY : " + "\n" 
				+ (requestBody == null ? "" : requestBody )+ "\n" ;
	}

}
