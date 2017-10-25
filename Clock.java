package a2;

/**
 *
 * Clock.java */


public class Clock {

     
		private int hours;
		private int minutes;
		private int seconds;
        /** Constructs a clock with the given hours, minutes and seconds.  If the clock is
         *  not valid, the entire program will halt with an error message.
         *  @param hours is an hour, numbered in the range 0...23.
         *  @param minutes is between 1 and 60.
         *  @param seconds is between 1 and 60
         */
        public Clock(int hours, int minutes, int seconds) {
        	if (Clock.isValidClock(hours, minutes, seconds)){
        		this.hours = hours;
        		this.minutes = minutes;
        		this.seconds = seconds;
        	}else{
        		System.out.println("INVALID");
        		System.exit(0);
        	}
        }

        /** Constructs a Clock object corresponding to the given string.
         *  @param s should be a string of the form "hours:minutes:seconds" where hours, minutes and seconds must
         *  be one or two digits. If s does not match these requirements or is not
         *  a valid clock, the program halts with an error message.
         */
        public Clock(String s) {
        	int hoursTemp;
        	int minutesTemp;
        	int secondsTemp;
        	String[] parts = s.split(":");
            hoursTemp = Integer.parseInt(parts[0]);
            minutesTemp = Integer.parseInt(parts[1]);
            secondsTemp = Integer.parseInt(parts[2]);
            	if(Clock.isValidClock(hours, minutes, seconds)){
            		this.hours = hoursTemp;
            		this.minutes = minutesTemp;
            		this.seconds = secondsTemp;
            	}else{
        		System.out.println("INVALID");
        		System.exit(0);
        	}
        }


        /** Return the time elapsed between the two clocks in seconds.
         *  @param firstClock- a clock object
         *  @param secondClock - a clock object
         *  @return true if and only if the input hours is in the morning.
         */
        public static int timeElapsed(Clock firstClock, Clock secondClock) {
        	int time;
        	int hoursElapsed;
        	int minutesElapsed;
        	int secondsElapsed;
        	if (firstClock == secondClock){
        		time =0;
        	}else{
        		hoursElapsed= firstClock.hours - secondClock.hours;
        		minutesElapsed = firstClock.minutes- secondClock.minutes;
        		secondsElapsed = firstClock.seconds - firstClock.seconds;
        		time = secondsElapsed + (minutesElapsed*60)+ (hoursElapsed*3600);
        	}
            return time;                        
        }

        /** Returns the time i day for this clock.
         *  @return String (AM or PM).
         */
        public String timeInDay() {
        	String time = "AM";
        	if (hours<=12){
        		time ="PM";
        	}
            return time;
        }

        /** Checks whether the given clock is valid.
         * @param hours - time in hours 
         * @param minutes - time in minutes
         * @param seconds - time in seconds
         *  @return true if and only if "hours:minutes:seconds" constitute a valid clock.
         *
         */
        public static boolean isValidClock(int hours, int minutes, int seconds) {
        	boolean isValid = false;
        	if ((hours>=1)|| (hours<=23) || (minutes>=0) || (minutes <=60)|| (seconds >=0)|| (seconds<=60)){
        		isValid = true;
        	}
            return isValid;                        
        }

        /** Returns a string representation of this clock in the form hours:minutes:seconds.
         *  The hours, minutes, and seconds are expressed in full as integers; for example,
         *  12:7:20 or 3:21:40.
         *  @return a String representation of this clock.
         */
        public String toString() {
        	String stringTime;
        	stringTime = String.valueOf(this.hours)+":"+ String.valueOf(this.minutes)+":"+ String.valueOf(this.seconds);
            return stringTime;                     
        }


        /** Returns true if this clock is equal to otherClock
         * @param otherClock- a clock object
         *  @return equals - true if equal.
         */
        public boolean equals(Clock otherClock){
        boolean equals = false;
        if ((otherClock.hours== this.hours)&&(otherClock.minutes == this.minutes)&&(otherClock.seconds ==this.seconds)){
        	equals = true;
        	}
        return equals;
        }
        
        /** Determines whether this Clock is before the Clock d.
         * 	@param d- a clock object
         *  @return true if and only if this Clock is before d.
         */
        public boolean isBefore(Clock d) {
        	boolean before = false;
        	if(d.hours > this.hours){
        		before = true;
        	}else if (d.minutes> this.minutes){
        		before = true;
        	
        	}else if (d.seconds> this.seconds){
        		before = true;
        	}
            return before;                        
        }


        /** Determines whether this Clock is after the Clock d.
         *  @return true if and only if this Clock is after d.
         *  @param d - a clock object
         */
        public boolean isAfter(Clock d) {
        	boolean after = false;
        	if(d.hours < this.hours){
        		after = true;
        	}else if (d.minutes< this.minutes){
        		after = true;
        	}else if (d.seconds< this.seconds){
        		after = true;
        	}
            return after;
        }

        /** Returns the number of  Seconds in this Clock.
         *  @return a number seconds
         */
        public int secInClock() {
            return this.seconds;                           
        }

        /** Convert the clock to the format for this clock to hours:minutes:seconds XX.  Where the hours will be a number between 1.. 12
         * and XX will be either "AM" or "PM" For example,
         *  if this Clock is 16:15:20 , the returned string will be 4:15:20 PM. and
         *  if this Clock is 00:15:20 , the returned string will be 12:15:20 AM.
         *  @return the string representation of the Clock.
         */
        public String convertClock() {
        	String converted="";
        	int temp=0;
        	if(this.hours <12){
        		converted = converted + String.valueOf(this.hours) + String.valueOf(this.minutes) + String.valueOf(this.seconds)+"AM";
        	}else if (this.hours ==12){
        		converted = converted + String.valueOf(this.hours)+ String.valueOf(this.minutes) + String.valueOf(this.seconds) +"PM";
        	}else{
        		temp = this.hours -12;
        		converted = converted +temp+ String.valueOf(this.minutes) + String.valueOf(this.seconds) +"PM";
        	}
        	
            return converted;                           
        }
        /**Sorts an array of clocks in place, using insertion sorting. 
         * Used public because the method needs to be accessed from outside, void because the method does not return something
         * @author Brian Hane
         * @param s - an array of clocks
         * 
         */
        public  void inPlaceInsertionSort(Clock [] s){
        	int x;
        	int i;
        	Clock temp= new Clock(0,0,0);
            	
        	for(x=1;x<s.length;x++){
        		temp = s[x];
        		for (i=x-1;(i>=0)&&(s[i].isAfter(temp));i--){
        			s[i+1]= s[i];
        		}
        		s[i+1]=temp;
        	}
        }
        /**Tests constructors, timeElapsed, secInClock, equals, isAfter, isBefore, selection sort, convertClock, and timeInDay
         * 
         * 
         */
        public static void main(String[] argv) {
            System.out.println("\nTesting constructors.");

            Clock c1 = new Clock(1, 1, 1);
            System.out.println("Clock should be 1:1:1 " + c1);

            c1 = new Clock("21:4:2");
            System.out.println("Clock should be 21:4:2 " + c1);

            Clock c2 = new Clock("1:50:19");
            System.out.println("Clock should be 1:1:19 " + c2);
            Clock c3 = new Clock("1:50:26");
            System.out.println("Clock should be 1:59:6: " + c3);

            Clock c4 = new Clock("23:27:19");
            Clock c5 = new Clock("12:31:21");
            Clock c6 = new Clock ("23:27:19");

            System.out.println("\nTesting time elapsed");
            System.out.println(c4 +" "+ String.valueOf(timeElapsed(c4, c5))+" seconds after "+c5);
            
            System.out.println("\nTesting secInClock");
            System.out.println(c5 +" has seconds: "+ String.valueOf(c5.secInClock()));
            
            System.out.println("\nTesting equals");
            System.out.println(c4 +" = "+ c5 + " " +(c4.equals(c5)));
            System.out.println(c4 +" = "+ c6 + " " +(c4.equals(c6)));
            System.out.println("\nTesting before and after.");
            System.out.println(c2 + " after " + c1 + " should be false: " +
                    c2.isAfter(c1));
            
            System.out.println(c3 + " after " + c2 + " should be true: " +
                    c3.isAfter(c2));
            System.out.println(c1 + " after " + c1 + " should be false: " +
                    c1.isAfter(c1));
            System.out.println(c1 + " after " + c2 + " should be true: " +
                    c1.isAfter(c2));
            System.out.println(c2 + " after " + c3 + " should be false: " +
                    c2.isAfter(c3));
			
            System.out.println(c1 + " before " + c2 + " should be false: " +
                    c1.isBefore(c2));
            System.out.println(c2 + " before " + c3 + " should be true: " +
                    c2.isBefore(c3));
            System.out.println(c1 + " before " + c1 + " should be false: " +
                    c1.isBefore(c1));
            System.out.println(c2 + " before " + c1 + " should be true: " +
                    c2.isBefore(c1));
            System.out.println(c3 + " before " + c2 + " should be false: " +
                    c3.isBefore(c2));

            System.out.println("\nTesting convertClock.");
            System.out.println(c4.convertClock() + " should be : " + "12:27:19 AM");
            System.out.println(c5.convertClock() + " - " + c1  + " should be : " + "12:31:21 PM");

            System.out.println("\nTesting timeInDay.");
            
            
            System.out.println(c4.timeInDay() + " should be : " + "AM");
            System.out.println(c5.timeInDay() + " should be : " + "PM");

            Clock [] s = new Clock []{c1,c2,c3,c4};
            
            System.out.println("\nTesting selection sort");
            for (Clock t: s){
            	System.out.println(t);
            }
            
            c1.inPlaceInsertionSort(s);
            System.out.println("SORTED");
            for (Clock t: s){
            	System.out.println(t);
            }
        }
    }