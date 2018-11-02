package com.allegiant;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class WidgetReader {

    /**
     *
     * Reads data from the given input stream and attempts to parse it as a List of com.allegiant.Widget Objects, including their underlying sprockets.
     * @throws IOException
     */
	
    public static List<Widget> readFile(InputStream fileIn) throws IOException {
   
    // read the input stream file
    Reader inputStreamReader = new InputStreamReader(fileIn);
    // create JSON file data list type to read the JSON file
    Type listType = new TypeToken<List<Widget>>(){}.getType();
    // return out the widget list from the JSON file
    List<Widget> widgetList = new Gson().fromJson(inputStreamReader, listType);
    
	
    return widgetList;
    }
    
    
    
    
    
    /**
     * Writes the given list of com.allegiant.Widget objects to the given outputStream
     * @throws IOException
     */
    public static void writeFile(OutputStream fileOut, List<Widget> widgets) throws IOException {
    
    	Gson gson = new Gson();
    	
    	// convert java object to a JSON format and return the formatted string
    	String json = gson.toJson(widgets);
    	// write the converted JSON data to a file
    	OutputStreamWriter writer = new OutputStreamWriter(fileOut);
    	writer.write(json);
    	writer.close();
    	
    	
    	
    }

    public static void main (String[] args) throws IOException{
        InputStream in = new FileInputStream("widgets/resources/widgets.JSON");
        List<Widget> results = readFile(in);
        //System.out.println(results.size());
        OutputStream out = new FileOutputStream("widgets/resources/output.JSON");
        writeFile(out, results);
        
    }


}
