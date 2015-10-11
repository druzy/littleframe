package druzy.littleframe;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import druzy.mvc.AbstractView;
import druzy.mvc.Controller;


public class AskFilesView extends AbstractView {

	private JFileChooser chooser=null;
	private int buttonClicked=0;
	
	public AskFilesView(Controller controller) {
		super(controller);
		
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					chooser=new JFileChooser();
					chooser.setFileFilter(getController().getModel().getFilter());
					chooser.setMultiSelectionEnabled(true);
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
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					buttonClicked=chooser.showOpenDialog(null);
					if (buttonClicked==JFileChooser.APPROVE_OPTION){
						Thread t=new Thread(){
							public void run(){
								getController().notifyAction(AskFilesView.this, chooser.getSelectedFiles(), AskFilesModel.APPROVE);
							}
						};
						t.start();
						try {
							t.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean isDisplaying() {
		return chooser.isVisible();
	}

	@Override
	public void close() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				chooser.setVisible(true);
			}
		});
	}

	@Override
	public AskFiles getController(){return (AskFiles)super.getController();}
}
