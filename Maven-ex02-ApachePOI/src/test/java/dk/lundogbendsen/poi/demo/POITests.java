package dk.lundogbendsen.poi.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import dk.lundogbendsen.poi.demo.ApachePOIExcelWrite;


public class POITests {

	@Test
	public void writeFile() {		
		ApachePOIExcelWrite.main(new String[0]);
		File file = new File("./MyFirstExcel.xlsx");
		assertTrue(file.exists());
	}

}
