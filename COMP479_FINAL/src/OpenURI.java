import java.net.URI;
import java.awt.Desktop;

public class OpenURI {


	public static void showURL(String input)
	{
		
        if( !Desktop.isDesktopSupported() ) {

            System.err.println( "Desktop is not supported (fatal)" );
            System.exit( 1 );
        }

        if ( input.length() == 0 ) {

            System.out.println( "Usage: OpenURI [URI [URI ... ]]" );
            System.exit( 0 );
        }

        Desktop desktop = Desktop.getDesktop();

        if( !desktop.isSupported( Desktop.Action.BROWSE ) ) {

            System.err.println( "Desktop doesn't support the browse action (fatal)" );
            System.exit( 1 );
        }

        try {

        	URI uri = new URI( input );
            desktop.browse( uri );
        }
        catch ( Exception e ) {

            System.err.println( e.getMessage() );
        }
        
	}
}