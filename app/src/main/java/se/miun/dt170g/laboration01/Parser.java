package se.miun.dt170g.laboration01;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// om det regnar, hur mycket blåst, temperatur, molnighet

public class Parser {
    private String fileName = "res/xml/weather.xml";
    File file = new File(fileName);


    public void parse() throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();

        parser.setInput(new FileReader(file));
        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            if(eventType == XmlPullParser.START_TAG) {
                System.out.println("START_TAG " + parser.getName());
            }
            else if(eventType == XmlPullParser.END_TAG) {
                System.out.println("END_TAG " + parser.getName());
            }
            else if(eventType == XmlPullParser.TEXT) {
                System.out.println("TEXT " + parser.getText());
            }
            eventType = parser.next();
        }
    }
}
