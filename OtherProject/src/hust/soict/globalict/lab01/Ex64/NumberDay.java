package hust.soict.globalict.lab01.Ex64;
import java.util.Scanner;

public class NumberDay {
	public static int inputmonth (String mo) {
		int m = 0;
		if (mo.equals("1") || mo.equals("Jan") || mo.equals("Jan.") || mo.equals("January") ) {
			m = 1;}
		else if (mo.equals("2") || mo.equals("Feb") || mo.equals("Feb.") || mo.equals("February") ) {
			m = 2;}
		else if (mo.equals("3") || mo.equals("Mar") || mo.equals("Mar.") || mo.equals("March") ) {
			m = 3;}
		else if (mo.equals("4") || mo.equals("Apr") || mo.equals("Apr.") || mo.equals("April") ) {
			m = 4;}
		else if (mo.equals("5") || mo.equals("May")) {
			m = 5;}
		else if (mo.equals("6") || mo.equals("Jun") || mo.equals( "June") ) {
			m = 6;}
		else if (mo.equals("7") || mo.equals("Jul") || mo.equals("July") ) {
			m = 7;}
		else if (mo.equals("8") || mo.equals("Aug") || mo.equals("Aug.") || mo.equals("August") ) {
			m = 8;}
		else if (mo.equals("9") || mo.equals("Sep") || mo.equals("Sept.") || mo.equals("September") ) {
			m = 9;}
		else if (mo.equals("10") || mo.equals("Oct") || mo.equals("Oct.") || mo.equals("October") ) {
			m = 10;}
		else if (mo.equals("11") || mo.equals("Nov") || mo.equals("Nov.") || mo.equals("November") ) {
			m = 11;}
		else if (mo.equals("12") || mo.equals("Dec") || mo.equals("Dec.") || mo.equals("December") ) {
			m = 12;}
		return m;
		
	}
	
	public static int result(int m) { // result for common year
		int n  = 0;
		switch(m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			n = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			n = 30;
			break;
		case 2:
			n = 28;
			break;
		}
		return n;
	}
public static int resultl(int m) { // result for leap year
		int n = 0;
		switch(m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			n = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			n = 30;
			break;
		case 2:
			n = 29;
			break;
		}
		return n;
	}
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		
		int mn = 0,yr;
		
		String mo;
		
		System.out.println("Input month: ");
		mo = keyb.nextLine();
		mn = inputmonth(mo);
		
		while (mn == 0) { //check input month
			System.out.println("Wong input!\nPlease re-input month: ");
			mo = keyb.nextLine();
			mn = inputmonth(mo);
		}
		
		System.out.println("Input year: ");
		yr = keyb.nextInt();

		while(yr < 0) {
			System.out.println("Wong input!\nPlease re-input year: ");
			yr = keyb.nextInt();
		}
		if ((yr % 4) != 0) {
			System.out.println("The number of days in " + mn + "/" + yr + " : " + result(mn) +" days\n");
		}else { 
			if((yr % 400) == 0) {
				System.out.println("The number of days in " + mn + "/" + yr + " : " + resultl(mn) +" days\n");
			}else if ((yr % 100) == 0) {
				System.out.println("The number of days in " + mn + "/" + yr + " : " + result(mn) +" days\n");	
			}else {
				System.out.println("The number of days in " + mn + "/" + yr + " : " + resultl(mn) +" days\n");
			}
		}
			
	}
		
}
	
	

