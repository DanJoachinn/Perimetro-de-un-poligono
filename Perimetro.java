import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Perimetro {
	private int numVertex;
	
	private float perimetro;
	
	private Puntos[] vertex;
	
	private JPanel myPanel;
	
	private JTextField xField,
	                   yField;
	
	public Perimetro() {

		xField = new JTextField(5);
	    yField = new JTextField(5);

	      myPanel = new JPanel();
	      myPanel.add(new JLabel("x:"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15));
	      myPanel.add(new JLabel("y:"));
	      myPanel.add(yField);
	      
		try {
			this.numVertex=Integer.parseInt(JOptionPane.showInputDialog("Numero de vertices: "));
			this.vertex=new Puntos[this.numVertex];
			for(int i=0;i<this.numVertex;i++){
				this.vertex[i]=new Puntos();
			}
			this.pedirPuntos();
			this.perimetro=this.distanciaEntrePuntos();
			JOptionPane.showMessageDialog(null, "El perimetro de la figura es: "+this.perimetro);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Input invalido, intente otra vez.");
		}
		 
	}
	
	public void pedirPuntos() {

		for(int i=0;i<this.numVertex;i++) {
			JOptionPane.showConfirmDialog(null, myPanel, "Introduza X"+(i+1)+" y Y"+(i+1)+" del vertice "+(i+1), JOptionPane.OK_CANCEL_OPTION);
			float y = Float.parseFloat(yField.getText());
			float x = Float.parseFloat(xField.getText());
			this.vertex[i].setXY(x,y);
			this.xField.setText("");
			this.yField.setText("");
		}
		
	}
	
	public float distanciaEntrePuntos() {
		
		float perimetro=0;
		
		for(int i=0;i<this.vertex.length;i++) {
			perimetro+=Math.sqrt(Math.pow((this.vertex[(i+1)%this.numVertex].getX()-this.vertex[(i)%this.numVertex].getX()),2)+(Math.pow(this.vertex[(i+1)%this.numVertex].getY()-this.vertex[(i)%this.numVertex].getY(), 2)));
		}
		
		return perimetro;
	}
	
	public static void main(String args0[]) {
		Perimetro pm=new Perimetro();
	}
}
