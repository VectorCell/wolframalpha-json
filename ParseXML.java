import java.io.*;
import java.net.*;
import java.util.*;

import org.json.*;

public class ParseXML
{
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;

	public static void main(String[] args)
	{
		if (args.length > 0) {
			String xml = getXMLDocument(args[0]);
			String json = convertXMLtoJSON(xml);
			System.out.println(json);
	}	}

	public static String getXMLDocument(String urlString)
	{
		try {
			URL url = new URL(urlString);
			HttpURLConnection request1 = (HttpURLConnection) url.openConnection();
			request1.setRequestMethod("GET");
			request1.connect();
			InputStream is = request1.getInputStream();
			String inputStreamString = new Scanner(is,"UTF-8").useDelimiter("\\A").next();
			return inputStreamString;
		} catch (Exception ex) {
			return "";
		}
	}

	public static String convertXMLtoJSON(String xml)
	{
		try {
			JSONObject xmlJSONObj = XML.toJSONObject(xml);
			return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
		} catch (JSONException je) {
			return je.toString();
		}
	}
}