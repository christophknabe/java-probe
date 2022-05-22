import java.applet.Applet;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Date;

public class ClockApplet extends Applet implements Runnable {

	private Calendar calendar = null;
	private Thread clock = null;

	public ClockApplet() {
		calendar = Calendar.getInstance( TimeZone.getTimeZone( "ECT" ));
	}

	public void start() {
		if ( clock == null ) {
			clock = new Thread( this );
			clock.start();
		}
	}

	public void run() {
		while ( clock !=  null ) {
			repaint();

			try {
				clock.sleep( 1000 );
			} catch ( InterruptedException e ) {}
		}
	}

	protected String setLeadingZero( int i ) {
		return ( i < 10 ) ? "0" + String.valueOf( i ): String.valueOf( i );
	}

	public void paint( Graphics g ) {
		calendar.setTime( new Date());

		g.drawString( "\r" + setLeadingZero( calendar.get( Calendar.HOUR_OF_DAY ))
				+ ":" + setLeadingZero( calendar.get( Calendar.MINUTE ))
				+ ":" + setLeadingZero( calendar.get( Calendar.SECOND )),
				20, 10 );
		System.out.flush();
	}

	public void stop() {
		clock.stop();
		clock = null;
	}
}
