package com.micr0.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import com.micr0.util.Database;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

/**
 * @author Micr0 (iliq zlatanov)
 */
public class AddCategory extends JDialog
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JFormattedTextField catsname;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			AddCategory dialog = new AddCategory();
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
	public AddCategory()
	{
		setBounds(100, 100, 284, 132);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			catsname = new JFormattedTextField();
			catsname.setBounds(108, 18, 150, 20);
			contentPanel.add(catsname);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u0418\u043C\u0435 \u043D\u0430 \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u044F:");
			lblNewLabel_1.setToolTipText("\u041F\u0440\u0438\u043C\u0435\u0440: \u0421\u0445\u0435\u043C\u0438");
			lblNewLabel_1.setBounds(10, 21, 101, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Добре");
				okButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							Connection conn = Database.getConnection();
							PreparedStatement pst1 = conn.prepareStatement("select max(catid)+1 from category");
							ResultSet rs = pst1.executeQuery();
							String cat_id = "";
							while (rs.next())
							{
								cat_id = rs.getString(1);
							}
							// the mysql insert statement
							String query = " insert into category (catid, catname)" + " values (?, ?)";
							
							// create the mysql insert preparedstatement
							PreparedStatement preparedStmt = conn.prepareStatement(query);
							preparedStmt.setString(1, cat_id.toString());
							preparedStmt.setString(2, catsname.getText());
							
							// execute the preparedstatement
							preparedStmt.execute();
							
							conn.close();
						}
						catch (Exception ex)
						{
							JOptionPane.showConfirmDialog(null, "Голема Грешка:" + ex.getMessage() + " ", "Грешка", JOptionPane.ERROR_MESSAGE, 1);
						}
						Object[] options =
						{
							"Добре"
						};
						int input = JOptionPane.showOptionDialog(null, "Успешно добавена Категоря.", "Успех", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
						if (input == JOptionPane.YES_OPTION)
						{
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Отказ");
				cancelButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
}
