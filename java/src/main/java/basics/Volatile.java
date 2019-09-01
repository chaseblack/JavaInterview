package basics;//variable visibility problem among threads
//all writes to the volatile variable will be written back to main memory immediately.
// Also, all reads of the volatile variable will be read directly from main memory.
/**
 * http://tutorials.jenkov.com/java-concurrency/volatile.html
 * */
public class Volatile {

    class Date{
        private int years;
        private int months;
        private volatile int days;

        //writing volatile
        public void update(int years, int months, int days){
            this.years=years;
            this.months=months;
            this.days=days;
        }

        //reading volatile
        public int totalDays(){
            int total=days;
            total+=months*30;
            total+=years*365;
            return total;
        }
    }
}
