package org.hrd.gui.maimform;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderDemo extends JFrame implements ChangeListener{

	private JSlider vSlilder,hSlider;
	private JSpinner spinner;
	private JPanel controlPanel;
	private JLabel vSliderValue,hSliderValue,spinnerValue;
	
	public JSliderDemo() {
		init();
		counstructLayout();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		this.vSlilder=new JSlider(JSlider.VERTICAL,0,100,10);
		this.hSlider=new JSlider();
		
		this.spinner=new JSpinner();
		
		
		vSliderValue=new JLabel();
		hSliderValue=new JLabel();
		
		this.spinnerValue=new JLabel();
		
	}
	
	private void counstructLayout() {
		this.controlPanel=new JPanel();
		
		
		this.controlPanel.add(this.vSlilder);
		this.controlPanel.add(vSliderValue);
		this.controlPanel.add(hSlider);
		this.controlPanel.add(hSliderValue);
		
		this.controlPanel.add(this.spinner);
		this.controlPanel.add(spinnerValue);
		
		add(this.controlPanel,BorderLayout.CENTER);
		
		//add event
		this.vSlilder.addChangeListener(this);
		this.hSlider.addChangeListener(this);
		this.spinner.addChangeListener(this);
		
	}

	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==this.vSlilder) {
			//get Value from slider
			vSliderValue.setText(this.vSlilder.getValue()+"");
			this.hSlider.setValue(this.vSlilder.getValue());
			
		}else if(e.getSource()==this.hSlider) {
			hSliderValue.setText(this.hSlider.getValue()+"");
			
		}else if(e.getSource()==spinner) {
			spinnerValue.setText(spinner.getValue()+"");
		}
	}
	
}
