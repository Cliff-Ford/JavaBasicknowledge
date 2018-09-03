import java.util.Calendar;

public class CalendarBean{
	int year = 2005, month = 0, nextDay;
	public void setYear(int year){
		this.year = year;
	}
	public void setMonth(int month){
		this.month = month;
	}
	public String[][] getCalendar(){
		String a[][] = new String[6][7];
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int day = 0;
		if(month == 1 || month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12){
			day = 31;
		}
		if(month == 4 || month == 6 || month == 9 || month == 11){
			day = 30;
		}
		if(month ==2){
			if(((year%4==0)&&(year % 100!=0))){
				day = 29;
			}
			else{
				day = 28;
			}
		}
		nextDay = 1;
		for(int k = 0; k < 6; k++){
			if(k==0){
				for(int j = weekday; j < 7; j++){
					a[k][j] = "" + nextDay;
					nextDay++;
				}
			}
			else{
				for(int j = 0; j < 7 && nextDay <= day; j++){
					a[k][j] = "" + nextDay;
					nextDay++;
				}
			}
		}
		return a;
	}
}