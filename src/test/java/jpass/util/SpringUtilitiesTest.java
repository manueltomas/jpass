package jpass.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.awt.Button;
import java.awt.Panel;

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
        Button b2 = new Button("Button 2");
        Button b3 = new Button("Button 3");
        Button b4 = new Button("Button 4");
        Button b5 = new Button("Button 5");
		container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);
        container.add(b5);
		container.setLayout(new SpringLayout());
		SpringUtilities.makeGrid(container, 5, 1, 0, 0, 0, 0);
//		assertEquals(b1, container.getComponentAt(0, 0));
//        assertEquals(b2, container.getComponentAt(0, 1));
//        assertEquals(b3, container.getComponentAt(0, 2));
//        assertEquals(b4, container.getComponentAt(0, 3));
//        assertEquals(b5, container.getComponentAt(0, 4));
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
		container.add(new Button("Button 1"));
		container.add(new Button("Button 2"));
		container.add(new Button("Button 3"));
		container.add(new Button("Button 4"));
		container.add(new Button("Button 5"));
		container.setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(container, 5, 1, 0, 0, 0, 0);
	}
}
