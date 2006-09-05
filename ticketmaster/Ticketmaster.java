import java.io.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


/**
 * 
 */
public class Ticketmaster implements PaintListener, KeyListener {
    Display display = new Display();
    Shell shell = new Shell(display);
    Canvas canvas = new Canvas(shell, SWT.NULL);
    String sep = File.separator;

    final Image ticket = new Image(display, "images"+sep+"ticket.gif");
    final Image event_empty = new Image(display, "images"+sep+"event-empty.gif");
    final Image event = new Image(display, "images"+sep+"event-large.gif");
    final Image event2 = new Image(display, "images"+sep+"event2-large.gif");

    String tic;
    boolean resetNum = false;

    public Ticketmaster() {
        shell.setText("Ticketmaster venue");
        shell.setLayout(new FillLayout());

        final Thread readerThread = new Thread() {
                public void run() {
                    while (true) {
                        tic = scanTicket();
                        shell.getDisplay().asyncExec(new Runnable(){
                                public void run() {
                                    canvas.redraw();
                                }
                            });
                    }
                }
            };
        readerThread.start();
        
        canvas.addPaintListener(this);
        canvas.addKeyListener(this);

        shell.setSize(640, 480);

        shell.open();
        //textUser.forceFocus();
        //captureControl(canvas, "canvas.bmp");

        // Set up the event loop.
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                // If no more entries in event queue
                display.sleep();
            }
        }

        display.dispose();
    }



    public void paintControl(PaintEvent e) {
        //System.out.println("PAINT");  

        Font initialFont = e.gc.getFont();
        FontData[] fontData = initialFont.getFontData();
        for (int i = 0; i < fontData.length; i++) {
            fontData[i].setHeight(16);
        }
        Font new16Font = new Font(display, fontData);

        fontData = initialFont.getFontData();
        for (int i = 0; i < fontData.length; i++) {
            fontData[i].setHeight(24);
        }
        Font new24Font = new Font(display, fontData);

        e.gc.setFont(new16Font);

        e.gc.drawImage(event_empty, 10, 10);

        if (tic != null) {
            if (System.currentTimeMillis() % 2 == 0)
                e.gc.drawImage(event, 10, 10);
            else
                e.gc.drawImage(event2, 10, 10);

            e.gc.drawImage(ticket, 35, 265);
            e.gc.drawString("Welcome to ticketmaster!", 330, 260);
            e.gc.drawString("Your ticket number is:", 330, 290);
            e.gc.setFont(new24Font);
            e.gc.drawString("" + tic, 360, 325);
            e.gc.setFont(new16Font);
            e.gc.drawString("Enjoy the show.", 330, 370);
        } else
            e.gc.drawString("<scan ticket>", 260, 340);
    }


    public void keyPressed(KeyEvent e) {
        String c = Character.toString(e.character);
        //System.out.println("got key: " + (int)e.character + " '" + c);

        if(!" ".equals(c) && "".equals(c.trim())) {
            resetNum = true;
            shell.getDisplay().asyncExec(new Runnable(){
                    public void run() {
                        canvas.redraw();
                    }
                });
        } else if(resetNum) {
            tic = c;
            resetNum = false;
        } else if (tic != null) {
            tic += c;
        } else {
            tic = c;
        }

        //System.out.println("tic: " + tic);  

    }

    public void keyReleased(KeyEvent e) { }


    public String scanTicket() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        while(input == null) {
            try {
                input = in.readLine();
            } catch (IOException ioe) {
            }
            System.out.println("got: " + input);  
        }
        return input;
    }

  /**
   * Captures the specified control and saves the result into a file in the BMP format.
   * @param control
   * @param fileName
   */
  public static void captureControl(Control control, String file) {
    GC gc = new GC(control);
    Image image = new Image(control.getDisplay(), control.getSize().x, control.getSize().y);
    gc.copyArea(image, 0, 0);
    ImageLoader loader = new ImageLoader();
    loader.data = new ImageData[] { image.getImageData() };
    loader.save(file, SWT.IMAGE_BMP);
    gc.dispose();
  }

  private void init() {  }

  public static void main(String[] args) {
    new Ticketmaster();
  }
}

