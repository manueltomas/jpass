package jpass.util;

import static org.junit.Assert.assertThrows;

import java.awt.Button;
import java.awt.Panel;

import javax.swing.SpringLayout;

import org.junit.Test;

public class SpringUtilitiesTest {

	@Test
	public void shouldNotWorkEmptyContainer() {
		assertThrows(Exception.class, () -> {
			Panel container = new Panel();
			container.setLayout(new SpringLayout());
			SpringUtilities.makeGrid(container, 0, 0, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldNotWorkZeroAreaSize() {
		assertThrows(Exception.class, () -> {
			Panel container = new Panel();
			container.add(new Button("Button 1"));
			container.setLayout(new SpringLayout());
			SpringUtilities.makeGrid(container, 0, 0, 0, 0, 0, 0);
		});
	}
	
	@Test
	public void shouldWorkPositiveAreaSize() {
		Panel container = new Panel();
		container.add(new Button("Button 1"));
		container.setLayout(new SpringLayout());
		SpringUtilities.makeGrid(container, 1, 1, 0, 0, 0, 0);
	}
	
	@Test
	public void shouldNotPositiveAreaSizeGreaterThanComponents() {
		assertThrows(Exception.class, () -> {
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
	public void shouldWorkPositiveAreaSizeGreaterThanComponents() {
		Panel container = new Panel();
		container.add(new Button("Button 1"));
		container.add(new Button("Button 2"));
		container.add(new Button("Button 3"));
		container.add(new Button("Button 4"));
		container.add(new Button("Button 5"));
		container.setLayout(new SpringLayout());
		SpringUtilities.makeGrid(container, 5, 1, 0, 0, 0, 0);
	}
}
