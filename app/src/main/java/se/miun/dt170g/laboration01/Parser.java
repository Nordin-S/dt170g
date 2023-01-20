package se.miun.dt170g.laboration01;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

// om det regnar, hur mycket blåst, temperatur, molnighet

public class Parser {

    private double value;
    private double windspeed;
    private double winddirections;
    private String name;
    private String cloudiness;
    private double percent, precipitation, minValue, maxValue;

    //Ctor
    public Parser() {

    }
    private String fileName = "/res/xml/weather.xml";
    File file = new File(fileName);


    public void parse() throws XmlPullParserException, IOException {

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();



        parser.setInput(new StringReader("<product class=\"pointData\">\n" +
                "<time datatype=\"forecast\" from=\"2023-01-20T15:00:00Z\" to=\"2023-01-20T15:00:00Z\">\n" +
                "<location altitude=\"90\" latitude=\"59.93\" longitude=\"10.72\">\n" +
                "<temperature id=\"TTT\" unit=\"celsius\" value=\"-3.0\"/>\n" +
                "<windDirection id=\"dd\" deg=\"177.9\" name=\"S\"/>\n" +
                "<windSpeed id=\"ff\" mps=\"0.7\" beaufort=\"1\" name=\"Flau vind\"/>\n" +
                "<windGust id=\"ff_gust\" mps=\"1.6\"/>\n" +
                "<humidity unit=\"percent\" value=\"73.0\"/>\n" +
                "<pressure id=\"pr\" unit=\"hPa\" value=\"1020.7\"/>\n" +
                "<cloudiness id=\"NN\" percent=\"1.6\"/>\n" +
                "<fog id=\"FOG\" percent=\"0.0\"/>\n" +
                "<lowClouds id=\"LOW\" percent=\"0.0\"/>\n" +
                "<mediumClouds id=\"MEDIUM\" percent=\"1.6\"/>\n" +
                "<highClouds id=\"HIGH\" percent=\"0.0\"/>\n" +
                "<dewpointTemperature id=\"TD\" unit=\"celsius\" value=\"-8.2\"/>\n" +
                "</location>\n" +
                "</time>\n" +
                "<time datatype=\"forecast\" from=\"2023-01-20T14:00:00Z\" to=\"2023-01-20T15:00:00Z\">\n" +
                "<location altitude=\"90\" latitude=\"59.93\" longitude=\"10.72\">\n" +
                "<precipitation unit=\"mm\" value=\"0.0\" minvalue=\"0.0\" maxvalue=\"0.0\"/>\n" +
                "<symbol id=\"Sun\" number=\"1\" code=\"clearsky_day\"/>\n" +
                "</location>\n" +
                "</time>\n" +
                "<time datatype=\"forecast\" from=\"2023-01-20T16:00:00Z\" to=\"2023-01-20T16:00:00Z\">\n" +
                "<location altitude=\"90\" latitude=\"59.93\" longitude=\"10.72\">\n" +
                "<temperature id=\"TTT\" unit=\"celsius\" value=\"-3.9\"/>\n" +
                "<windDirection id=\"dd\" deg=\"163.3\" name=\"S\"/>\n" +
                "<windSpeed id=\"ff\" mps=\"0.9\" beaufort=\"1\" name=\"Flau vind\"/>\n" +
                "<windGust id=\"ff_gust\" mps=\"1.5\"/>\n" +
                "<humidity unit=\"percent\" value=\"74.0\"/>\n" +
                "<pressure id=\"pr\" unit=\"hPa\" value=\"1021.8\"/>\n" +
                "<cloudiness id=\"NN\" percent=\"1.1\"/>\n" +
                "<fog id=\"FOG\" percent=\"0.0\"/>\n" +
                "<lowClouds id=\"LOW\" percent=\"0.0\"/>\n" +
                "<mediumClouds id=\"MEDIUM\" percent=\"1.1\"/>\n" +
                "<highClouds id=\"HIGH\" percent=\"0.0\"/>\n" +
                "<dewpointTemperature id=\"TD\" unit=\"celsius\" value=\"-9.1\"/>\n" +
                "</location>\n" +
                "</time>\n" +
                "<time datatype=\"forecast\" from=\"2023-01-20T15:00:00Z\" to=\"2023-01-20T16:00:00Z\">\n" +
                "<location altitude=\"90\" latitude=\"59.93\" longitude=\"10.72\">\n" +
                "<precipitation unit=\"mm\" value=\"0.0\" minvalue=\"0.0\" maxvalue=\"0.0\"/>\n" +
                "<symbol id=\"Sun\" number=\"1\" code=\"clearsky_night\"/>\n" +
                "</location>\n" +
                "</time>"));

        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {

            if(eventType == XmlPullParser.START_TAG) {

                if(parser.getName().equals("windSpeed")){
                    System.out.println("Vind i mps : " + parser.getAttributeValue(null, "mps"));
                    String wind = parser.getAttributeValue(null, "mps");
                }
                if(parser.getName().equals("temperature")){
                    System.out.println("temperature i celsius: " + parser.getAttributeValue(null, "value"));
                    String temperature = parser.getAttributeValue(null, "value");
                }
                if(parser.getName().equals("cloudiness")){
                    System.out.println("temperature i celsius: " + parser.getAttributeValue(null, "percent"));
                    String cloudiness = parser.getAttributeValue(null, "percent");
                }
                if(parser.getName().equals("precipitation")){
                    System.out.println("Regn i mm: " + parser.getAttributeValue(null, "value"));
                    String rain = parser.getAttributeValue(null, "value");
                }
                if(parser.getName().equals("symbol")){
                    System.out.println("symbol: " + parser.getAttributeValue(null, "number"));
                    String symbol = parser.getAttributeValue(null, "number");
                    break;
                }
            }

            eventType = parser.next();
        }
    }
}
