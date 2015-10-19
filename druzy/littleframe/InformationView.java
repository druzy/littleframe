package druzy.littleframe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import druzy.mvc.AbstractView;
import druzy.mvc.Controller;

public class InformationView extends AbstractView {

	private GridBagLayout layout=null;
	private JFrame informationFrame=null;
	private JLabel infoLabel=null;
	private JButton ok=null;
	
	public InformationView(Controller controller) {
		super(controller);
		
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					layout=new GridBagLayout();
					
					informationFrame=new JFrame();
					informationFrame.setLayout(layout);
					
					infoLabel=new JLabel(getController().getModel().getInformation());
					
					ok=new JButton("OK");
					
					//ajout des composant les uns les autres
					GridBagConstraints c=new GridBagConstraints();
					c.gridx=0;
					c.gridy=0;
					informationFrame.add(infoLabel,c);
					
					c.gridy++;
					informationFrame.add(ok,c);
					
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
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent pce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				informationFrame.setVisible(true);
			}
		});

	}

	@Override
	public boolean isDisplaying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				informationFrame.setVisible(false);
				informationFrame.dispose();
			}
		});
	}

	@Override
	public Information getController(){return (Information)super.getController();}
}
