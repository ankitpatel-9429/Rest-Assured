package APITesing;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import Util.TestUtil;

public class DataForTest {
	
	@DataProvider(name = "dataForPost")
	public Object[][] dataForPost() {

//		Object[][] obj = new Object[2][3];
//
//		obj[0][0] = "Harry";
//		obj[0][1] = "Green";
//		obj[0][2] = 2;
//
//		obj[1][0] = "Thomas";
//		obj[1][1] = "Green";
//		obj[1][2] = 1;
//
//		return obj;
		
		return new Object[][] {
			{"Harry1","green1",2},
			{"Thomas1","green1",1}
		};

	}
	
	@DataProvider(name = "dataForPost1")
	public Object[][] dataForPost1() throws InvalidFormatException {

		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;

	}
	
	
	@DataProvider(name = "dataForDelete")
	
	public Object[] dataForDelete() {
		
		return new Object[] {
				4,5
		};
	}

}
