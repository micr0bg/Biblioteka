package GUI.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Infos extends JDialog
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Launch the application.
	 * @param args 
	 */
	public static void main(String[] args)
	{
		try
		{
			Infos dialog = new Infos();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public Infos()
	{
		setBounds(100, 100, 450, 184);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ClimaCom \u0411\u0438\u0431\u043B\u0438\u043E\u0442\u0435\u043A\u0430");
			lblNewLabel.setBounds(21, 10, 391, 41);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u041D\u0430\u043B\u0438\u0447\u043D\u0438 \u043C\u043E\u0434\u0435\u043B\u0438: 723");
			lblNewLabel_1.setBounds(14, 56, 195, 21);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u0412\u0435\u0440\u0441\u0438\u044F: 0,1");
			lblNewLabel_2.setBounds(286, 56, 138, 21);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Credit: Micr0World");
			lblNewLabel_3.setBounds(138, 80, 155, 21);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
			contentPanel.add(lblNewLabel_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
}
