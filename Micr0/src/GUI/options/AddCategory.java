package GUI.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import GUI.Util.Database;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddCategory extends JDialog
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JFormattedTextField catids;
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
		setBounds(100, 100, 284, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			catids = new JFormattedTextField();
			catids.setBounds(104, 29, 122, 20);
			contentPanel.add(catids);
		}
		{
			catsname = new JFormattedTextField();
			catsname.setBounds(121, 60, 122, 20);
			contentPanel.add(catsname);
		}
		{
			JLabel lblNewLabel = new JLabel("\u041A\u0430\u0442\u0435\u0433\u043E\u0440\u044F ID:");
			lblNewLabel.setToolTipText("\u0410\u043A\u043E \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u044F \"\u0420\u0430\u043A\u043E\u0432\u043E\u0434\u0441\u0442\u0432\u0430\" \u0435  \u0441\u044A\u0441 ID 1 \u0442\u043E \u043F\u0440\u0438\u043C\u0435\u0440 \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u044F \"\u0421\u0445\u0435\u043C\u0438\" \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0435 ID 2.");
			lblNewLabel.setBounds(10, 32, 85, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u0418\u043C\u0435 \u043D\u0430 \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u044F:");
			lblNewLabel_1.setToolTipText("\u041F\u0440\u0438\u043C\u0435\u0440: \u0421\u0445\u0435\u043C\u0438");
			lblNewLabel_1.setBounds(10, 63, 101, 14);
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
							// the mysql insert statement
							String query = " insert into category (catid, catname)" + " values (?, ?)";
							
							// create the mysql insert preparedstatement
							PreparedStatement preparedStmt = conn.prepareStatement(query);
							preparedStmt.setString(1, catids.getText());
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
