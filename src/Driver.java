import view.Program;
import javax.swing.*;

public class Driver
{
    public static void main(String[] args)
    {
        Runnable application = new Runnable()
        {
            public void run()
            {
                Program p = new Program();
            }
        };

        SwingUtilities.invokeLater(application);
    }
}