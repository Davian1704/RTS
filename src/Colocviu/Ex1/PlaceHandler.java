package Colocviu.Ex1;

import java.util.ArrayList;

import Colocviu.Ex1.Interfaces.PlaceHandlerTemplate;
import Colocviu.Ex1.Interfaces.PlaceTemplate;

public class PlaceHandler implements PlaceHandlerTemplate {

    ArrayList<PlaceTemplate> List;

    public PlaceHandler() {
        List = new ArrayList<PlaceTemplate>();
    }

    @Override
    public void AddPlace(PlaceTemplate place) {
        List.add(place);
    }

    @Override
    public PlaceTemplate GetPlaceByName(String Name) {
        for (PlaceTemplate placeTemplate : List) {
            if (placeTemplate.GetPlaceName() == Name) {
                return placeTemplate;
            }
        }
        return null;
    }

    @Override
    public String PrintAllPlaces() {
        String toPrint = "";
        for (PlaceTemplate placeTemplate : List) {
            toPrint = toPrint.concat(placeTemplate.Print());
        }
        return toPrint;
    }

}