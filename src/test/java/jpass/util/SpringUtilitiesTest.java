package jpass.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.awt.Button;
import java.awt.Panel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.SpringLayout;

import org.junit.Test;

public class SpringUtilitiesTest {

	@Test
	public void shouldNotWorkEmptyContainerTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Panel container = new Panel();
			container.setLayout(new SpringLayout());
			SpringUtilities.makeGrid(container, 0, 0, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldNotWorkZeroAreaSizeTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Panel container = new Panel();
			container.add(new Button("Button 1"));
			container.setLayout(new SpringLayout());
			SpringUtilities.makeGrid(container, 0, 0, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldWorkPositiveAreaSizeTest() {
		Panel container = new Panel();
		container.add(new Button("Button 1"));
		container.setLayout(new SpringLayout());
		SpringUtilities.makeGrid(container, 1, 1, 0, 0, 0, 0);
	}
	
	@Test
	public void shouldNotPositiveAreaSizeGreaterThanComponentsTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Panel container = new Panel();
			container.add(new Button("Button 1"));
			container.add(new Button("Button 2"));
			container.add(new Button("Button 3"));
			container.add(new Button("Button 4"));
			container.add(new Button("Button 5"));
			container.setLayout(new SpringLayout());
			SpringUtilities.makeGrid(container, 6, 1, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldWorkPositiveAreaSizeGreaterThanComponentsTest() {
		Panel container = new Panel();
		Button b1 = new Button("Button 1");
		b1.setSize(1, 1);
        Button b2 = new Button("Button 2");
        b2.setSize(1, 1);
        Button b3 = new Button("Button 3");
        b3.setSize(1, 1);
        Button b4 = new Button("Button 4");
        b4.setSize(1, 1);
        Button b5 = new Button("Button 5");
        b5.setSize(1, 1);
		container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);
        container.add(b5);
		container.setLayout(new SpringLayout());
		SpringUtilities.makeGrid(container, 2, 2, 0, 0, 0, 0);
		SpringLayout layout = (SpringLayout) container.getLayout();
		SpringLayout.Constraints pCons = layout.getConstraints(container);
		assertEquals(b1.getWidth() + b2.getWidth(), pCons.getWidth().getValue());
		assertEquals(b1.getHeight()+ b3.getHeight(), pCons.getHeight().getValue());
	}
	
	@Test
    public void shouldWorkDifferentComponentSizesTest() {
        Panel container = new Panel();
        Button b1 = new Button("Button 1");
        b1.setSize(1, 1);
        Button b2 = new Button("Button 2");
        b2.setSize(1, 2);
        Button b3 = new Button("Button 3");
        b3.setSize(1, 1);
        Button b4 = new Button("Button 4");
        b4.setSize(1, 1);
        Button b5 = new Button("Button 5");
        b5.setSize(1, 1);
        container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);
        container.add(b5);
        container.setLayout(new SpringLayout());
        int cols = 2;
        int rows = 2;
        int xPad = 0;
        int yPad = 0;
        SpringUtilities.makeGrid(container, rows, cols, 0, 0, xPad, yPad);
        SpringLayout layout = (SpringLayout) container.getLayout();
        SpringLayout.Constraints pCons = layout.getConstraints(container);
        assertEquals(getMaxWidth(b1,b2,b3,b4,b5)*cols + xPad*(cols-1), pCons.getWidth().getValue());
        assertEquals(getMaxHeight(b1,b2,b3,b4,b5)*rows + yPad*(rows-1), pCons.getHeight().getValue());
    }
	
	@Test
    public void shouldWorkDifferentComponentSizesWithPaddingTest() {
        Panel container = new Panel();
        Button b1 = new Button("Button 1");
        b1.setSize(1, 1);
        Button b2 = new Button("Button 2");
        b2.setSize(1, 2);
        Button b3 = new Button("Button 3");
        b3.setSize(3, 1);
        Button b4 = new Button("Button 4");
        b4.setSize(1, 1);
        Button b5 = new Button("Button 5");
        b5.setSize(1, 1);
        Button b6 = new Button("Button 6");
        b6.setSize(1, 1);
        container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);
        container.add(b5);
        container.add(b6);
        container.setLayout(new SpringLayout());
        int cols = 3;
        int rows = 2;
        int xPad = 1;
        int yPad = 3;
        SpringUtilities.makeGrid(container, rows, cols, 0, 0, xPad, yPad);
        SpringLayout layout = (SpringLayout) container.getLayout();
        SpringLayout.Constraints pCons = layout.getConstraints(container);
        assertEquals(getMaxWidth(b1,b2,b3,b4,b5,b6)*cols + xPad*cols, pCons.getWidth().getValue());
        assertEquals(getMaxHeight(b1,b2,b3,b4,b5,b6)*rows + yPad*rows, pCons.getHeight().getValue());
    }
	
	private int getMaxWidth(Button... buttons) {
	    List<Integer> widths = Arrays.asList(buttons).stream().map((b)->b.getWidth()).collect(Collectors.toList());
	    return Collections.max(widths);
    }
	
	private int getMaxHeight(Button... buttons) {
	    List<Integer> heights = Arrays.asList(buttons).stream().map((b)->b.getHeight()).collect(Collectors.toList());
        return Collections.max(heights);
    }
	
	//////////////////////////////////COMPACT GRID TESTS//////////////////////////////////
	
	@Test
	public void shouldNotWorkEmptyContainerCompactTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Panel container = new Panel();
			container.setLayout(new SpringLayout());
			SpringUtilities.makeCompactGrid(container, 1, 1, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldNotWorkZeroAreaSizeCompactTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Panel container = new Panel();
			container.add(new Button("Button 1"));
			container.setLayout(new SpringLayout());
			SpringUtilities.makeCompactGrid(container, 0, 0, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldWorkPositiveAreaSizeCompactTest() {
		Panel container = new Panel();
		container.add(new Button("Button 1"));
		container.setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(container, 1, 1, 0, 0, 0, 0);
	}
	
	@Test
	public void shouldNotPositiveAreaSizeGreaterThanComponentsCompactTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Panel container = new Panel();
			container.add(new Button("Button 1"));
			container.add(new Button("Button 2"));
			container.add(new Button("Button 3"));
			container.add(new Button("Button 4"));
			container.add(new Button("Button 5"));
			container.setLayout(new SpringLayout());
			SpringUtilities.makeCompactGrid(container, 6, 1, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldWorkPositiveAreaSizeGreaterThanComponentsCompactTest() {
		Panel container = new Panel();
		Button b1 = new Button("Button 1");
		container.add(b1);
        b1.setSize(1, 1);
        Button b2 = new Button("Button 2");
		container.add(b2);
        b2.setSize(1, 2);
        Button b3 = new Button("Button 3");
		container.add(b3);
        b3.setSize(3, 1);
        Button b4 = new Button("Button 4");
		container.add(b4);
        b4.setSize(1, 1);
        Button b5 = new Button("Button 5");
		container.add(b5);
        b5.setSize(1, 1);
        Button b6 = new Button("Button 6");
        b6.setSize(1, 1);
        container.add(b6);
		container.setLayout(new SpringLayout());
        int cols = 3;
        int rows = 2;
        int xPad = 1;
        int yPad = 3;
        SpringUtilities.makeCompactGrid(container, rows, cols, 0, 0, xPad, yPad);
        SpringLayout layout = (SpringLayout) container.getLayout();
        SpringLayout.Constraints pCons = layout.getConstraints(container);
        assertEquals(5 + cols*xPad, pCons.getWidth().getValue());
        assertEquals(3 + rows*yPad, pCons.getHeight().getValue());
        
        assertEquals(1, layout.getConstraints(container.getComponent(0)).getWidth().getValue());
        assertEquals(2, layout.getConstraints(container.getComponent(0)).getHeight().getValue());
        
        assertEquals(1, layout.getConstraints(container.getComponent(1)).getWidth().getValue());
        assertEquals(2, layout.getConstraints(container.getComponent(1)).getHeight().getValue());
        
        assertEquals(3, layout.getConstraints(container.getComponent(2)).getWidth().getValue());
        assertEquals(2, layout.getConstraints(container.getComponent(2)).getHeight().getValue());
        
        assertEquals(1, layout.getConstraints(container.getComponent(3)).getWidth().getValue());
        assertEquals(1, layout.getConstraints(container.getComponent(3)).getHeight().getValue());
        
        assertEquals(1, layout.getConstraints(container.getComponent(4)).getWidth().getValue());
        assertEquals(1, layout.getConstraints(container.getComponent(4)).getHeight().getValue());
        
        assertEquals(3, layout.getConstraints(container.getComponent(5)).getWidth().getValue());
        assertEquals(1, layout.getConstraints(container.getComponent(5)).getHeight().getValue());
	}
}
