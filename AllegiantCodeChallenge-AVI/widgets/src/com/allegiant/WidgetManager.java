package com.allegiant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implement these methods;
 */
public class WidgetManager {

	private List<Widget> widgets;
	
	public WidgetManager () {
		this.widgets = new ArrayList<Widget>();
	}
	
	public WidgetManager(List<Widget> list) {
		this.widgets = list;
	}
	
    /**
     * Returns the widget with the given id. If none is found, this method will return null;
     */
    public Widget get(int id) {
    	for(int i=0; i < widgets.size(); i++) {
    		if(widgets.get(i).getId()==id)
    			return widgets.get(i);
    	}
        return null;
    }

    /**
     * Adds the given widget to the manager.
     *
     */
    public void add(Widget addWidget) {
    	
    	widgets.add(addWidget);
    	return;
    }

    /**
     * Deletes the given widget from the manager
     */
    public void delete(Widget deleteWidget) {
    	if(this.get(deleteWidget.getId()) != null) {
    		widgets.remove(deleteWidget);
    	}
    }

    /**
     * Updates the widget with the given widget's id.
     * @Throws IllegalArgumentException if no widget with that ID is found
     */
    public void update(Widget updateWidget) {
    	for (int i=0; i < widgets.size(); i++) {
    		if (widgets.get(i).equals(updateWidget)) {
    			widgets.get(i).updateWidget(updateWidget.getTitle(), 
    										updateWidget.getDescription(), 
    										updateWidget.getSprockets());
    			return;
    		}
    	}
    	//if wanted widget does not exist
    	throw new IllegalArgumentException("The wanted widget does not exist");
    	
    }

    /**
     * Adds the given sprocket to the widget with the given ID.
     * @Throws IllegalArgumentException if no such widget is found.
     */
    public void addSprocket(int widgetId, Sprocket sprocket) {
    	// looping through the list
    	for (int i = 0; i < widgets.size(); i++) {
    		// finding the wanted widget
    		if(widgets.get(i).getId() == widgetId) {
    			widgets.get(i);
    			// add the sprocket to the widget
    			widgets.get(i).addSprocket(sprocket);
    			return;
    		}
    	}
    	//if wanted widget does not exist
    	throw new IllegalArgumentException ("The wanted widget does not exist");
    	
    }

    /**
     * Returns the sum of the prices of the sprockets in the given widget
     * @param widgetId
     * @throws IllegalArgumentException if no widget with that ID is found
     */
    public Double getTotalPrice (int widgetId) {
    	double totalPrice = 0;
    	// get wanted widget
    	Widget wantedWidget = this.get(widgetId);
    	// get the list of sprockets
    	List<Sprocket> sprockets = wantedWidget.getSprockets();
    	//count all the sprockets
    	for (int i =0; i <sprockets.size(); i++) {
    		totalPrice += sprockets.get(i).getPrice();
    	}
        return totalPrice;
    }

    /**
     *
     * returns all widgets whose title contains the given search string. (Use a case insensitive comparison)
     */
    public List<Widget> searchByTitle(String title) {
    	// create new Arraylist of widget to store the searched items
    	List<Widget> wantedWidgetList = new ArrayList<Widget>();
    	for (int i=0; i < widgets.size(); i++) {
    		// check if the title exist
    		if (widgets.get(i).getTitle().equals(title)) {
    			// if exist -> add to the new list
    			wantedWidgetList.add(widgets.get(i));
    			
    		}
    	}
        return wantedWidgetList;
    }

    /**
     * Returns all widgets whose description contains the given search string. (Use a case insensitive comparison)
     */
    public List<Widget> searchByDescription(String description){
    	// create new Arraylist of widget to store the searched items
    	List<Widget> wantedWidgetList = new ArrayList<Widget>();
    	// looping through the list
    	for (int i=0; i < widgets.size(); i++) {
    		// check if the title exist
    		if (widgets.get(i).getDescription().contains(description)) {
    			// if exist -> add to the new list
    			wantedWidgetList.add(widgets.get(i));
    			
    		}
    	}
        return wantedWidgetList;
    }

    /**
     * Returns the given input list sorted by title in ascending lexicographic order. ("Alpha","Beta","Charlie"...)
     *
     */
    public List<Widget> sortByTitle(List<Widget> inputs) {
    	Collections.sort(inputs, Comparator.comparing(Widget::getTitle));
     
        return inputs; // sorted list
    }

    public double getMeanSaturation(Widget widget) {
    	double totalSaturation = 0;
    	List<Sprocket> sprockets = widget.getSprockets();
    	// count total pricing
    	for (int i=0; i < sprockets.size(); i++) {
    		totalSaturation += sprockets.get(i).getColor().getSaturation();
    	}
    	return totalSaturation/sprockets.size();
    }
    
    
    
    
    /**
     * Returns the given input list sorted in order of the average saturation value of the color attributes of each widgets sprockets.
     */
    public List<Widget> sortBySaturation(List<Widget> inputs) {
    	
    	Collections.sort(inputs, new Comparator<Widget>() {
    		@Override
    		// using the compare method to compare two widgets
    		public int compare(Widget widget1, Widget widget2) {
    			// if mean saturation of widget1 is greater return 1
    			if (getMeanSaturation(widget1) > getMeanSaturation(widget2))
    				return 1;
    			if (getMeanSaturation(widget1) > getMeanSaturation(widget2))
    				return 0;
    			return -1;
    		}
    		
    	});
        return inputs;
    }



}
