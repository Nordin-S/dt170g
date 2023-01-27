package se.miun.dt170g.laboration01;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

// om det regnar, hur mycket blåst, temperatur, molnighet


public class Parser {

    private double value;   //Temp
    private double mps;     //WindSpeed
    private double percent;     //Cloudiness
    private double minValue, maxValue;  //Precipitation
    private String name;    //windDirection
    private String symbol;      //Symbol

    //CTOR
    public Parser() {};

    public double getValue() {
        return value;
    }

    public double getMps() {
        return mps;
    }

    public double getPercent() {
        return percent;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    //private String fileName = "/res/xml/weather.xml";
    //File file = new File(fileName);


    public void parse(String in) {

        XmlPullParserFactory factory;

        try {
            factory = XmlPullParserFactory.newInstance();
            //factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(new StringReader(in));

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                if(eventType == XmlPullParser.START_TAG) {

                    if(parser.getName().equals("windSpeed")){
                        mps = Double.parseDouble(parser.getAttributeValue(null, "mps"));
                    }
                    if(parser.getName().equals("windDirection")){
                        name = parser.getAttributeValue(null, "name");
                    }
                    if(parser.getName().equals("temperature")){
                        value = Double.parseDouble(parser.getAttributeValue(null, "value"));
                    }
                    if(parser.getName().equals("cloudiness")){
                        percent = Double.parseDouble(parser.getAttributeValue(null, "percent"));
                    }
                    if(parser.getName().equals("precipitation")){
                        minValue = Double.parseDouble(parser.getAttributeValue(null, "minvalue"));
                        maxValue = Double.parseDouble(parser.getAttributeValue(null, "maxvalue"));
                    }
                    if(parser.getName().equals("symbol")){
                        symbol = parser.getAttributeValue(null, "code");
                        break;
                    }
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
