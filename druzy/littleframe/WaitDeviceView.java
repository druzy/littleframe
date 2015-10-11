package druzy.littleframe;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import druzy.mvc.AbstractView;
import druzy.mvc.Controller;


public class WaitDeviceView extends AbstractView {

	private JFrame waitFrame=null;
	private JLabel gif=null;
	private JLabel text=null;
	private GridBagLayout layout=null;
	
	public WaitDeviceView(Controller controller) {
		super(controller);
		
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						e.printStackTrace();
					}
					
					layout=new GridBagLayout();
					
					waitFrame=new JFrame();
					waitFrame.setLayout(layout);
					waitFrame.setUndecorated(true);
				
					gif=new JLabel(WaitDeviceModel.WAIT_GIF);
					
					text=new JLabel("Recherche de l'appareil en cours");
					
					//ajout des éléments les uns les autres
					GridBagConstraints c=new GridBagConstraints();
					c.gridx=0;
					c.gridy=0;
					waitFrame.add(gif, c);
					
					c.gridx++;
					c.anchor=GridBagConstraints.CENTER;
					waitFrame.add(text, c);
					c.anchor=GridBagConstraints.LINE_START;
					
					waitFrame.pack();
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTop() {

	}

	@Override
	public void propertyChange(PropertyChangeEvent pce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display() {
		waitFrame.setVisible(true);

	}

	@Override
	public boolean isDisplaying() {
		return waitFrame.isVisible();
	}

	@Override
	public void close() {
		waitFrame.setVisible(false);
		waitFrame.dispose();

	}

}
