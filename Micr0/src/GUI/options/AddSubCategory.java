package GUI.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import GUI.Util.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddSubCategory extends JDialog
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
			AddSubCategory dialog = new AddSubCategory();
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
	public AddSubCategory()
	{
		setTitle("\u0414\u043E\u0431\u0430\u0432\u0438");
		setBounds(100, 100, 503, 243);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0421\u0443\u0431 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u044F ID:");
		lblNewLabel.setToolTipText("\u0421\u0443\u0431 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u044F ID \u0435 \u043F\u0440\u043E\u0441\u0442\u043E \u043D\u043E\u043C\u0435\u0440 \u043D\u0430 \u0440\u0430\u043A\u043E\u0432\u043E\u0434\u0441\u0442\u0432\u043E\u0442\u043E \u0432\u044A\u0432 \u0431\u0430\u0437\u0430\u0442\u0434\u0430\u043D\u043D\u0438 \u0442\u043E \u043D\u0435 \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0441\u0435 \u043F\u0440\u0438\u043F\u043E\u043A\u0440\u0438\u0432\u0430 \u0441\u044A\u0441 \u0434\u0440\u0443\u0433\u043E\u0442\u043E \u0430\u043A\u043E \u0435 \u0434\u043E\u0431\u0430\u0432\u0435\u043D\u043E \u043F\u0440\u0438\u043C\u0435\u0440 755 \u0441\u043B\u0435\u0434\u0432\u0430\u0449\u043E\u0442\u043E \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0435 756");
		lblNewLabel.setBounds(10, 43, 103, 14);
		contentPanel.add(lblNewLabel);
		
		JFormattedTextField subcatid = new JFormattedTextField();
		subcatid.setToolTipText("\u0421\u0443\u0431 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u044F ID \u0435 \u043F\u0440\u043E\u0441\u0442\u043E \u043D\u043E\u043C\u0435\u0440 \u043D\u0430 \u0440\u0430\u043A\u043E\u0432\u043E\u0434\u0441\u0442\u0432\u043E\u0442\u043E \u0432\u044A\u0432 \u0431\u0430\u0437\u0430\u0442\u0434\u0430\u043D\u043D\u0438 \u0442\u043E \u043D\u0435 \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0441\u0435 \u043F\u0440\u0438\u043F\u043E\u043A\u0440\u0438\u0432\u0430 \u0441\u044A\u0441 \u0434\u0440\u0443\u0433\u043E\u0442\u043E \u0430\u043A\u043E \u0435 \u0434\u043E\u0431\u0430\u0432\u0435\u043D\u043E \u043F\u0440\u0438\u043C\u0435\u0440 755 \u0441\u043B\u0435\u0434\u0432\u0430\u0449\u043E\u0442\u043E \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0435 756");
		subcatid.setBounds(103, 40, 66, 20);
		contentPanel.add(subcatid);
		
		JLabel lblNewLabel_1 = new JLabel("\u041A\u0430\u0442\u0435\u0433\u043E\u0440\u044F ID:");
		lblNewLabel_1.setToolTipText("\u041C\u043E\u0433\u0430\u0442 \u0434\u0430 \u0441\u0435 \u0434\u043E\u0431\u0430\u0432\u044F\u0442 \u043D\u043E\u0432\u0438 \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u0438 \u043E\u0442 \u0414\u043E\u0431\u0430\u0432\u0438 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044F \u0432\u044A\u0432 \u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u0430\u043D\u0435/\u0414\u043E\u0431\u0430\u0432\u0438 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044F");
		lblNewLabel_1.setBounds(10, 68, 77, 14);
		contentPanel.add(lblNewLabel_1);
		
		JFormattedTextField subid = new JFormattedTextField();
		subid.setToolTipText("\u041C\u043E\u0433\u0430\u0442 \u0434\u0430 \u0441\u0435 \u0434\u043E\u0431\u0430\u0432\u044F\u0442 \u043D\u043E\u0432\u0438 \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u0438 \u043E\u0442 \u0414\u043E\u0431\u0430\u0432\u0438 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044F \u0432\u044A\u0432 \u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u0430\u043D\u0435/\u0414\u043E\u0431\u0430\u0432\u0438 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044F");
		subid.setBounds(103, 65, 66, 20);
		contentPanel.add(subid);
		
		JLabel lblNewLabel_2 = new JLabel("\u041C\u043E\u0434\u0435\u043B:");
		lblNewLabel_2.setBounds(10, 93, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JFormattedTextField model = new JFormattedTextField();
		model.setBounds(66, 93, 103, 20);
		contentPanel.add(model);
		
		JLabel lblNewLabel_3 = new JLabel("\u0418\u043C\u0435 \u043D\u0430 \u0424\u0430\u0439\u043B:");
		lblNewLabel_3.setToolTipText("\u0412 \u0438\u043C\u0435\u0442\u043E \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043D\u0435 \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0441\u0430\u0434\u044A\u0440\u0436\u0430 \u0432\u0438\u0434\u044A\u0442 \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043F\u0440\u0438\u043C\u0435\u0440\u043D\u043E .pdf .exe .png \u0438 \u0442\u0435\u043C \u043F\u043E\u0434\u043E\u0431\u043D\u043E :)");
		lblNewLabel_3.setBounds(10, 128, 87, 14);
		contentPanel.add(lblNewLabel_3);
		
		JFormattedTextField ime = new JFormattedTextField();
		ime.setToolTipText("\u0412 \u0438\u043C\u0435\u0442\u043E \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043D\u0435 \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0441\u0430\u0434\u044A\u0440\u0436\u0430 \u0432\u0438\u0434\u044A\u0442 \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043F\u0440\u0438\u043C\u0435\u0440\u043D\u043E .pdf .exe .png \u0438 \u0442\u0435\u043C \u043F\u043E\u0434\u043E\u0431\u043D\u043E :)");
		ime.setBounds(96, 124, 200, 20);
		contentPanel.add(ime);
		
		JLabel lblNewLabel_4 = new JLabel("\u041F\u0440\u0438\u043C\u0435\u0440: ID 1=\u0420\u0430\u043A\u043E\u0432\u043E\u0434\u0441\u0442\u0432\u043E");
		lblNewLabel_4.setToolTipText("");
		lblNewLabel_4.setBounds(160, 68, 254, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u041F\u0440\u0438\u043C\u0435\u0440; ID 733,734,735,737. \u0438 \u0442\u0430\u043A\u0430 \u043F\u0440\u0438 \u0432\u0441\u044F\u043A\u043E \u043D\u043E\u0432\u043E");
		lblNewLabel_5.setBounds(179, 43, 298, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u041C\u043E\u0434\u0435\u043B \u043D\u0430 \u043C\u0430\u0448\u0438\u043D\u0430 \u0438\u043B\u0438 \u043A\u043B\u0438\u043C\u0430\u0442\u0438\u043A.");
		lblNewLabel_6.setBounds(179, 93, 298, 14);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u0418\u043C\u0435\u0442\u043E \u043D\u0430 PDF \u0424\u0430\u0439\u043B\u0430 \u0431\u0435\u0437 .pdf ");
		lblNewLabel_7.setBounds(306, 128, 171, 14);
		contentPanel.add(lblNewLabel_7);
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
							// the mysql insert statement
							String query = " insert into subcategory (scatid, catid, scatname, path)" + " values (?, ?, ?, ?)";
							
							// create the mysql insert preparedstatement
							PreparedStatement preparedStmt = conn.prepareStatement(query);
							preparedStmt.setString(1, subcatid.getText());
							preparedStmt.setString(2, subid.getText());
							preparedStmt.setString(3, model.getText());
							preparedStmt.setString(4, ime.getText());
							
							// execute the preparedstatement
							preparedStmt.execute();
							
							conn.close();
						}
						catch (Exception ex)
						{
							JOptionPane.showConfirmDialog(null, "Голема Грешка:" + ex.getMessage() + " ", "Грешка", JOptionPane.ERROR_MESSAGE, 1);
						}
						Object[] options = {"Добре"};
						int input = JOptionPane.showOptionDialog(null,"Успешно добавено раководство.","Успех", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
						if(input == JOptionPane.YES_OPTION)
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
				cancelButton.addActionListener(new ActionListener() {
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
