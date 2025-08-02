package automationexercise.dataprovider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import automationexercise.utility.ExcelLibrary;



public class DataProviders {

	ExcelLibrary obj = new ExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "logincredentials")
		public Object[][] getLoginCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet1"); // SP Changed
			// Total Columns
			int column = obj.getColumnCount("Sheet1"); // SP Changed
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet1", j, i + 2);
//					System.out.println("Data="+data[i][j].toString());
				}
			}
			return data;
		}

	//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		@DataProvider(name = "signUpCredentials")
		public Object[][] getsignUpCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet2");
			// Total Columns
			int column = obj.getColumnCount("Sheet2");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet2", j, i + 2);
				}
			}
			return data;
		}

		
		
		@DataProvider(name = "signUpPageCredentials")
		public Object[][] getsignUpPageCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet3");
			// Total Columns
			int column = obj.getColumnCount("Sheet3");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet3", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		
		@DataProvider(name = "loginDetails")
		public Object[][] getloginDetails() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet4");
			// Total Columns
			int column = obj.getColumnCount("Sheet4");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet4", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		
		@DataProvider(name = "contactusform")
		public Object[][] contactus() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet5");
			// Total Columns
			int column = obj.getColumnCount("Sheet5");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet5", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
	
		@DataProvider(name = "prodName")
		public Object[][] prodname() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet6");
			// Total Columns
			int column = obj.getColumnCount("Sheet6");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet6", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		@DataProvider(name = "subscriptionEmail")
		public Object[][] subscriptionemail() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet7");
			// Total Columns
			int column = obj.getColumnCount("Sheet7");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet7", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		@DataProvider(name = "firstRow")
		public Object[][] firstrow() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet8");
			// Total Columns
			int column = obj.getColumnCount("Sheet8");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet8", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		@DataProvider(name = "placeOrder")
		public Object[][] placeorder() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet9");
			// Total Columns
			int column = obj.getColumnCount("Sheet9");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet9", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		@DataProvider(name = "placeOrderBeforeLogin")
		public Object[][] placeorderbeforelogin() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet10");
			// Total Columns
			int column = obj.getColumnCount("Sheet10");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet10", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		@DataProvider(name = "searchProduct")
		public Object[][] search() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet11");
			// Total Columns
			int column = obj.getColumnCount("Sheet11");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet11", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		@DataProvider(name = "writeReview")
		public Object[][] writereview() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet12");
			// Total Columns
			int column = obj.getColumnCount("Sheet12");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet12", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
		
		@DataProvider(name = "downloadInvoice")
		public Object[][] invoice() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet13");
			// Total Columns
			int column = obj.getColumnCount("Sheet13");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet13", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
}
