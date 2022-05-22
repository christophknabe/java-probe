//Klassenimporte aus dem paket java.util:
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Date;

public class Clock extends Thread {

	private Calendar calendar = null;

	public static void main( String arg[] ) {
		Clock clock = new Clock();
		clock.start();
	}

	public Clock() {
		calendar = Calendar.getInstance( TimeZone.getTimeZone( "ECT" ));
	}

	public void run() {
		for(;;){
			repaint();

			try {
				sleep( 1000 );
			}
			catch ( InterruptedException e ) {
		       System.out.print("\rInterrupted");
		       System.out.flush();
            }
		}
	}

	protected String setLeadingZero( int i ) {
		return ( i < 10 ) ? "0" + String.valueOf( i ): String.valueOf( i );
	}

	public void repaint() {
		calendar.setTime( new Date());

		System.out.print( "\r" + setLeadingZero( calendar.get( Calendar.HOUR_OF_DAY ))
				+ ":" + setLeadingZero( calendar.get( Calendar.MINUTE ))
				+ ":" + setLeadingZero( calendar.get( Calendar.SECOND )));
		System.out.flush();
	}
}
