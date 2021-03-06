package personal.com.sample.Utils.NetWorking;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ParseXML {
    //check for nullpointerexception in caller method
    //content includes raw xml data in string format
    /*
        todo add other event type cases
     */
    public static List<Object> parseXmlFeed(String content){
        try{
            boolean inDataItem = false;
            String currentTagName = "";
            Object object = null;   //DataType Object
            List<Object> data = new ArrayList<>();     //Holding data set

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(content));

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        currentTagName = parser.getName();
                        if (currentTagName.equals("desired tag name")){
                            inDataItem = true;
                            object = new Object();
                            data.add(object);
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("desired tag name"))
                            inDataItem = false;
                        currentTagName = "";
                        break;
                    case XmlPullParser.TEXT:
                        //Collecting data
                        if (inDataItem && object!=null){
                            switch (currentTagName){
                                case "TagOne":
                                    //call object setter method with desired data
                                    parser.getText();
                                    break;
                                case "TagTwo":
                                    //call object setter method with desired data
                                    parser.getText();
                                    break;
                                case "TagThree":
                                    //call object setter method with desired data
                                    parser.getText();
                                    break;
                            }
                        }
                        break;
                }
                //move to next event
                eventType = parser.next();
            }
            return data;
        }catch (XmlPullParserException e) {
            e.printStackTrace();
            //null in case of exception
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            //null in case of exception
            return null;
        }
    }
}
