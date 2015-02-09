package bdf;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class BDf_View extends Frame implements ActionListener,WindowListener{
	public BDf_View(){
		addWindowListener(this);
		setTitle("îÑè„çÇ");
		int month,sale;
		ResultSet rs;
		TextArea text =new TextArea("",10,10,TextArea.SCROLLBARS_NONE);
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		MySQLf mysql=new MySQLf();
		rs = mysql.selectAll();
			try {
				while(rs.next()){
					month = rs.getInt("month");
					sale = rs.getInt("sale");
					text.append(month+"åéÅF"+sale+"ñú\n");
					data.addValue(sale,"2014",month+"");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JFreeChart chart = 
					ChartFactory.createLineChart("sales","month","ten thousand",
	                                   data,PlotOrientation.VERTICAL,true,false,false);

			ChartPanel cpanel = new ChartPanel(chart);
			add(text,BorderLayout.WEST);
			add(cpanel,BorderLayout.CENTER);
		}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
				
	}
}