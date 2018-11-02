package testCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import com.allegiant.Color;
import com.allegiant.Sprocket;
import com.allegiant.Widget;
import com.allegiant.WidgetManager;

class WidgetManagerTest {
	// define the manager	
	WidgetManager widgetManager = new WidgetManager();

	
	
	
	// testing get()
	@Test
	public void getTest() {
		// check if the widget id is matching the position in the widget list
		// Arrange		
		Widget widget1 = new Widget(1, "one", "description1", new ArrayList<>());
		
		this.widgetManager.add(widget1);
		
		//Act 
		Widget result = this.widgetManager.get(1);
		
		
				
		//Assert 
		assertEquals(result.getId(), widget1.getId());	
		
	}
	
	
	// test add()
	@Test 
	public void addTest() {
		// Arrange
		Widget widget2 = new Widget(2, "two", "description2", new ArrayList<>());
		
		// Act 
		this.widgetManager.add(widget2);
				
		// Assert 		
		Widget result = this.widgetManager.get(2);
		assertEquals(result.getId(), widget2.getId());
		
				
		
	}
	
	// test delete()
	@Test
	public void deleteTest() {
		
		// Arrange
		Widget widget3 = new Widget(3, "three", "description3", new ArrayList<>());
		this.widgetManager.add(widget3);
		
		// Act
		this.widgetManager.delete(widget3);
		
		// Assert
		Widget result = this.widgetManager.get(3);
		assertEquals(result, null);
		
		
	}
	
	// test update()
	@Test
	public void updateTest() {
		// Arrange
		Widget widget4 = new Widget(4, "four", "description4", new ArrayList<>());
		widgetManager.add(widget4);
		
		// Act
		Widget updatedWidget4 = new Widget(4, "four", "updated description4", new ArrayList<>());
		this.widgetManager.update(updatedWidget4);
		
		// Assert
		assertEquals(updatedWidget4.getDescription(), 
									this.widgetManager.get(widget4.getId()).getDescription());
		
		
	}
		
	
	
	 @Test
    public void addSprocketTest() {
		// Arrange
		Widget widget4 = new Widget(4, "four", "description4", new ArrayList<>());
		widgetManager.add(widget4);

		Sprocket sprocket = new Sprocket(12, 25.40, new Color(230,102,44));
        // Act
		// add one sprocket to widget where the id is 4
		widgetManager.addSprocket(4, sprocket);
		
		
		//Assert
        // check the number of sprockets of the widget with an id=3
        // assertEquals(1, widgetManager.get(3).getSprockets().size());
        // get that sprocket and check whether it is equal
        assertEquals(sprocket , widgetManager.get(4).getSprockets().get(0));
        
    }

    // to test getTotalPrice()
    @Test
    public void getTotalPriceTest() {
    	// Arrange
    	List<Sprocket> sprocketList = new ArrayList<Sprocket>();
    	
    	sprocketList.add(new Sprocket(11, 25.4, new Color(230,132,44)));
    	sprocketList.add(new Sprocket(12, 35.4, new Color(30,12,344)));
    	sprocketList.add(new Sprocket(13, 15.4, new Color(233,132,34)));
		
    	Widget widget4 = new Widget(4, "four", "description4", sprocketList);
		widgetManager.add(widget4);
        // Act
		double result = widgetManager.getTotalPrice(4);
		// Assert
		assertEquals(result, 76.2);
	
    }

    // to test searchByTitle()
    @Test
    public void searchByTitleTest() {
    	// Arrange 
		Widget widget1 = new Widget(1, "Title1", "description1", new ArrayList<>());
		widgetManager.add(widget1);
        // search term = 'Title1';
		// Act
		List<Widget> result = widgetManager.searchByTitle("Title1");
        // check the size of the list
        //assertEquals(1, searchByTitle.size());
        // and check the title of the fist element in the list
        assertEquals("Title1", result.get(0).getTitle());
    }

    // to test searchByDescription()
    @Test
    public void searchByDescriptionTest() {
    	Widget widget1 = new Widget(1, "Title1", "description1", new ArrayList<>());
		widgetManager.add(widget1);
        // search term = 'Title1';
		// Act
		List<Widget> result = widgetManager.searchByDescription("description1");
        // check the size of the list
        //assertEquals(1, searchByTitle.size());
        // and check the title of the fist element in the list
        assertEquals("description1", result.get(0).getDescription());
    }

    // to test sortByTitle() method
    @Test
    public void sortByTitle() {
		// Arrange
    	List<Widget> unsortedWidgets = new ArrayList<Widget>();
    	unsortedWidgets.add(new Widget(4, "four", "description4", new ArrayList<>()));
    	unsortedWidgets.add(new Widget(1, "one", "description1", new ArrayList<>()));
    	unsortedWidgets.add(new Widget(2, "two", "description2", new ArrayList<>()));
    	// Act
    	List<Widget> result = widgetManager.sortByTitle(unsortedWidgets);
    	// Assert
        assertEquals("two", result.get(2).getTitle());
    }
    
    /*
    // to test sortBySaturation() method
   
    @Test
    public void sortBySaturation() {
    	// Arrange
    	List<Widget> unsortedWidgets = new ArrayList<Widget>();
    	List<Sprocket> sprocketList1 = new ArrayList<Sprocket>();
    	sprocketList1.add(new Sprocket(11, 25.4, new Color(230,132,44)));
    	sprocketList1.add(new Sprocket(12, 35.4, new Color(30,12,244)));
    	sprocketList1.add(new Sprocket(13, 15.4, new Color(233,132,34)));
    	
    	
    	List<Sprocket> sprocketList2 = new ArrayList<Sprocket>();
    	sprocketList2.add(new Sprocket(1, 25.4, new Color(200,132,14)));
    	sprocketList2.add(new Sprocket(2, 35.4, new Color(100,132,144)));
    	sprocketList2.add(new Sprocket(3, 15.4, new Color(233,12,214)));
    	List<Sprocket> sprocketList3 = new ArrayList<Sprocket>();
    	sprocketList3.add(new Sprocket(17, 25.4, new Color(190,32,49)));
    	sprocketList3.add(new Sprocket(18, 35.4, new Color(35,192,204)));
    	sprocketList3.add(new Sprocket(19, 15.4, new Color(23,132,94)));
    	unsortedWidgets.add(new Widget(4, "four", "description4", sprocketList1));
    	unsortedWidgets.add(new Widget(1, "one", "description1", sprocketList2));
    	unsortedWidgets.add(new Widget(2, "two", "description2", sprocketList3)); 
    	// Act
    	List<Widget> result = widgetManager.sortBySaturation(unsortedWidgets);
    	// Assert
        assertEquals( , result.get(0).getSprockets().get(0).getColor().getSaturation());
    }
    */
}
